/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.domain.Purchases;
import com.mycompany.domain.Sales;
import java.sql.ResultSet;

/**
 *
 * @author dcdip
 */

public interface SalesDAO {
    public boolean addSales(String SalesDate, int CustomerID, int Amount, int TAXAmount, String InvoiceNumber);
    public boolean UpdateSales(int id, Float Amount, Float tax);
    public boolean DeleteSales(int id);
    public Sales checkSales(String invoiceNumber);
    public ResultSet ListAllSales();
    
}
