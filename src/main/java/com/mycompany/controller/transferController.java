/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.DAO.ProductDAO;
import com.mycompany.DAO.TransferDAO;
import com.mycompany.DAO.WareHouseDAO;
import com.mycompany.command.TransferStock;
import java.lang.reflect.Method;
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
public class transferController {
    @Autowired 
    ProductDAO pod;
    @Autowired
    WareHouseDAO whd;
    @Autowired
    TransferDAO td;
    @RequestMapping(value="/transferStock")
    String transferView(Model m, HttpSession session){
        ResultSet rsp = pod.ListAllProduct();
        m.addAttribute("Productlist", rsp);
        ResultSet rsw = whd.listAllWareHouse();
        m.addAttribute("warehouse1", rsw);
        ResultSet rsw2 = whd.listAllWareHouse();
        m.addAttribute("warehouse", rsw2);
        m.addAttribute("transferStock", new TransferStock());
        return "transferStock";
    }
    @RequestMapping(value="/TransferStock", method = RequestMethod.POST)
    String ProcessTransfer(HttpSession session, @ModelAttribute("transferStock") TransferStock ts){
        if(td.transferStock(ts.getFromId(), ts.getToID(), ts.getProductID(), ts.getQuantity())){
            return"redirect:transferStock";
        }
        else{
            session.setAttribute("message","Somthing went wrong" );
            return"redirect:transferStock";
            
        }
    }
    
}
