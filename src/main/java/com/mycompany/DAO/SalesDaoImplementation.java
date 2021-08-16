/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import static com.mycompany.DAO.DatabaseVeriable.db;
import com.mycompany.domain.Purchases;
import com.mycompany.domain.Sales;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dcdip
 */
@Repository
public class SalesDaoImplementation implements SalesDAO {

    @Override
    public boolean addSales(String SalesDate, int CustomerID, int Amount, int TAXAmount, String InvoiceNumber) {
        String Sql = "INSERT INTO `wallmart_db`.`sales` (`SalesDate`, `CustomerID`, `Amount`, `TAXAmount`, `InvoiceNumber`) VALUES ('"+SalesDate+"', '"+CustomerID+"', '"+Amount+"', '"+TAXAmount+"', '"+InvoiceNumber+"');";
        return db.iud(Sql);
    }

    @Override
    public boolean UpdateSales(int id, Float Amount, Float tax) {
        String sql="Update `wallmart_db`.`sales` set Amount='"+Amount+"', TAXAmount='"+tax+"' Where SalesID="+id+";";
        return db.iud(sql);
    }

    @Override
    public boolean DeleteSales(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sales checkSales(String invoiceNumber) {
        String sql = "SELECT * FROM `wallmart_db`.`sales` where InvoiceNumber ='"+invoiceNumber+"';";
        ResultSet rs = db.select(sql);
        try {
            while(rs.next()) {
                Sales sa = new Sales (rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
                return sa;
            }
           
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    @Override
    public ResultSet ListAllSales() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
