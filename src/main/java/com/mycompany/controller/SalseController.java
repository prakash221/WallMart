/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.controller;

import com.mycompany.DAO.CustomerDAO;
import com.mycompany.DAO.ProductDAO;
import com.mycompany.DAO.SalesDAO;
import com.mycompany.DAO.SalseItemDAO;
import com.mycompany.DAO.StockDAO;
import com.mycompany.domain.Customer;
import com.mycompany.domain.Purchases;
import com.mycompany.domain.Sales;
import com.mycompany.domain.SalseItem;
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
public class SalseController {
    @Autowired 
    CustomerDAO cud;
    @Autowired
    SalesDAO sad;
    @Autowired 
    ProductDAO pod;
    @Autowired
    SalseItemDAO sid;
    @Autowired
    StockDAO std;
    
    @RequestMapping(value="/salse", method = RequestMethod.GET)
    public String Salseview(HttpSession session,Model m){
        ResultSet rs = cud.ListAllCustomer();
        m.addAttribute("customerList", rs);
        m.addAttribute("Sales", new Sales());
        return "Salsejsp";
    }
    @RequestMapping (value = "/SaveSales", method=RequestMethod.POST)
    public String SaveSales(HttpSession session, Model m, @ModelAttribute("Sales") Sales su){
        if(sad.addSales(su.getSalesDate(),su.getCustomerID(),0,0, su.getInvoiceNumber())){
            Sales su2 = sad.checkSales(su.getInvoiceNumber());
            Customer cu = cud.checkcustomer(su.getCustomerID());
            session.setAttribute("SalseID", su2.getSalesID());
            session.setAttribute("InvoiceN", su2.getInvoiceNumber());
            session.setAttribute("Customer",cu.getName());
            session.setAttribute("Amount", "0");
            session.setAttribute("Tax", "0");
            session.setAttribute("TotalAmount", "0");
            return"redirect:SalesItem";
        }
        else
        {
            session.setAttribute("message", "Somthing went wrong");
            return"redirect:salse";
        }
    }
    @RequestMapping(value= "/SalesItem", method =RequestMethod.GET)
    public String SalseItemView(HttpSession session, Model m){
        ResultSet rs = pod.ListAllProduct();
        ResultSet rsSalse = sid.ListAllSales((int) session.getAttribute("SalseID"));
        m.addAttribute("SalseItemTable", rsSalse);
        m.addAttribute("ProductList", rs);
        m.addAttribute("SalseItem", new SalseItem());
        return"SalseItem";
    }
    @RequestMapping(value = "/SaveSalseItem", method = RequestMethod.POST)
    public String SaveItem(HttpSession session, @ModelAttribute("SalseItem") SalseItem si){
        if(sid.addSalesItem((int) session.getAttribute("SalseID"), si.getProductID(), si.getUnitPrice(), si.getQuantity())){
            std.removeStock(si.getProductID(), (int) session.getAttribute("warehouseID"), Math.round(si.getQuantity()));
            Float amount = Float.parseFloat(session.getAttribute("Amount").toString());
            Float TAx = Float.parseFloat(session.getAttribute("Tax").toString());
            Float Tamount = Float.parseFloat(session.getAttribute("TotalAmount").toString());
            Float price = si.getUnitPrice();
            Float quantity = si.getQuantity();
            amount = price * quantity;
            TAx = 13 * amount/100;
            Tamount = amount + TAx;
            session.setAttribute("Amount", amount);
            session.setAttribute("Tax", TAx);
            session.setAttribute("TotalAmount", Tamount);
            if(sad.UpdateSales((int) session.getAttribute("SalseID"), amount, TAx)){
               
                return"redirect:SalesItem";
            }
            else{
                session.setAttribute("message", "Salse tabe is not able to update information.");
                return"redirect:SalesItem";
            }
        }
         session.setAttribute("message", "error occure during adding item");
         return"SalesItem";
    }
    
}
