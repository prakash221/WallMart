/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import java.sql.ResultSet;

/**
 *
 * @author dcdip
 */
public interface WareHouseDAO {
   public boolean insertWareHouse(String Location, String ContactNumber);
   public ResultSet listAllWareHouse();
   
}
