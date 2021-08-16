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
public class WareHouse {
    int ID;
    String Location;
    String ContactNumber;

    public WareHouse(int ID, String Location, String ContactNumber) {
        this.ID = ID;
        this.Location = Location;
        this.ContactNumber = ContactNumber;
    }

    public WareHouse() {
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public void setContactNumber(String ContactNumber) {
        this.ContactNumber = ContactNumber;
    }

    public int getID() {
        return ID;
    }

    public String getLocation() {
        return Location;
    }

    public String getContactNumber() {
        return ContactNumber;
    }
    
}
