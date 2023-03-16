/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;

import com.entitybean.Orders;
import com.entitybean.UserAccounts;
import com.sessionbean.OrdersFacadeLocal;
import com.sessionbean.UserAccountsFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author OS
 */
@Named(value = "accountMB")
@SessionScoped
public class AccountMB implements Serializable {

    @EJB
    private UserAccountsFacadeLocal userAccountsFacade;

    @EJB
    private OrdersFacadeLocal ordersFacade;

    private UserAccounts userAccounts;
    private int idUserAccount;
    
    public AccountMB() {
    }
    
    public List<Orders> showOrdersByUser(int id) {
        userAccounts = userAccountsFacade.find(id);
        idUserAccount = userAccounts.getUserAccountID();
        return ordersFacade.ordersByUser(idUserAccount);
    }

    public UserAccounts getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(UserAccounts userAccounts) {
        this.userAccounts = userAccounts;
    }

    public int getIdUserAccount() {
        return idUserAccount;
    }

    public void setIdUserAccount(int idUserAccount) {
        this.idUserAccount = idUserAccount;
    }
}
