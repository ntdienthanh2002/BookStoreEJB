/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;

import com.entitybean.Languages;
import com.sessionbean.LanguagesFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author OS
 */
@Named(value = "languagesMB")
@RequestScoped
public class LanguagesMB {

    @EJB
    private LanguagesFacadeLocal languagesFacade;

    private Languages languages;
    private int idLanguage;
    
    public LanguagesMB() {
        languages = new Languages();
    }
    
    public List<Languages> showAllLanguages() {
        return languagesFacade.findAll();
    }
    
    public String insertLanguage() {
        languagesFacade.create(languages);
        return "languages";
    }
    
    public String showUpdateLanguageForm(int id) {
        languages = languagesFacade.find(id);
        idLanguage = languages.getLanguageID();
        return "language_update";
    }
    
    public String updateLanguage() {
        Languages la = languagesFacade.find(idLanguage);
        la.setLanguageName(languages.getLanguageName());
        languagesFacade.edit(la);
        return "languages";
    }
    
    public String deleteLanguage(int id) {
        languagesFacade.remove(languagesFacade.find(id));
        return "languages";
    }

    public Languages getLanguages() {
        return languages;
    }

    public void setLanguages(Languages languages) {
        this.languages = languages;
    }

    public int getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(int idLanguage) {
        this.idLanguage = idLanguage;
    }
    
}
