/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.domain.Purchases;
import java.sql.ResultSet;

/**
 *
 * @author dcdip
 */
public interface PurchasesDAO {
    public boolean addPurcheses(String PurchasesDate,int supplierID, Float totalAmount, String invoiceNumber);
    public boolean UpdatePurchases(int id, Float totalAmount);
    public boolean DeletePurchases(int id);
    public Purchases checkPurchases(String invoiceNumber);
    public ResultSet ListAllPurchases();
    
}
