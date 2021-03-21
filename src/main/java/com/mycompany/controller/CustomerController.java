/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;


import com.mycompany.DAO.CustomerDAO;
import com.mycompany.domain.Customer;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author dcdip
 */
@Controller
public class CustomerController {
    @Autowired
    CustomerDAO cudo;
    @RequestMapping(value ="/customer", method=RequestMethod.GET)
        public String Customer( Model m, HttpSession session){
            
            if (session.getAttribute("UserName")!=null){
                ResultSet rs = cudo.ListAllCustomer();
                
                m.addAttribute("table", rs);
                m.addAttribute("CustomerNew",new Customer());
                return "customer";
            }
            else{
                return"redirect: login";
            }
        }
    @RequestMapping(value="/deleteCustomer", method = RequestMethod.GET)
    public String DeleteCustomer( HttpServletRequest req, Model m, HttpSession session){
        int id =Integer.parseInt(req.getParameter("id"));
        if(session.getAttribute("UserName")!=null){
            session.setAttribute("action", "addNewCustomers");
            if(cudo.DeleteCustomer(id)){
                session.setAttribute("message","Customer deleted successfully");
                session.setAttribute("Show", "");
                return"redirect:customer";
            }else{
                session.setAttribute("message",id);
                return"redirect:customer";
            }
            
        }
        else
        {
            return "redirect: login";
        }
    }
    @RequestMapping(value ="/addNewCus", method=RequestMethod.GET)
        public String CustomerNew( Model m, HttpSession session){
            session.setAttribute("Show", "show");
            if (session.getAttribute("UserName")!=null){
                m.addAttribute("CustomerNew",new Customer());
                session.setAttribute("action","addNewCustomers" );
                return "redirect: customer";
            }
            else{
                return"redirect: login";
            }
        }
    
    @RequestMapping(value="/addNewCustomers", method =RequestMethod.POST )
    public String Addcustomer(@ModelAttribute("CustomerNew") Customer cu , HttpSession session){
        if(session.getAttribute("UserName")!=null){
            session.removeAttribute("message");
            if(cudo.addCustomer(cu.getName(), cu.getPhone(), cu.getEmail(), cu.getAddress(), cu.getPANNumber())){
                session.setAttribute("message", "New customer Added successfully");
                session.removeAttribute("Show");
                return"redirect:customer";
                
            }
            else{
                session.setAttribute("message", "Some error ocured please try again");
                return"redirect:customer";
            }
        }
        else
        {
            session.setAttribute("message", "You need to login first");
            return "redirect: login";
        }
    
    
    }
    @RequestMapping(value="/editCustomer",method = RequestMethod.GET)
    public String EditCustomer( HttpServletRequest req, Model m, HttpSession session){
        session.removeAttribute("action");
        int id =Integer.parseInt(req.getParameter("id"));
        if(session.getAttribute("UserName")!=null){
                session.setAttribute("action", "editCustomerDetails");
            Customer cu =cudo.checkcustomer(id);
            if(cu!=null){
                session.setAttribute("action", "editCustomerDetails");
                session.setAttribute("Show", "show");
                session.setAttribute("id",cu.getId());
                session.setAttribute("CName",cu.getName());
                session.setAttribute("Phone",cu.getPhone());
                session.setAttribute("Email",cu.getEmail());
                session.setAttribute("Address",cu.getAddress());
                session.setAttribute("PANNumber",cu.getPANNumber());
                return"redirect:customer";
            }else{
                session.setAttribute("message",id);
                return"zcustomer";
            }
            
        }
        else
        {
            return "redirect: login";
        }
    }
    @RequestMapping(value="/editCustomerDetails", method =RequestMethod.POST )
    public String EditCustomer(@ModelAttribute("CustomerNew") Customer cu , HttpSession session){
        session.setAttribute("action", "addNewCustomers");
        session.removeAttribute("Show");
        int id =Integer.parseInt(session.getAttribute("id").toString());
        if(session.getAttribute("UserName")!=null){
            
            if(cudo.UpdateCustomer( id,cu.getName(), cu.getPhone(), cu.getEmail(), cu.getAddress(), cu.getPANNumber())){
                session.setAttribute("message", " customer edited successfully");
                session.setAttribute("action", "addNewCustomers");
                session.removeAttribute("Show");
                session.removeAttribute("id");
                session.removeAttribute("CName");
                session.removeAttribute("Phone");
                session.removeAttribute("Email");
                session.removeAttribute("Address");
                session.removeAttribute("PANNumber");
                return"redirect:customer";
                
            }
            else{
                session.setAttribute("message", "Some error ocured please try again");
                return"redirect:customer";
            }
        }
        else
        {
            session.setAttribute("message", "You need to login first");
            return "redirect: login";
        }
    
    
    }
}
