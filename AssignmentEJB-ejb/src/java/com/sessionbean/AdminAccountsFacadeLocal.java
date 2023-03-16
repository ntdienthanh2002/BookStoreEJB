/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbean;

import com.entitybean.AdminAccounts;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author OS
 */
@Local
public interface AdminAccountsFacadeLocal {

    void create(AdminAccounts adminAccounts);

    void edit(AdminAccounts adminAccounts);

    void remove(AdminAccounts adminAccounts);

    AdminAccounts find(Object id);

    List<AdminAccounts> findAll();

    List<AdminAccounts> findRange(int[] range);

    int count();

    public Boolean checkLoginAdmin(String username, String password);

    public AdminAccounts findAdminLogin(String username);
    
}
