/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

/**
 *
 * @author dcdip
 */
public interface TransferDAO {
    public boolean transferStock(int fromID, int toID, int productID, int quantity);
    public boolean removeFrom(int fromID, int productID, int quantity);
    public boolean addTo(int toID, int productID, int quantity);
}
