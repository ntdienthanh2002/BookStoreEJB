/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;

import com.entitybean.Products;
import com.models.Wishlist;
import com.sessionbean.ProductsFacadeLocal;
import com.sessionbean.WishlistSBLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.EJB;

/**
 *
 * @author OS
 */
@Named(value = "wishlistMB")
@SessionScoped
public class WishlistMB implements Serializable {

    @EJB
    private ProductsFacadeLocal productsFacade;

    @EJB
    private WishlistSBLocal wishlistSB;

    public WishlistMB() {
    }

    public String addWishlistProduct(Integer id) {
        wishlistSB.addWishlist(id);
        return "wishlist";
    }

    public List<Wishlist> showAllWishlists() {
        List<Wishlist> listWishlists = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> setWishlist = wishlistSB.showWishlistMap().entrySet();
        for (Map.Entry<Integer, Integer> e : setWishlist) {
            Integer id = e.getKey();
            Products products = productsFacade.find(id);
            Wishlist wishlist = new Wishlist(id, products.getProductName(), products.getProductQuantity(), products.getProductPrice(), products.getProductImage());
            listWishlists.add(wishlist);
        }
        return listWishlists;
    }

    public String removeWishlist(int id) {
        wishlistSB.removeWishlist(id);
        return "wishlist";
    }

    public String emptyWishlist() {
        wishlistSB.emptyWishlist();
        return "wishlist";
    }

    public int countWishlist() {
        return wishlistSB.countWishlist();
    }
}
