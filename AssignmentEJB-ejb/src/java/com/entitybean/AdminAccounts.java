/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entitybean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author OS
 */
@Entity
@Table(name = "AdminAccounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminAccounts.findAll", query = "SELECT a FROM AdminAccounts a"),
    @NamedQuery(name = "AdminAccounts.findByAdminAccountID", query = "SELECT a FROM AdminAccounts a WHERE a.adminAccountID = :adminAccountID"),
    @NamedQuery(name = "AdminAccounts.findByAdminAccountUsername", query = "SELECT a FROM AdminAccounts a WHERE a.adminAccountUsername = :adminAccountUsername"),
    @NamedQuery(name = "AdminAccounts.findByAdminAccountPassword", query = "SELECT a FROM AdminAccounts a WHERE a.adminAccountPassword = :adminAccountPassword")})
public class AdminAccounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AdminAccountID")
    private Integer adminAccountID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AdminAccountUsername")
    private String adminAccountUsername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AdminAccountPassword")
    private String adminAccountPassword;

    public AdminAccounts() {
    }

    public Integer getAdminAccountID() {
        return adminAccountID;
    }

    public String getAdminAccountUsername() {
        return adminAccountUsername;
    }

    public void setAdminAccountUsername(String adminAccountUsername) {
        this.adminAccountUsername = adminAccountUsername;
    }

    public String getAdminAccountPassword() {
        return adminAccountPassword;
    }

    public void setAdminAccountPassword(String adminAccountPassword) {
        this.adminAccountPassword = adminAccountPassword;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminAccountID != null ? adminAccountID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminAccounts)) {
            return false;
        }
        AdminAccounts other = (AdminAccounts) object;
        if ((this.adminAccountID == null && other.adminAccountID != null) || (this.adminAccountID != null && !this.adminAccountID.equals(other.adminAccountID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entitybean.AdminAccounts[ adminAccountID=" + adminAccountID + " ]";
    }
    
}
