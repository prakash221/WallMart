/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.DAO.ProductCatogaryDAO;
import com.mycompany.domain.ProductCategory;
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
public class ProductCatController {
    @Autowired
    ProductCatogaryDAO PCD;
    @RequestMapping(value="/AddProductCat",method=RequestMethod.GET)
    public String productCatMain(HttpSession session, Model m){
        
        if(session.getAttribute("UserName")!=null){
            ResultSet rs = PCD.ListAllCustomer();
            m.addAttribute("ProductCatSave",new ProductCategory() );
            m.addAttribute("PCTable",rs);
            return "ProductCategory";
        }
        {
            session.setAttribute("message", "You need to login first");
            return "redirect:login";
        }
    }
    
    @RequestMapping(value="/ProductCat",method=RequestMethod.GET)
    public String newProductCat(HttpSession session, Model m){
        m.addAttribute("ProductCatSave",new ProductCategory() );
        session.setAttribute("Show", "show");
        session.setAttribute("action", "addNewProductCat");
        
        return "redirect:AddProductCat";
    }
    
    @RequestMapping(value="/addNewProductCat",method=RequestMethod.POST)
    public String newProductCatSave(HttpSession session, @ModelAttribute("ProductCatSave") ProductCategory pc){
        session.removeAttribute("Show");
        session.removeAttribute("action");
        PCD.addProductCat(pc.getCatName());
        session.setAttribute("message", "Product Catogery added successfully");
        return "redirect:AddProductCat";
    }
    
    @RequestMapping(value="/editProductCat",method = RequestMethod.GET)
    public String EditProductCat( HttpServletRequest req, Model m, HttpSession session){
        session.removeAttribute("action");
        int id =Integer.parseInt(req.getParameter("id"));
        if(session.getAttribute("UserName")!=null){
                session.setAttribute("action", "editCustomerDetails");
            ProductCategory pc =PCD.checkProductCat(id);
            if(pc!=null){
                session.setAttribute("action", "saveEditProductCat");
                session.setAttribute("Show", "show");
                session.setAttribute("id",pc.getId());
                session.setAttribute("CatName",pc.getCatName());
                return"redirect:AddProductCat";
            }else{
                session.setAttribute("message","Somthing went wrong");
                return"AddProductCat";
            }
            
        }
        else
        {
            return "redirect: login";
        }
    }
    @RequestMapping(value="/saveEditProductCat", method =RequestMethod.POST )
    public String EditProductCat(@ModelAttribute("ProductCatSave") ProductCategory pc , HttpSession session){
        if(session.getAttribute("UserName")!=null){
        session.setAttribute("action", "addNewProductCat");
        session.removeAttribute("Show");
        int id =Integer.parseInt(session.getAttribute("id").toString());
        
            
            if(PCD.UpdateProductCat(id, pc.getCatName())){
                session.setAttribute("message", " Product Category edited successfully");
                session.setAttribute("action", "addNewProductCat");
                session.removeAttribute("Show");
                session.removeAttribute("id");
                session.removeAttribute("CatName");
                return"redirect:AddProductCat";
                
            }
            else{
                session.setAttribute("message", id);
                return"redirect:AddProductCat";
            }
        }
        else
        {
            session.setAttribute("message", "You need to login first");
            return "redirect: login";
        }
    
    
    }
}
    

