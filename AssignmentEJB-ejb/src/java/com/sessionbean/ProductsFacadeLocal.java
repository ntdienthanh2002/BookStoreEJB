/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbean;

import com.entitybean.Products;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author OS
 */
@Local
public interface ProductsFacadeLocal {

    void create(Products products);

    void edit(Products products);

    void remove(Products products);

    Products find(Object id);

    List<Products> findAll();

    List<Products> findRange(int[] range);

    int count();

    public List<Products> newProducts();

    public List<Products> saleProducts();

    public List<Products> popularProducts();

    public List<Products> productsByAuthor(int id);

    public List<Products> productsByCategory(int id);

    public List<Products> productsByLanguage(int id);

    public List<Products> productsByPublisher(int id);
    
}
