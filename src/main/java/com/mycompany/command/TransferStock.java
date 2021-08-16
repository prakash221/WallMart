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
public class TransferStock {
    int fromId;
    int toID;
    int productID;
    int quantity;

    public TransferStock() {
    }

    public TransferStock(int fromId, int toID, int productID, int quantity) {
        this.fromId = fromId;
        this.toID = toID;
        this.productID = productID;
        this.quantity = quantity;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public void setToID(int toID) {
        this.toID = toID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getFromId() {
        return fromId;
    }

    public int getToID() {
        return toID;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }
    
}
