/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import static com.mycompany.DAO.DatabaseVeriable.db;
import com.mycompany.domain.PurchasesItem;
import java.sql.ResultSet;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dcdip
 */
@Repository
public class PurchasesItemsDAOImplementation implements PurchasesItemsDAO {

    @Override
    public boolean addPurchesesItem(int PurchaseID, int ProductID, Float pricePerUnit, int quantity) {
        String sql ="INSERT INTO `wallmart_db`.`purchaseitems` (`PurchaseID`, `ProductID`, `UnitPrice`, `Quantity`) VALUES ('"+PurchaseID+"', '"+ProductID+"', '"+pricePerUnit+"', '"+quantity+"');";
        return db.iud(sql);
    }

    @Override
    public boolean UpdatePurchasesItem(int PurchaseItemID, int PurchaseID, int ProductID, Float pricePerUnit, int quantity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DeletePurchasesItem(int PurchaseItemID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PurchasesItem checkPurchasesItem(int PurchaseItemID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet ListAllPurchasesItem(int PurchaseID) {
        String sql ="SELECT pi.PurchaseItemID, pi.ProductID, P.ProductName, pi. PurchaseID, pi. UnitPrice, pi. Quantity FROM wallmart_db.product P Inner join wallmart_db.purchaseitems pi on P.ProductID = pi.ProductID where PurchaseID ="+PurchaseID+";";
        return db.select(sql);
    }
    
}
