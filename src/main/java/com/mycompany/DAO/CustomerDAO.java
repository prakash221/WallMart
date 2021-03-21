/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.domain.Customer;
import java.sql.ResultSet;

/**
 *
 * @author dcdip
 */
public interface CustomerDAO {
    public boolean addCustomer(String Name, String Phone, String Email, String Address, String PANNumber);
    public boolean UpdateCustomer(int id, String Name, String Phone, String Email, String Address, String PANNumber);
    public boolean DeleteCustomer(int id);
    public Customer checkcustomer(int id);
    public ResultSet ListAllCustomer();
    
}
