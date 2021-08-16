/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import static com.mycompany.DAO.DatabaseVeriable.db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dcdip
 */
@Repository

public class TransferDAOImplementation implements TransferDAO{
    @Autowired
    StockDAO std;

    @Override
    public boolean transferStock(int fromID, int toID, int productID, int quantity) {
        return removeFrom(fromID, productID,quantity) && addTo( toID, productID, quantity);
    }

    @Override
    public boolean removeFrom(int fromID, int productID, int quantity) {
        return std.removeStock(productID, fromID, quantity);
    }

    @Override
    public boolean addTo(int toID, int productID, int quantity) {
        return std.UpdateStock(productID, toID, quantity);
    }

   
}
