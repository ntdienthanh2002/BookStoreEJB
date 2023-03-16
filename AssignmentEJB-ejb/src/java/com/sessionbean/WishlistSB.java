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
public class WishlistSB implements WishlistSBLocal {

    Map<Integer, Integer> myWishlist = new HashMap();

    @Override
    public void addWishlist(Integer id) {
        if (myWishlist.containsKey(id)) {
            myWishlist.replace(id, myWishlist.get(id).intValue() + 1);
        } else {
            myWishlist.put(id, 1);
        }
    }

    @Override
    public Map<Integer, Integer> showWishlistMap() {
        return myWishlist;
    }

    @Override
    public int countWishlist() {
        return myWishlist.size();
    }

    @Override
    public void removeWishlist(Integer id) {
        myWishlist.remove(id);
    }

    @Override
    public void emptyWishlist() {
        myWishlist.clear();
    }
}
