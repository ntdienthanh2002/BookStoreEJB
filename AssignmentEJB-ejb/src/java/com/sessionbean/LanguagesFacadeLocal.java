/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbean;

import com.entitybean.Languages;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author OS
 */
@Local
public interface LanguagesFacadeLocal {

    void create(Languages languages);

    void edit(Languages languages);

    void remove(Languages languages);

    Languages find(Object id);

    List<Languages> findAll();

    List<Languages> findRange(int[] range);

    int count();
    
}
