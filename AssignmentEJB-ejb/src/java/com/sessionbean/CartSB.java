/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.sessionbean;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author OS
 */
@Stateless
public class CartSB implements CartSBLocal {

    Map<Integer, Integer> myCart = new HashMap();
    
    @Override
    public void addCart(Integer id, int quanlity) {
        if (myCart.containsKey(id)) {
            myCart.replace(id, myCart.get(id).intValue() + 1);
        } else {
            myCart.put(id, 1);
        }
    }

    @Override
    public Map<Integer, Integer> showCartMap() {
        return myCart;
    }

    @Override
    public int countCart() {
        return myCart.size();
    }

    @Override
    public void removeCart(Integer id) {
        myCart.remove(id);
    }

    @Override
    public void emptyCart() {
        myCart.clear();
    }

    @Override
    public void updateCart(Integer id, boolean flag) {
        if (flag) {
            myCart.replace(id, myCart.get(id).intValue() + 1);
        } else {
            myCart.replace(id, myCart.get(id).intValue() - 1);
        }
    }

}
