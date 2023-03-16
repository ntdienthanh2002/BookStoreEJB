/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;

import com.entitybean.Authors;
import com.sessionbean.AuthorsFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author OS
 */
@Named(value = "authorsMB")
@RequestScoped
public class AuthorsMB {

    @EJB
    private AuthorsFacadeLocal authorsFacade;

    private Authors authors;
    private int idAuthor;
    
    public AuthorsMB() {
        authors = new Authors();
    }
    
    public List<Authors> showAllAuthors() {
        return authorsFacade.findAll();
    }
    
    public String insertAuthor() {
        authorsFacade.create(authors);
        return "authors";
    }
    
    public String showUpdateAuthorForm(int id) {
        authors = authorsFacade.find(id);
        idAuthor = authors.getAuthorID();
        return "author_update";
    }
    
    public String updateAuthor() {
        Authors au = authorsFacade.find(idAuthor);
        au.setAuthorName(authors.getAuthorName());
        authorsFacade.edit(au);
        return "authors";
    }
    
    public String deleteAuthor(int id) {
        authorsFacade.remove(authorsFacade.find(id));
        return "authors";
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }
}
