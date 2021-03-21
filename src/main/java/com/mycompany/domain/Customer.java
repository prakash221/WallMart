/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.domain;

/**
 *
 * @author dcdip
 */
public class Customer {
    int id;
    String Name;
    String Phone;
    String Email;
    String Address;
    String PANNumber;

    public Customer() {
    }

    public Customer(int id, String Name, String Phone, String Email, String Address, String PANNumber) {
        this.id = id;
        this.Name = Name;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.PANNumber = PANNumber;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setPANNumber(String PANNumber) {
        this.PANNumber = PANNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }

    public String getEmail() {
        return Email;
    }

    public String getAddress() {
        return Address;
    }

    public String getPANNumber() {
        return PANNumber;
    }
    
    
}
