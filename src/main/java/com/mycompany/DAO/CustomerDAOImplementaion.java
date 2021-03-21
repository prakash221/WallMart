/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import static com.mycompany.DAO.DatabaseVeriable.db;
import com.mycompany.domain.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dcdip
 */
@Repository
public class CustomerDAOImplementaion implements CustomerDAO {

    @Override
    public boolean addCustomer(String Name, String Phone, String Email, String Address, String PANNumber) {
        String sql = "INSERT INTO `wallmart_db`.`customers` (`CustomerName`, `Phone`, `Email`, `Address`, `PANNumber`) VALUES ('" + Name + "', '" + Phone + "', '" + Email + "', '" + Address + "', '" + PANNumber + "');";
        return db.iud(sql);
    }

    @Override
    public boolean UpdateCustomer(int id, String Name, String Phone, String Email, String Address, String PANNumber) {
        String sql ="UPDATE `wallmart_db`.`customers` SET `CustomerName` = '"+Name+"', `Phone` = '"+Phone+"', `Email` = '"+Email+"', `Address` = '"+Address+"', `PANNumber` = '"+PANNumber+"' WHERE (`CustomerID` = '"+id+"');";
        return db.iud(sql);
    }

    @Override
    public boolean DeleteCustomer(int id) {
        String sql = "delete from wallmart_db.customers where CustomerID ='" + id + "';";
        return db.iud(sql);

    }

    @Override
    public Customer checkcustomer(int id) {
        String sql = "select * from wallmart_db.customers where CustomerID ='" + id + "';";
        ResultSet rs = db.select(sql);
        try {
            while(rs.next()) {
                Customer cu = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                return cu;
            }
           
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    @Override
    public ResultSet ListAllCustomer() {
        String sql = "select * from wallmart_db.customers;";
        return db.select(sql);
    }

}
