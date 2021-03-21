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
            
            if(cudo.DeleteCustomer(id)){
                session.setAttribute("message","Customer deleted successfully");
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
    @RequestMapping(value="/addNewCustomer", method =RequestMethod.POST )
    public String Addcustomer(@ModelAttribute("CustomerNew") Customer cu , HttpSession session){
        if(session.getAttribute("UserName")!=null){
            session.removeAttribute("message");
            if(cudo.addCustomer(cu.getName(), cu.getPhone(), cu.getEmail(), cu.getAddress(), cu.getPANNumber())){
                session.setAttribute("message", "New customer Added successfully");
                return"redirect:customer";
                
            }
            else{
                session.setAttribute("message", "Some error ocured please try again");
                return"redirect:customer";
            }
        }
        else
        {
            session.setAttribute("message", "You need to login first MF.");
            return "redirect: login";
        }
    
    
    }
    
}
