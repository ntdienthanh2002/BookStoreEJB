/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sessionbean;

import com.entitybean.UserAccounts;
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
public class UserAccountsFacade extends AbstractFacade<UserAccounts> implements UserAccountsFacadeLocal {

    @PersistenceContext(unitName = "AssignmentEJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserAccountsFacade() {
        super(UserAccounts.class);
    }

    @Override
    public Boolean checkLoginUser(String username, String password) {
        boolean flag = false;
        try {
            Query query = em.createQuery("SELECT u FROM UserAccounts u WHERE u.userAccountUsername = :uname AND u.userAccountPassword = :pword");
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
    public UserAccounts findUserLogin(String username) {
        Query query = em.createQuery("SELECT u FROM UserAccounts u WHERE u.userAccountUsername = :uname");
        query.setParameter("uname", username);
        return (UserAccounts) query.getSingleResult();
    }
    
    @Override
    public Boolean checkUserExist(String username) {
        try {
            Query query = em.createQuery("SELECT u FROM UserAccounts u WHERE u.userAccountUsername = :uname");
            query.setParameter("uname", username);
            query.getSingleResult();
            return true;
        } catch (NoResultException ex) {
            return false;
        }
    }
}
