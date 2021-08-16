/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import static com.mycompany.DAO.DatabaseVeriable.db;
import com.mycompany.domain.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dcdip
 */
@Repository
public class ProductDAOImplementation implements ProductDAO {

    @Override
    public boolean addProduct(String ProductName, Float PricePerUnit, int stock, int CatID) {
        String sql = "INSERT INTO `wallmart_db`.`product` (`ProductName`, `PricePerKgUnit`, `AvailableQuantity`, `IsDiscontinued`, `CategoryID`) VALUES ('" + ProductName + "', '" + PricePerUnit + "', '" + stock + "', '1', '" + CatID + "');";
        return db.iud(sql);
    }

    @Override
    public boolean UpdateProduct(int id, String ProductName, Float PricePerUnit, int stock, int CatID) {
        String sql = "UPDATE `wallmart_db`.`product` SET `ProductName` = '" + ProductName + "', `PricePerKgUnit` = '" + PricePerUnit + "', `AvailableQuantity` = '" + stock + "', `CategoryID` = '" + CatID + "' WHERE (`ProductID` = '" + id + "');";
        return db.iud(sql);
    }

    @Override
    public boolean DeleteProduct(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product checkProduct(int id) {
        String sql = "SELECT * FROM wallmart_db.product where ProductID =" + id + ";";
        ResultSet rs = db.select(sql);
        try {
            while (rs.next()) {
                Product pc = new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                return pc;
            }

        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    @Override
    public ResultSet ListAllProduct() {
        String sql = "SELECT P.ProductID, P.ProductName, P.PricePerKgUnit, P.AvailableQuantity,pc.CategoryID, pc.CategoryName FROM wallmart_db.product P Inner join wallmart_db.productcategory pc on P.CategoryID = pc. CategoryID;";
        return db.select(sql);
    }

    @Override
    public boolean updateStock(int id, int stock) {
        Product pc = checkProduct(id);
        int totalStock =pc.getStock();
        totalStock = totalStock+stock;
        String sql2 = "Update wallmart_db.product set `AvailableQuantity` = '" + totalStock + "' where ProductID ='" + id + "';";
        if (db.iud(sql2)){
            return true;
        }
        else{
            return false;
        }
        
    }

}
