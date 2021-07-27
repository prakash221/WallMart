/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.DAO.ProductDAO;
import com.mycompany.DAO.PurchasesDAO;
import com.mycompany.DAO.PurchasesItemsDAO;
import com.mycompany.DAO.SupplierDAO;
import com.mycompany.domain.Product;
import com.mycompany.domain.Purchases;
import com.mycompany.domain.PurchasesItem;
import com.mycompany.domain.Supplier;
import java.sql.ResultSet;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dcdip
 */
@Controller

public class PurchasesController {
    @Autowired
    PurchasesDAO pud;
    @Autowired
    ProductDAO product;
    @Autowired
    SupplierDAO sup;
    @Autowired
    PurchasesItemsDAO puid;
    
    @RequestMapping(value="Purchases", method = RequestMethod.GET)
    public String PurchasesView(HttpSession session,Model m){
        ResultSet suppliers= sup.ListAllSupplier();
        m.addAttribute("supplier",suppliers);
        m.addAttribute("Purchases", new Purchases());
        return"Purchases";
    }
    @RequestMapping(value="savePurchases", method=RequestMethod.POST)
    public String AddPurchaseItem(HttpSession session, Model m, @ModelAttribute("Purchases") Purchases pu){
        if(pud.addPurcheses(pu.getPurchasesDate(), pu.getSupplierID(), pu.getTotalAmount(),pu.getInvoiceNumber())){
            Purchases pu2 = pud.checkPurchases(pu.getInvoiceNumber());
            Supplier su = sup.checkSupplier(pu2.getSupplierID());
            session.setAttribute("purchasesID", pu2.getId());
            session.setAttribute("InvoiceN", pu2.getInvoiceNumber());
            session.setAttribute("Supplier",su.getCompanyName() );
            session.setAttribute("totalAmount", "0");
            return"redirect: PurchasesItem";
        }
        else
        {
            session.setAttribute("message", "Somthing went wrong");
            return"redirect:Purchases";
        }
    }
    @RequestMapping(value="PurchasesItem",method = RequestMethod.GET)
     public String PurchasesItemView(HttpSession session,Model m){
        
        ResultSet products = product.ListAllProduct();
        m.addAttribute("products",products);
        ResultSet rs = puid.ListAllPurchasesItem((int) session.getAttribute("purchasesID"));
        m.addAttribute("PitemTable", rs);
        m.addAttribute("PurchasesItem", new PurchasesItem());
        return"PurchasesItem";
    }
    
    
    
    @RequestMapping(value="savePurchasesItem", method=RequestMethod.POST)
    public String saveItem(HttpSession session,Model m, @ModelAttribute("PurchasesItem") PurchasesItem pui){
        
        int pid = (int) session.getAttribute("purchasesID");
        if(puid.addPurchesesItem(pid,pui.getProductID() ,pui.getPricePerUnit(),pui.getQuantity())){
            Float total = Float.parseFloat(session.getAttribute("totalAmount").toString());
            Float price =pui.getPricePerUnit();
            int qun = pui.getQuantity();
            Float subtotal = price*qun;
            total=total+subtotal;
            pud.UpdatePurchases(pid, total);
            session.setAttribute("totalAmount", total);
            return"redirect:PurchasesItem";
        }
        else{
            pud.DeletePurchases(pid);
            session.setAttribute("message", "Somthing went wrong please try again");
            return"redirect:PurchasesItem";
        }
        
    }
    
    
}
