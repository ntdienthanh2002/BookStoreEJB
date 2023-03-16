/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sessionbean;

import com.entitybean.Languages;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author OS
 */
@Stateless
public class LanguagesFacade extends AbstractFacade<Languages> implements LanguagesFacadeLocal {

    @PersistenceContext(unitName = "AssignmentEJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LanguagesFacade() {
        super(Languages.class);
    }
    
}
