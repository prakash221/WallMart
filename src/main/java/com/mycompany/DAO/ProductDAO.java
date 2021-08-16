/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.domain.Product;
import java.sql.ResultSet;

/**
 *
 * @author dcdip
 */
public interface ProductDAO {
    public boolean addProduct(String ProductName, Float PricePerUnit, int stock, int CatID);
    public boolean UpdateProduct(int id, String ProductName, Float PricePerUnit, int stock, int CatID);
    public boolean DeleteProduct(int id);
    public Product checkProduct(int id);
    public boolean updateStock(int id, int stock);
    public ResultSet ListAllProduct();
}
