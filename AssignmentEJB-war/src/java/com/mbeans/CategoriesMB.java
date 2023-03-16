/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;

import com.entitybean.Categories;
import com.sessionbean.CategoriesFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author OS
 */
@Named(value = "categoriesMB")
@RequestScoped
public class CategoriesMB {

    @EJB
    private CategoriesFacadeLocal categoriesFacade;

    private Categories categories;
    private int idCategory;
    
    public CategoriesMB() {
        categories = new Categories();
    }

    public List<Categories> showAllCategories() {
        return categoriesFacade.findAll();
    }
    
    public String insertCategory() {
        categoriesFacade.create(categories);
        return "categories";
    }
    
    public String showUpdateCategoryForm(int id) {
        categories = categoriesFacade.find(id);
        idCategory = categories.getCategoryID();
        return "category_update";
    }
    
    public String updateCategory() {
        Categories ca = categoriesFacade.find(idCategory);
        ca.setCategoryName(categories.getCategoryName());
        categoriesFacade.edit(ca);
        return "categories";
    }
    
    public String deleteCategory(int id) {
        categoriesFacade.remove(categoriesFacade.find(id));
        return "categories";
    }
    
    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
    
}
