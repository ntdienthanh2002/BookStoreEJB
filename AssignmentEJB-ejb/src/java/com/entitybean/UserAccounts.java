/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entitybean;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author OS
 */
@Entity
@Table(name = "UserAccounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAccounts.findAll", query = "SELECT u FROM UserAccounts u"),
    @NamedQuery(name = "UserAccounts.findByUserAccountID", query = "SELECT u FROM UserAccounts u WHERE u.userAccountID = :userAccountID"),
    @NamedQuery(name = "UserAccounts.findByUserAccountUsername", query = "SELECT u FROM UserAccounts u WHERE u.userAccountUsername = :userAccountUsername"),
    @NamedQuery(name = "UserAccounts.findByUserAccountPassword", query = "SELECT u FROM UserAccounts u WHERE u.userAccountPassword = :userAccountPassword"),
    @NamedQuery(name = "UserAccounts.findByUserAccountEmail", query = "SELECT u FROM UserAccounts u WHERE u.userAccountEmail = :userAccountEmail"),
    @NamedQuery(name = "UserAccounts.findByUserAccountPhone", query = "SELECT u FROM UserAccounts u WHERE u.userAccountPhone = :userAccountPhone"),
    @NamedQuery(name = "UserAccounts.findByUserAccountAddress", query = "SELECT u FROM UserAccounts u WHERE u.userAccountAddress = :userAccountAddress")})
public class UserAccounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserAccountID")
    private Integer userAccountID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "UserAccountUsername")
    private String userAccountUsername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "UserAccountPassword")
    private String userAccountPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "UserAccountEmail")
    private String userAccountEmail;
    @Column(name = "UserAccountPhone")
    private Integer userAccountPhone;
    @Size(max = 255)
    @Column(name = "UserAccountAddress")
    private String userAccountAddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userAccountID")
    private Collection<Orders> ordersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userAccountID")
    private Collection<Feedbacks> feedbacksCollection;

    public UserAccounts() {
    }

    public Integer getUserAccountID() {
        return userAccountID;
    }

    public String getUserAccountUsername() {
        return userAccountUsername;
    }

    public void setUserAccountUsername(String userAccountUsername) {
        this.userAccountUsername = userAccountUsername;
    }

    public String getUserAccountPassword() {
        return userAccountPassword;
    }

    public void setUserAccountPassword(String userAccountPassword) {
        this.userAccountPassword = userAccountPassword;
    }

    public String getUserAccountEmail() {
        return userAccountEmail;
    }

    public void setUserAccountEmail(String userAccountEmail) {
        this.userAccountEmail = userAccountEmail;
    }

    public Integer getUserAccountPhone() {
        return userAccountPhone;
    }

    public void setUserAccountPhone(Integer userAccountPhone) {
        this.userAccountPhone = userAccountPhone;
    }

    public String getUserAccountAddress() {
        return userAccountAddress;
    }

    public void setUserAccountAddress(String userAccountAddress) {
        this.userAccountAddress = userAccountAddress;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @XmlTransient
    public Collection<Feedbacks> getFeedbacksCollection() {
        return feedbacksCollection;
    }

    public void setFeedbacksCollection(Collection<Feedbacks> feedbacksCollection) {
        this.feedbacksCollection = feedbacksCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userAccountID != null ? userAccountID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAccounts)) {
            return false;
        }
        UserAccounts other = (UserAccounts) object;
        if ((this.userAccountID == null && other.userAccountID != null) || (this.userAccountID != null && !this.userAccountID.equals(other.userAccountID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entitybean.UserAccounts[ userAccountID=" + userAccountID + " ]";
    }
    
}
