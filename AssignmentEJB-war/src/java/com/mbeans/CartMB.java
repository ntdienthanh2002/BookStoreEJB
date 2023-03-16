/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;

import com.entitybean.Products;
import com.models.CartShopping;
import com.sessionbean.CartSBLocal;
import com.sessionbean.ProductsFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.EJB;

/**
 *
 * @author OS
 */
@Named(value = "cartMB")
@SessionScoped
public class CartMB implements Serializable {

    @EJB
    private CartSBLocal cartSB;

    @EJB
    private ProductsFacadeLocal productsFacade;

    List<Integer> numCart = new ArrayList<>();
    private BigDecimal totalMoneyCart;
    private int totalProductCart;
    
    public CartMB() {
    }

    public String addCartProduct(Integer id) {
        cartSB.addCart(id, 1);
        return "cart";
    }
    
    public List<CartShopping> showAllCarts() {
        List<CartShopping> listCartShoppings = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> setCart = cartSB.showCartMap().entrySet();
        totalMoneyCart = new BigDecimal(0);
        totalProductCart = 0;
        for (Map.Entry<Integer, Integer> e : setCart) {
            Integer id = e.getKey();
            Integer quantity = e.getValue();
            Products products = productsFacade.find(id);
            BigDecimal price = new BigDecimal(products.getProductPrice().doubleValue());
            BigDecimal discount = new BigDecimal(products.getProductDiscount());
            BigDecimal totalPrice = new BigDecimal(0);
            totalPrice = totalPrice.add((price.multiply(new BigDecimal(quantity))));
            totalPrice = totalPrice.subtract(totalPrice.multiply(discount.divide(new BigDecimal(100))));
            CartShopping cartShopping = new CartShopping(id, products.getProductName(), quantity, price, totalPrice, products.getProductDiscount(), products.getProductImage());
            listCartShoppings.add(cartShopping);
            numCart.add(quantity);
            totalMoneyCart = totalMoneyCart.add((price.subtract(price.multiply(discount.divide(new BigDecimal(100))))).multiply(new BigDecimal(quantity)));
            totalProductCart += quantity;
        }
        return listCartShoppings;
    }
    
    public void updateCart(int id, boolean flag) {
        cartSB.updateCart(id, flag);
    }
    
    public String removeCart(int id) {
        cartSB.removeCart(id);
        return "cart";
    }
    
    public String emptyCart() {
        cartSB.emptyCart();
        return "cart";
    }
    
    public int countCart() {
        return cartSB.countCart();
    }

    public BigDecimal getTotalMoneyCart() {
        return totalMoneyCart;
    }

    public void setTotalMoneyCart(BigDecimal totalMoneyCart) {
        this.totalMoneyCart = totalMoneyCart;
    }

    public int getTotalProductCart() {
        return totalProductCart;
    }

    public void setTotalProductCart(int totalProductCart) {
        this.totalProductCart = totalProductCart;
    }
    
}
