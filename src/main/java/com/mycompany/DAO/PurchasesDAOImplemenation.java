/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import static com.mycompany.DAO.DatabaseVeriable.db;
import com.mycompany.domain.Purchases;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dcdip
 */
@Repository
public class PurchasesDAOImplemenation implements PurchasesDAO{

    @Override
    public boolean addPurcheses(String PurchasesDate, int supplierID, Float totalAmount, String invoiceNumber) {
        String sql ="INSERT INTO `wallmart_db`.`purchases` (`PurchaseDate`, `SupplierID`, `TotalAmount`, `InvoiceNumber`) VALUES ('"+PurchasesDate+"', '"+supplierID+"', '"+totalAmount+"', '"+invoiceNumber+"');";
        return db.iud(sql);
    }

    @Override
    public boolean UpdatePurchases(int id,Float totalAmount) {
        String sql="update `wallmart_db`.`purchases` set TotalAmount='"+totalAmount+"' where PurchaseID ="+id+";";
        return db.iud(sql);
    }

    @Override
    public boolean DeletePurchases(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Purchases checkPurchases(String invoiceNumber) {
        String sql = "SELECT * FROM `wallmart_db`.`purchases` where InvoiceNumber ='"+invoiceNumber+"';";
        ResultSet rs = db.select(sql);
        try {
            while(rs.next()) {
                Purchases pc = new Purchases (rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4),rs.getString(5));
                return pc;
            }
           
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    @Override
    public ResultSet ListAllPurchases() {
        return null;
    }
    
}
     