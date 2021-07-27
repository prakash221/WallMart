/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.DAO.ProductCatogaryDAO;
import com.mycompany.DAO.ProductDAO;
import com.mycompany.domain.Product;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
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
public class ProductController {
    @Autowired
    ProductDAO pd;
    @Autowired
    ProductCatogaryDAO pcd;
    @RequestMapping(value="/Product",method=RequestMethod.GET)
    public String ProductLoad(HttpSession session, Model m){
        if(session.getAttribute("UserName")!=null){
            ResultSet rs = pd.ListAllProduct();
            ResultSet rsp = pcd.ListAllProductCat();
            m.addAttribute("CatTable", rsp);
            m.addAttribute("Product", new Product());
            m.addAttribute("ProductTable", rs);
            return "Product";
        }
        else{
            return"redirect:login";
        }
    }
    
    @RequestMapping(value="/addNewProduct", method = RequestMethod.GET)
    public String addnewProduct(HttpSession session, Model m){
        ResultSet rsp = pcd.ListAllProductCat();
        m.addAttribute("Product", new Product());
        m.addAttribute("CatTable", rsp);
        session.setAttribute("Show", "show");
        session.setAttribute("action", "SaveNewProduct");
        return "redirect:Product";
        
        
    }
    @RequestMapping(value="/SaveNewProduct", method = RequestMethod.POST)
    public String SaveNewProduct(HttpSession session, @ModelAttribute("Product") Product pr){
            session.removeAttribute("Show");
            session.removeAttribute("action");
        if(pd.addProduct(pr.getProductName(), pr.getPricePerUnit(),pr.getStock(),pr.getCatID())){
            
            session.setAttribute("message", "New product Added successfully");
            return "redirect:Product";
        }
        else{
            session.setAttribute("message","Sommting went wrong failed to add a new product try again.");
            return "redirect:Product";
        }
            
    }
    @RequestMapping(value = "/editProduct", method = RequestMethod.GET)
    public String editProduct(HttpServletRequest req, HttpSession session, Model m){
        int id =Integer.parseInt(req.getParameter("id"));
        session.setAttribute("action", "saveEditProduct");
        session.setAttribute("Show", "show");
        if(pd.checkProduct(id)!=null){
            Product pr =pd.checkProduct(id);
            session.setAttribute("ProductName", pr.getProductName());
            session.setAttribute("stock", pr.getStock());
            session.setAttribute("Price", pr.getPricePerUnit());
            session.setAttribute("id", id);
            
            return"redirect:Product";
        }
        else{
            session.setAttribute("message", "Somthing went wrong plese try again");
            return"redirect:Product";
        }
            
    }
    @RequestMapping(value = "/saveEditProduct", method = RequestMethod.POST)
    public String saveEditProduct(HttpSession session, @ModelAttribute("Product") Product pr){
        session.removeAttribute("Show");
            session.removeAttribute("action");
        if(pd.addProduct(pr.getProductName(), pr.getPricePerUnit(),pr.getStock(),pr.getCatID())){
            
            session.setAttribute("message", "Product edited successfully");
            return "redirect:Product";
        }
        else{
            session.setAttribute("message","Sommting went wrong failed to add a new product try again.");
            return "redirect:Product";
        }
    }
}
