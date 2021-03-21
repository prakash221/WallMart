/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import static com.mycompany.DAO.DatabaseVeriable.db;
import com.mycompany.domain.Customer;
import java.sql.ResultSet;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dcdip
 */
@Repository
public class CustomerDAOImplementaion implements CustomerDAO {

    @Override
    public boolean addCustomer(String Name, String Phone, String Email, String Address, String PANNumber) {
        String sql ="INSERT INTO `wallmart_db`.`customers` (`CustomerName`, `Phone`, `Email`, `Address`, `PANNumber`) VALUES ('"+Name+"', '"+Phone+"', '"+Email+"', '"+Address+"', '"+PANNumber+"');";
        return db.iud(sql);
    } 
    
    @Override
    public boolean UpdateCustomer() {
        return true;
    }

    @Override
    public boolean DeleteCustomer(int urn) {
        String sql = "delete from wallmart_db.customers where CustomerID ='"+urn+"';";
        return db.iud(sql);
        
    }

    @Override
    public Customer checkcustomer(int urn) {
        return null;
    }

    @Override
    public ResultSet ListAllCustomer() {
        String sql = "select * from wallmart_db.customers;";
        return db.select(sql);
    }

    
    
}
