/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.domain.Users;

/**
 *
 * @author dcdip
 */
public interface UsersDAO {
    public boolean addUser(String FullName,String Email,String UserName, String Password, int IsAdmin);
    public boolean login(String userName, String Password);
    public boolean Deleteuser(String userName);
    public Users checkUser(String urn);
    
}
