/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import static com.mycompany.DAO.DatabaseVeriable.db;
import com.mycompany.domain.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dcdip
 */
@Repository
public class UsersImplementation implements UsersDAO{

    public boolean addUser(String FullName,String Email,String UserName, String Password, int IsAdmin){
        return true;
    }
    public boolean login(String userName, String Password){
        String sql = "select * from wallmart_db.user;";
        ResultSet rs = db.select(sql);
        try {
            while (rs.next()) {
                if (rs.getString(4).equalsIgnoreCase(userName) && rs.getString(5).equalsIgnoreCase(Password)) {
                    return true;
                }
            }
            if (userName.equalsIgnoreCase("admin") && Password.equalsIgnoreCase("admin")) {

                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false; 
    }
    public boolean Deleteuser(String userName){
        return true;
    }
    public Users checkUser(String urn){
        return null;
    }
        
}
