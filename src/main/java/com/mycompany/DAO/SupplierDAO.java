/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.domain.Supplier;
import java.sql.ResultSet;

/**
 *
 * @author dcdip
 */
public interface SupplierDAO {
    public boolean addSupplier(String CompanyName, String ContactPerson, String Address, String phoneNumber,String Email,String VatNumber);
    public boolean UpdateSupplier(int id, String CompanyName, String ContactPerson, String Address, String phoneNumber,String Email,String VatNumber);
    public boolean DeleteSupplier(int id);
    public Supplier checkSupplier(int id);
    public ResultSet ListAllSupplier();
    
}
