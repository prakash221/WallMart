/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import static com.mycompany.DAO.DatabaseVeriable.db;
import com.mycompany.domain.ProductCategory;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dcdip
 */
@Repository
public class ProductCatogaryDAOImplementation implements ProductCatogaryDAO{

    @Override
    public boolean addProductCat(String catName) {
        String sql = "INSERT INTO `wallmart_db`.`productcategory` (`CategoryName`) VALUES ('"+catName+"');";
        return db.iud(sql);
    }

    @Override
    public boolean UpdateProductCat(int id, String catName) {
        String sql = "UPDATE `wallmart_db`.`productcategory` SET `CategoryName` = '"+catName+"' WHERE (`CategoryID` = '"+id+"');";
        return db.iud(sql);
    }

    @Override
    public boolean DeleteProductCatr(int id) {
        String sql = "Delete from `wallmart_db`.`productcategory` WHERE CategoryID ="+id+";";
        return db.iud(sql);

    }

    @Override
    public ProductCategory checkProductCat(int id) {
        String sql = "select * from `wallmart_db`.`productcategory` where CategoryID ="+id+";";
        ResultSet rs = db.select(sql);
        try {
            while(rs.next()) {
                ProductCategory pc = new ProductCategory(rs.getInt(1), rs.getString(2));
                return pc;
            }
           
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    @Override
    public ResultSet ListAllProductCat() {
        String sql = "select * from `wallmart_db`.`productcategory`;";
        return db.select(sql);
    }
    
}
