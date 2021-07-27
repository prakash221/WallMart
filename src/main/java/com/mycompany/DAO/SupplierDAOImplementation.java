/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import static com.mycompany.DAO.DatabaseVeriable.db;
import com.mycompany.domain.Supplier;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dcdip
 */
@Repository
public class SupplierDAOImplementation implements SupplierDAO{

    @Override
    public boolean addSupplier(String CompanyName, String ContactPerson, String Address, String phoneNumber,String Email,String VatNumber) {
        String sql="INSERT INTO `wallmart_db`.`supplier` (`CompanyName`, `ContactPerson`, `Address`, `Phone`, `Email`, `VATNumber`) VALUES ('"+CompanyName+"', '"+ContactPerson+"', '"+Address+"', '"+phoneNumber+"', '"+Email+"', '"+VatNumber+"');";
        return db.iud(sql);
    }

    @Override
    public boolean UpdateSupplier(int id, String CompanyName, String ContactPerson, String Address, String phoneNumber,String Email,String VatNumber) {
        String sql ="UPDATE `wallmart_db`.`supplier` SET `CompanyName` = '"+CompanyName+"', `ContactPerson` = '"+ContactPerson+"', `Address` = '"+Address+"', `Phone` = '"+phoneNumber+"', `Email` = '"+Email+"', `VATNumber` = '"+VatNumber+"' WHERE (`SupplierID` = '"+id+"');";
        return db.iud(sql);
            
    }

    @Override
    public boolean DeleteSupplier(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Supplier checkSupplier(int id) {
        String sql = "SELECT * FROM wallmart_db.supplier where SupplierID ="+id+";";
        ResultSet rs = db.select(sql);
        try {
            while(rs.next()) {
                Supplier su = new Supplier(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                return su;
            }
           
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    @Override
    public ResultSet ListAllSupplier() {
        String sql ="SELECT * FROM wallmart_db.supplier;";
        return db.select(sql);
    }
    
}
