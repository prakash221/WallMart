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
public class Sales {

    int SalesID;
    String SalesDate;
    int CustomerID;
    int Amount;
    int TAXAmount;
    String InvoiceNumber;

    public Sales() {
    }

    public Sales(int SalesID, String SalesDate, int CustomerID, int Amount, int TAXAmount, String InvoiceNumber) {
        this.SalesID = SalesID;
        this.SalesDate = SalesDate;
        this.CustomerID = CustomerID;
        this.Amount = Amount;
        this.TAXAmount = TAXAmount;
        this.InvoiceNumber = InvoiceNumber;
    }

    public void setSalesID(int SalesID) {
        this.SalesID = SalesID;
    }

    public void setSalesDate(String SalesDate) {
        this.SalesDate = SalesDate;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public void setTAXAmount(int TAXAmount) {
        this.TAXAmount = TAXAmount;
    }

    public void setInvoiceNumber(String InvoiceNumber) {
        this.InvoiceNumber = InvoiceNumber;
    }

    public int getSalesID() {
        return SalesID;
    }

    public String getSalesDate() {
        return SalesDate;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public int getAmount() {
        return Amount;
    }

    public int getTAXAmount() {
        return TAXAmount;
    }

    public String getInvoiceNumber() {
        return InvoiceNumber;
    }

}
