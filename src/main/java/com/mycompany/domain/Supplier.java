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
public class Supplier {
    int id;
    String CompanyName;
    String ContactPerson;
    String Address;
    String phoneNumber;
    String Email;
    String VatNumber;

    public Supplier(int id, String CompanyName, String ContactPerson, String Address, String phoneNumber, String Email, String VatNumber) {
        this.id = id;
        this.CompanyName = CompanyName;
        this.ContactPerson = ContactPerson;
        this.Address = Address;
        this.phoneNumber = phoneNumber;
        this.Email = Email;
        this.VatNumber = VatNumber;
    }

    public Supplier() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public void setContactPerson(String ContactPerson) {
        this.ContactPerson = ContactPerson;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setVatNumber(String VatNumber) {
        this.VatNumber = VatNumber;
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getContactPerson() {
        return ContactPerson;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public String getVatNumber() {
        return VatNumber;
    }
    
    
    
}
