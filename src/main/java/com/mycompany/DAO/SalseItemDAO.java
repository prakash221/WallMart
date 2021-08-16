/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;


import com.mycompany.domain.SalseItem;
import java.sql.ResultSet;

/**
 *
 * @author dcdip
 */
public interface SalseItemDAO {
    public boolean addSalesItem(int SalesID,int ProductID, Float UnitPrice, Float Quantity);
    public boolean UpdateSalesItem(int id);
    public boolean DeleteSalesItem(int id);
    public SalseItem checkSalesItem(int id);
    public ResultSet ListAllSales(int SalesID);
}
