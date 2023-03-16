/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;

import com.entitybean.Products;
import com.sessionbean.ProductsFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author OS
 */
@Named(value = "productsMB")
@RequestScoped
public class ProductsMB {

    @EJB
    private ProductsFacadeLocal productsFacade;

    private Products products;
    private int idAuthor;
    private int idCategory;
    private int idLanguage;
    private int idPublisher;
    
    public ProductsMB() {
        products = new Products();
    }

// ==================== Admin area start ====================
    
    public List<Products> showAllProducts() {
        return productsFacade.findAll();
    }
    
    public String deleteProduct(int id) {
        productsFacade.remove(productsFacade.find(id));
        return "products";
    }
    
// ==================== Admin area end ====================
    
    
// ==================== User area start ====================
    
    public List<Products> showNewProducts() {
        return productsFacade.newProducts();
    }
    
    public List<Products> showSaleProducts() {
        return productsFacade.saleProducts();
    }
    
    public List<Products> showPopularProducts() {
        return productsFacade.popularProducts();
    }
    
    public String chooseAuthor(int id) {
        idAuthor = id;
        return "products_by_author";
    }
    
    public List<Products> showProductsByAuthor() {
        return productsFacade.productsByAuthor(idAuthor);
    }
    
    public String chooseCategory(int id) {
        idCategory = id;
        return "products_by_category";
    }
    
    public List<Products> showProductsByCategory() {
        return productsFacade.productsByCategory(idCategory);
    }
    
    public String chooseLanguage(int id) {
        idLanguage = id;
        return "products_by_language";
    }
    
    public List<Products> showProductsByLanguage() {
        return productsFacade.productsByLanguage(idLanguage);
    }
    
    public String choosePublisher(int id) {
        idPublisher = id;
        return "products_by_publisher";
    }
    
    public List<Products> showProductsByPublisher() {
        return productsFacade.productsByPublisher(idPublisher);
    }
    
    public String showProductDetails(int id) {
        products = productsFacade.find(id);
        return "product_details";
    }
    
// ==================== User area end ====================
    
    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(int idLanguage) {
        this.idLanguage = idLanguage;
    }

    public int getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(int idPublisher) {
        this.idPublisher = idPublisher;
    }
    
}
