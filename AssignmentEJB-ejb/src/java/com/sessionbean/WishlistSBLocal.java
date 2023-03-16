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
public interface WishlistSBLocal {

    public void addWishlist(Integer id);

    public Map<Integer, Integer> showWishlistMap();

    public int countWishlist();

    public void removeWishlist(Integer id);

    public void emptyWishlist();
}
