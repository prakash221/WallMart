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
public class Purchases {
    int id;
    String PurchasesDate;
    int supplierID;
    Float totalAmount;
    String invoiceNumber;

    public Purchases(int id, String PurchasesDate, int supplierID, Float totalAmount, String invoiceNumber) {
        this.id = id;
        this.PurchasesDate = PurchasesDate;
        this.supplierID = supplierID;
        this.totalAmount = totalAmount;
        this.invoiceNumber = invoiceNumber;
    }

    public Purchases() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPurchasesDate(String PurchasesDate) {
        this.PurchasesDate = PurchasesDate;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public int getId() {
        return id;
    }

    public String getPurchasesDate() {
        return PurchasesDate;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }
    
}
