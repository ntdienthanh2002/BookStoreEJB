/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.sessionbean;

import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author OS
 */
@Local
public interface CartSBLocal {

    public void addCart(Integer id, int quanlity);

    public Map<Integer, Integer> showCartMap();

    public int countCart();

    public void removeCart(Integer id);

    public void emptyCart();

    public void updateCart(Integer id, boolean flag);
}
