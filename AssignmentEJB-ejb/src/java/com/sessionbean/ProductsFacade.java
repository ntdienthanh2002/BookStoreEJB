/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sessionbean;

import com.entitybean.Products;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author OS
 */
@Stateless
public class ProductsFacade extends AbstractFacade<Products> implements ProductsFacadeLocal {

    @PersistenceContext(unitName = "AssignmentEJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductsFacade() {
        super(Products.class);
    }

    @Override
    public List<Products> newProducts() {
        Query query = em.createQuery("SELECT p FROM Products p ORDER BY p.productID DESC", Products.class);
        return query.getResultList();
    }

    @Override
    public List<Products> saleProducts() {
        Query query = em.createQuery("SELECT p FROM Products p WHERE p.productDiscount > 0", Products.class);
        return query.getResultList();
    }

    @Override
    public List<Products> popularProducts() {
        Query query = em.createQuery("SELECT p FROM Products p ORDER BY p.productSell DESC", Products.class);
        return query.getResultList();
    }

    @Override
    public List<Products> productsByAuthor(int id) {
        Query query = em.createQuery("SELECT p FROM Products p WHERE p.authorID.authorID = ?1", Products.class);
        query.setParameter(1, id);
        return query.getResultList();
    }
    
    @Override
    public List<Products> productsByCategory(int id) {
        Query query = em.createQuery("SELECT p FROM Products p WHERE p.categoryID.categoryID = ?1", Products.class);
        query.setParameter(1, id);
        return query.getResultList();
    }
    
    @Override
    public List<Products> productsByLanguage(int id) {
        Query query = em.createQuery("SELECT p FROM Products p WHERE p.languageID.languageID = ?1", Products.class);
        query.setParameter(1, id);
        return query.getResultList();
    }
    
    @Override
    public List<Products> productsByPublisher(int id) {
        Query query = em.createQuery("SELECT p FROM Products p WHERE p.publisherID.publisherID = ?1", Products.class);
        query.setParameter(1, id);
        return query.getResultList();
    }
}
