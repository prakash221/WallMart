/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.DAO.SupplierDAO;
import com.mycompany.domain.Supplier;
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
public class SupplierController {
    @Autowired
    SupplierDAO sud;
    
    @RequestMapping(value="/supplier",method=RequestMethod.GET)
    public String MainView(HttpSession session, Model m){
        if(session.getAttribute("UserName")!=null){
            ResultSet rs = sud.ListAllSupplier();
            m.addAttribute("Supplier",new Supplier() );
            m.addAttribute("SupTable",rs);
            return "supplier";
        }
        {
            session.setAttribute("message", "You need to login first");
            return "redirect:login";
        }
    }
    
    @RequestMapping(value="/SupplierNew",method=RequestMethod.GET)
    public String showNewSupplierForm(HttpSession session, Model m){
        session.setAttribute("Show", "show");
        session.setAttribute("action", "SaveSupplier");
        return"redirect:supplier";
    }
    
    @RequestMapping(value="/SaveSupplier", method = RequestMethod.POST)
    public String saveNewSupplier(HttpSession session, @ModelAttribute("Supplier") Supplier su){
        session.removeAttribute("Show");
        session.removeAttribute("action");
        if(sud.addSupplier(su.getCompanyName(), su.getContactPerson(), su.getAddress(), su.getPhoneNumber(),su.getEmail(), su.getVatNumber())){
            session.setAttribute("message", "Supplier added successfully.");
            return "redirect: supplier";
        }
        else
        {
            session.setAttribute("message", "Somthing went wrong");
            return "redirect: supplier";
        }
    }
    
    @RequestMapping(value="editSuplier", method = RequestMethod.GET)
    public String editSupplierView(HttpServletRequest req, HttpSession session, Model m){
        session.removeAttribute("action");
        int id =Integer.parseInt(req.getParameter("id"));
        session.setAttribute("Show", "show");
        session.setAttribute("action", "saveEditSupplier");
        Supplier su = sud.checkSupplier(id);
        session.setAttribute("id", su.getId());
        session.setAttribute("CompanyName", su.getCompanyName());
        session.setAttribute("ContactPerson", su.getContactPerson());
        session.setAttribute("PhoneNumber", su.getPhoneNumber());
        session.setAttribute("Address", su.getAddress());
        session.setAttribute("Email", su.getEmail());
        session.setAttribute("VatNumber", su.getVatNumber());
        return "redirect: supplier";
        
    }
    
    @RequestMapping(value="saveEditSupplier", method =RequestMethod.POST)
    public String saveEditSupplier(HttpSession session, @ModelAttribute("Supplier") Supplier su){
        session.removeAttribute("Show");
        int id =Integer.parseInt(session.getAttribute("id").toString());
        if(sud.UpdateSupplier(id, su.getCompanyName(), su.getContactPerson(), su.getAddress(), su.getPhoneNumber(), su.getEmail(), su.getVatNumber())){
            session.setAttribute("message", "Supplier edited successfully.");
            return"redirect: supplier";
        }
        else{
            session.setAttribute("message", "Somthing went wrong.");
            return"redirect: supplier";
        }
        
    }
    
}
