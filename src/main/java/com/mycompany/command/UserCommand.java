/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.command;

/**
 *
 * @author dcdip
 */
public class UserCommand {
    String FullName;
    String Email;
    String UserName;
    String Password;
    int IsAdmin;

    public UserCommand() {
    }

    public String getFullName() {
        return FullName;
    }

    public String getEmail() {
        return Email;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public int getIsAdmin() {
        return IsAdmin;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setIsAdmin(int IsAdmin) {
        this.IsAdmin = IsAdmin;
    }
    
    
}
