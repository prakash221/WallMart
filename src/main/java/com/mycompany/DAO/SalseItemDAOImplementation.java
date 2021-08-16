/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import static com.mycompany.DAO.DatabaseVeriable.db;
import com.mycompany.domain.SalseItem;
import java.sql.ResultSet;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dcdip
 */
@Repository
public class SalseItemDAOImplementation implements SalseItemDAO{

    @Override
    public boolean addSalesItem(int SalesID,int ProductID, Float UnitPrice, Float Quantity) {
        String sql ="INSERT INTO `wallmart_db`.`salesitem` (`SalesID`, `ProductID`, `UnitPrice`, `Quantity`) VALUES ('"+SalesID+"', '"+ProductID+"', '"+UnitPrice+"', '"+Quantity+"');";
        return db.iud(sql);
    }

    @Override
    public boolean UpdateSalesItem(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DeleteSalesItem(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SalseItem checkSalesItem(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet ListAllSales(int SalseID) {
       String sql = "SELECT * FROM wallmart_db.product P Inner join wallmart_db.salesitem pi on P.ProductID = pi.ProductID where SalesID='"+SalseID+"';";
       return db.select(sql);
       
    }
    
}
