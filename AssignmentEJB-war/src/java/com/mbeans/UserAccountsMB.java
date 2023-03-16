/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;

import com.entitybean.UserAccounts;
import com.sessionbean.UserAccountsFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author OS
 */
@Named(value = "userAccountsMB")
@RequestScoped
public class UserAccountsMB {

    @EJB
    private UserAccountsFacadeLocal userAccountsFacade;

    private UserAccounts userAccounts;
    private String message = "";

    public UserAccountsMB() {
        userAccounts = new UserAccounts();
    }

    public List<UserAccounts> showAllUserAccounts() {
        return userAccountsFacade.findAll();
    }

    public String insertUserAccounts() {
        if (userAccountsFacade.checkUserExist(userAccounts.getUserAccountUsername())) {
            message = "Username already exists. Please use another username!!!";
            return "register";
        } else {
            userAccountsFacade.create(userAccounts);
            return "login";
        }
    }

    public UserAccounts getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(UserAccounts userAccounts) {
        this.userAccounts = userAccounts;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
