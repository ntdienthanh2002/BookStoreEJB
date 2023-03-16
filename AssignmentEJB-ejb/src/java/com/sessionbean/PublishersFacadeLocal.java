/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbean;

import com.entitybean.Publishers;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author OS
 */
@Local
public interface PublishersFacadeLocal {

    void create(Publishers publishers);

    void edit(Publishers publishers);

    void remove(Publishers publishers);

    Publishers find(Object id);

    List<Publishers> findAll();

    List<Publishers> findRange(int[] range);

    int count();
    
}
