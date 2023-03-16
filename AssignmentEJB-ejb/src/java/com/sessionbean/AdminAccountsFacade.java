/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sessionbean;

import com.entitybean.AdminAccounts;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author OS
 */
@Stateless
public class AdminAccountsFacade extends AbstractFacade<AdminAccounts> implements AdminAccountsFacadeLocal {

    @PersistenceContext(unitName = "AssignmentEJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminAccountsFacade() {
        super(AdminAccounts.class);
    }
    
    @Override
    public Boolean checkLoginAdmin(String username, String password) {
        boolean flag = false;
        try {
            Query query = em.createQuery("SELECT a FROM AdminAccounts a WHERE a.adminAccountUsername = :uname AND a.adminAccountPassword = :pword");
            query.setParameter("uname", username);
            query.setParameter("pword", password);
            query.getSingleResult();
            flag = true;
        } catch (NoResultException ex) {
            flag = false;
        }
        return flag;
    }
    
    @Override
    public AdminAccounts findAdminLogin(String username) {
        Query query = em.createQuery("SELECT a FROM AdminAccounts a WHERE a.adminAccountUsername = :uname");
        query.setParameter("uname", username);
        return (AdminAccounts) query.getSingleResult();
    }
}
