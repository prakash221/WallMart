/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.domain.PurchasesItem;
import java.sql.ResultSet;

/**
 *
 * @author dcdip
 */
public interface PurchasesItemsDAO {
    public boolean addPurchesesItem(int PurchaseID, int ProductID, Float pricePerUnit, int quantity);
    public boolean UpdatePurchasesItem(int PurchaseItemID, int PurchaseID, int ProductID, Float pricePerUnit, int quantity);
    public boolean DeletePurchasesItem(int PurchaseItemID);
    public PurchasesItem checkPurchasesItem(int PurchaseItemID);
    public ResultSet ListAllPurchasesItem(int PurchaseID);
}
