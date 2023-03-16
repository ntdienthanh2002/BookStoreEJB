/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;

import com.entitybean.UserAccounts;
import com.sessionbean.CartSBLocal;
import com.sessionbean.UserAccountsFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author OS
 */
@Named(value = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {

    @EJB
    private CartSBLocal cartSB;

    @EJB
    private UserAccountsFacadeLocal userAccountsFacade;

    private UserAccounts userAccounts;
    private String uname;
    private String pword;
    private boolean flag = false;
    private String message = "";

    public LoginMB() {
    }

    public String checkLogin() {
        if (userAccountsFacade.checkLoginUser(uname, pword)) {
            userAccounts = userAccountsFacade.findUserLogin(uname);
            flag = true;
            return "account";
        }
        message = "Username or password is incorrect!!!";
        return "login";
    }
    
    public void checkLoginStatus() {
        if (flag == false) {
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            try {
                externalContext.redirect("login.xhtml");
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public String logout() {
        userAccounts = null;
        flag = false;
        cartSB.emptyCart();
        return "login";
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccounts getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(UserAccounts userAccounts) {
        this.userAccounts = userAccounts;
    }

}
