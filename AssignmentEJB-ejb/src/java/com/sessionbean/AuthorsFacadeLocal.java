/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbean;

import com.entitybean.Authors;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author OS
 */
@Local
public interface AuthorsFacadeLocal {

    void create(Authors authors);

    void edit(Authors authors);

    void remove(Authors authors);

    Authors find(Object id);

    List<Authors> findAll();

    List<Authors> findRange(int[] range);

    int count();
    
}
