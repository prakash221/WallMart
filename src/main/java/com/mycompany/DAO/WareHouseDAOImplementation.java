/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import static com.mycompany.DAO.DatabaseVeriable.db;
import java.sql.ResultSet;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dcdip
 */
@Repository
public class WareHouseDAOImplementation implements WareHouseDAO{

    @Override
    public boolean insertWareHouse(String Location, String ContactNumber) {
        String sql ="INSERT INTO `wallmart_db`.`warehouses` (`Location`, `ContacNumber`) VALUES('"+Location+",'"+ContactNumber+"');";
        return db.iud(sql);
    }

    @Override
    public ResultSet listAllWareHouse() {
        String sql ="Select * from `wallmart_db`.`warehouses`;";
        return db.select(sql);
    }
    
}
