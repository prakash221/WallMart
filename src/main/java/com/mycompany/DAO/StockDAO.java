/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.domain.Stock;
import java.sql.ResultSet;

/**
 *
 * @author dcdip
 */
public interface StockDAO {
    public boolean addStock(int ProductID, int WareHouseID, int Quantity);
    public boolean UpdateStock(int ProductID, int WareHouseID, int Quantity);
    public boolean removeStock(int ProductID, int WareHouseID, int Quantity);
    public boolean DeleteStock(int ID);
    public Stock checkStock(int ProductID, int WareHouseID);
    public ResultSet ListAllStock();
    
}
