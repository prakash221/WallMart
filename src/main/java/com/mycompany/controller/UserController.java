/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;



//import javax.enterprise.inject.Model;
import com.mycompany.DAO.UsersDAO;
import com.mycompany.command.UserCommand;
import com.mycompany.domain.Users;
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
public class UserController {
    @Autowired
    UsersDAO ud;
    @RequestMapping(value="/")
    public String login(Model m, HttpSession session){
        m.addAttribute("command",new UserCommand());
        
        return "redirect:dashboard";
    }
    @RequestMapping(value="/login")
    public String loginForm(Model m, HttpSession session){
        if(session.getAttribute("UserName")!=null){
        return "redirect:dashboard";
        }
        m.addAttribute("command",new UserCommand());
        session.invalidate();
        return "login";
        
    }
    @RequestMapping(value ="/loginProcess",method=RequestMethod.POST )
    public String loginProcess(@ModelAttribute("command") UserCommand uc, Model m, HttpSession session){
        
        if(ud.login(uc.getUserName(), uc.getPassword())){
            Users urs = ud.checkUser(uc.getUserName());
            session.setAttribute("UserName", uc.getUserName());
            session.setAttribute("Admin", urs.getIsAdmin());
            session.setAttribute("Name",urs.getFullName());
            session.setAttribute("warehouseID", urs.getWareHouseID());
            return "redirect:dashboard"; 
        }
        else{
            m.addAttribute("message", "invlid login");
            return "login";
        }
            
    }
    
    @RequestMapping("/dashboard")
    public String dash(Model m, HttpSession session){
        if(session.getAttribute("UserName")!=null)
        {
        
        return "dashboard";
        }
        else{
            return"redirect:login";
        }
        
    }
    
    @RequestMapping(value = "/logout")
    public String logout(Model m, HttpSession session){
        session.invalidate();
        return "redirect:login";
    }
    
    
}
