/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.domain.ProductCategory;
import java.sql.ResultSet;

/**
 *
 * @author dcdip
 */
public interface ProductCatogaryDAO {
    public boolean addProductCat(String catName);
    public boolean UpdateProductCat(int id, String catName);
    public boolean DeleteProductCatr(int id);
    public ProductCategory checkProductCat(int id);
    public ResultSet ListAllProductCat();
}
