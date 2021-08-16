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
public class Stock {
    int ID;
    int ProductID;
    int WareHouseID;
    int Quantity;

    public Stock() {
    }

    public Stock(int ID, int ProductID, int WareHouseID, int Quantity) {
        this.ID = ID;
        this.ProductID = ProductID;
        this.WareHouseID = WareHouseID;
        this.Quantity = Quantity;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public void setWareHouseID(int WareHouseID) {
        this.WareHouseID = WareHouseID;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    
    public int getID() {
        return ID;
    }

    public int getProductID() {
        return ProductID;
    }

    public int getWareHouseID() {
        return WareHouseID;
    }

    public int getQuantity() {
        return Quantity;
    }
    
    
}
