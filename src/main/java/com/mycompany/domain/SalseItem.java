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
public class SalseItem {
    int SalesItemID;
    int SalesID;
    int ProductID;
    Float UnitPrice;
    Float Quantity;

    public void setSalesItemID(int SalesItemID) {
        this.SalesItemID = SalesItemID;
    }

    public void setSalesID(int SalesID) {
        this.SalesID = SalesID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public void setUnitPrice(Float UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public void setQuantity(Float Quantity) {
        this.Quantity = Quantity;
    }

    public int getSalesItemID() {
        return SalesItemID;
    }

    public int getSalesID() {
        return SalesID;
    }

    public int getProductID() {
        return ProductID;
    }

    public Float getUnitPrice() {
        return UnitPrice;
    }

    public Float getQuantity() {
        return Quantity;
    }

    public SalseItem() {
    }

    public SalseItem(int SalesItemID, int SalesID, int ProductID, Float UnitPrice, Float Quantity) {
        this.SalesItemID = SalesItemID;
        this.SalesID = SalesID;
        this.ProductID = ProductID;
        this.UnitPrice = UnitPrice;
        this.Quantity = Quantity;
    }
    
}
