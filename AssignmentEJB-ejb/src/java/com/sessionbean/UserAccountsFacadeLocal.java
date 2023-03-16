/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbean;

import com.entitybean.UserAccounts;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author OS
 */
@Local
public interface UserAccountsFacadeLocal {

    void create(UserAccounts userAccounts);

    void edit(UserAccounts userAccounts);

    void remove(UserAccounts userAccounts);

    UserAccounts find(Object id);

    List<UserAccounts> findAll();

    List<UserAccounts> findRange(int[] range);

    int count();

    public Boolean checkLoginUser(String username, String password);

    public UserAccounts findUserLogin(String username);

    public Boolean checkUserExist(String username);
    
}
