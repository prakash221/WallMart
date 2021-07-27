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
public class Product {
    int id;
    String ProductName;
    Float PricePerUnit;
    int stock;
    int IsDiscontinued;
    int CatID;

    public Product() {
    }

    public Product(int id, String ProductName, Float PricePerUnit, int stock,int IsDiscontinued, int CatID) {
        this.id = id;
        this.ProductName = ProductName;
        this.PricePerUnit = PricePerUnit;
        this.stock = stock;
        this.IsDiscontinued = IsDiscontinued;
        this.CatID = CatID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setPricePerUnit(Float PricePerUnit) {
        this.PricePerUnit = PricePerUnit;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setIsDiscontinued(int IsDiscontinued) {
        this.IsDiscontinued = IsDiscontinued;
    }

    public void setCatID(int CatID) {
        this.CatID = CatID;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return ProductName;
    }

    public Float getPricePerUnit() {
        return PricePerUnit;
    }

    public int getStock() {
        return stock;
    }

    public int getIsDiscontinued() {
        return IsDiscontinued;
    }

    public int getCatID() {
        return CatID;
    }
    
    
    
}
