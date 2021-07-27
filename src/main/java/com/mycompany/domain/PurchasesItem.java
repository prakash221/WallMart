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
public class PurchasesItem {
    int PurchaseItemID;
    int PurchaseID;
    int ProductID;
    Float pricePerUnit;
    int quantity;

    public PurchasesItem(int PurchaseItemID, int PurchaseID, int ProductID, Float pricePerUnit, int quantity) {
        this.PurchaseItemID = PurchaseItemID;
        this.PurchaseID = PurchaseID;
        this.ProductID = ProductID;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
    }

    public PurchasesItem() {
    }

    public void setPurchaseItemID(int PurchaseItemID) {
        this.PurchaseItemID = PurchaseItemID;
    }

    public void setPurchaseID(int PurchaseID) {
        this.PurchaseID = PurchaseID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public void setPricePerUnit(Float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPurchaseItemID() {
        return PurchaseItemID;
    }

    public int getPurchaseID() {
        return PurchaseID;
    }

    public int getProductID() {
        return ProductID;
    }

    public Float getPricePerUnit() {
        return pricePerUnit;
    }

    public int getQuantity() {
        return quantity;
    }
    
}
