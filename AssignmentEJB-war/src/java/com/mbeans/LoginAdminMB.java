/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;

import com.entitybean.AdminAccounts;
import com.sessionbean.AdminAccountsFacadeLocal;
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
@Named(value = "loginAdminMB")
@SessionScoped
public class LoginAdminMB implements Serializable {

    @EJB
    private AdminAccountsFacadeLocal adminAccountsFacade;

    private AdminAccounts adminAccounts;
    private String uname;
    private String pword;
    private boolean flag = false;
    private String message = "";
    
    public LoginAdminMB() {
    }
    
    public String checkLogin() {
        if (adminAccountsFacade.checkLoginAdmin(uname, pword)) {
            adminAccounts = adminAccountsFacade.findAdminLogin(uname);
            flag = true;
            return "authors";
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
        adminAccounts = null;
        flag = false;
        return "login";
    }

    public AdminAccounts getAdminAccounts() {
        return adminAccounts;
    }

    public void setAdminAccounts(AdminAccounts adminAccounts) {
        this.adminAccounts = adminAccounts;
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
    
}
