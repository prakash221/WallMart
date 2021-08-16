/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import static com.mycompany.DAO.DatabaseVeriable.db;
import com.mycompany.domain.Stock;
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
public class StockDAOImplemantation implements StockDAO{

    @Override
    public boolean addStock(int ProductID, int WareHouseID, int Quantity) {
        String sql = "INSERT INTO `wallmart_db`.`stock` (`ProductID`, `WareHouseID`, `Quantity`) VALUES ('"+ProductID+"', '"+WareHouseID+"', '"+Quantity+"');";
        return db.iud(sql);
        
    }

    @Override
    public boolean UpdateStock(int ProductID, int WareHouseID, int Quantity) {
       
        Stock st = checkStock(ProductID, WareHouseID);
        if(st != null){
            int Totalstock = st.getQuantity();
        Totalstock = Totalstock + Quantity;
        String sql = "UPDATE `wallmart_db`.`stock`  set `Quantity` = '"+Totalstock+"' WHERE `ProductID` = '"+ProductID+"' and WareHouseID ='"+WareHouseID+"';";
        return db.iud(sql);
        }
        else{
            return false;
        }
       
    }

    @Override
    public boolean DeleteStock(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stock checkStock(int ProductID, int WareHouseID) {
       
            String sql ="Select * from `wallmart_db`.`stock` WHERE `ProductID` = "+ProductID+" and WareHouseID ="+WareHouseID+";";
            ResultSet rs = db.select(sql);
        try {
            while(rs.next()){
               Stock st= new Stock(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
               return st;
            }
            
                    
        } catch (SQLException ex) {
            Logger.getLogger(StockDAOImplemantation.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
      
        
    }

    @Override
    public ResultSet ListAllStock() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeStock(int ProductID, int WareHouseID, int Quantity) {
        Stock st = checkStock(ProductID, WareHouseID);
            int Totalstock = st.getQuantity();
            Totalstock = Totalstock - Quantity;
            String sql = "UPDATE `wallmart_db`.`stock`  set `Quantity` = '"+Totalstock+"' WHERE `ProductID` = '"+ProductID+"' and WareHouseID ='"+WareHouseID+"';";
            return db.iud(sql);
    }
    
}
