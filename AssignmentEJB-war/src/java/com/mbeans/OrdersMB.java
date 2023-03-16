/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;

import com.entitybean.OrderDetails;
import com.entitybean.OrderDetailsPK;
import com.entitybean.Orders;
import com.entitybean.Products;
import com.entitybean.UserAccounts;
import com.sessionbean.CartSBLocal;
import com.sessionbean.OrderDetailsFacadeLocal;
import com.sessionbean.OrdersFacadeLocal;
import com.sessionbean.ProductsFacadeLocal;
import com.sessionbean.UserAccountsFacadeLocal;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author OS
 */
@Named(value = "ordersMB")
@RequestScoped
public class OrdersMB {

    @EJB
    private CartSBLocal cartSB;

    @EJB
    private ProductsFacadeLocal productsFacade;

    @EJB
    private UserAccountsFacadeLocal userAccountsFacade;

    @EJB
    private OrderDetailsFacadeLocal orderDetailsFacade;

    @EJB
    private OrdersFacadeLocal ordersFacade;

    private Orders orders;
    private OrderDetails orderDetails;
    private OrderDetailsPK orderDetailsPK;
    private UserAccounts userAccounts;
    private Products products;
    private int idOrder;
    private int statusOrder;

    public OrdersMB() {
        orders = new Orders();
        orderDetails = new OrderDetails();
        orderDetailsPK = new OrderDetailsPK();
    }

// ==================== Admin area start ====================
    
    public List<Orders> showAllOrders() {
        return ordersFacade.findAll();
    }

    public String formatStatus(int id) {
        orders = ordersFacade.find(id);
        switch (orders.getOrderStatus()) {
            case 1:
                return "Wait for confirmation";
            case 2:
                return "Delivering";
            case 3:
                return "Delivered";
            default:
                return "Cancel";
        }
    }

    public String buttonStatus(int id) {
        orders = ordersFacade.find(id);
        switch (orders.getOrderStatus()) {
            case 1:
                return "btn btn-primary";
            case 2:
                return "btn btn-warning";
            case 3:
                return "btn btn-success";
            default:
                return "btn btn-secondary";
        }
    }

    public Boolean disableButtonStatus(int id) {
        orders = ordersFacade.find(id);
        if (orders.getOrderStatus() == 0 || orders.getOrderStatus() == 3) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean hideButtonDelete(int id) {
        orders = ordersFacade.find(id);
        if (orders.getOrderStatus() == 0) {
            return true;
        }
        return false;
    }

    public String updateOrderStatus(int id) {
        orders = ordersFacade.find(id);
        if (orders.getOrderStatus() == 1) {
            orders.setOrderStatus(2);
            ordersFacade.edit(orders);
        } else {
            orders.setOrderStatus(3);
            ordersFacade.edit(orders);
        }
        return "orders";
    }

    public String deleteOrder(int id) {
        ordersFacade.remove(ordersFacade.find(id));
        return "orders";
    }

// ==================== Admin area end ====================
    
// ==================== User area start ====================
    
    public String insertOrders(int userID) {
        userAccounts = userAccountsFacade.find(userID);
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        orders.setUserAccountID(userAccounts);
        orders.setOrderDate(date);
        orders.setOrderStatus(1);
        ordersFacade.create(orders);

        orders = ordersFacade.find(orders.getOrderID());
        Set<Map.Entry<Integer, Integer>> setCart = cartSB.showCartMap().entrySet();
        for (Map.Entry<Integer, Integer> e : setCart) {
            Integer id = e.getKey();
            Integer quantity = e.getValue();
            products = productsFacade.find(id);

            orderDetailsPK.setOrderID(orders.getOrderID());
            orderDetailsPK.setProductID(products.getProductID());
            orderDetails.setOrderDetailsPK(orderDetailsPK);

            orderDetails.setOrders(orders);
            orderDetails.setProducts(products);
            orderDetails.setOrderDetailQuantity(quantity);
            orderDetails.setOrderDetailPrice(products.getProductPrice());
            orderDetails.setOrderDetailDiscount(products.getProductDiscount());
            orderDetailsFacade.create(orderDetails);

            products.setProductQuantity(products.getProductQuantity() - quantity);
            products.setProductSell(products.getProductSell() + quantity);
            productsFacade.edit(products);
        }

        cartSB.emptyCart();
        return "account";
    }

    public Boolean disableButtonStatusUser(int id) {
        orders = ordersFacade.find(id);
        if (orders.getOrderStatus() != 1 ) {
            return true;
        } else {
            return false;
        }
    }

    public String updateOrderStatusUser(int id) {
        orders = ordersFacade.find(id);
        orders.setOrderStatus(0);
        ordersFacade.edit(orders);
        return "account";
    }
    
    public String showTitleStatus(int id) {
        orders = ordersFacade.find(id);
        if (orders.getOrderStatus() == 1) {
            return "Cancel this order";
        }
        return "";
    }
    
    public String chooseOrder(int id) {
        orders = ordersFacade.find(id);
        idOrder = orders.getOrderID();
        return "order_details";
    }
    
    public List<OrderDetails> showOrderDetailsByOrder() {
        return orderDetailsFacade.orderDetailsByOrder(idOrder);
    }

// ==================== User area end ====================
    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(int statusOrder) {
        this.statusOrder = statusOrder;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    public UserAccounts getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(UserAccounts userAccounts) {
        this.userAccounts = userAccounts;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public OrderDetailsPK getOrderDetailsPK() {
        return orderDetailsPK;
    }

    public void setOrderDetailsPK(OrderDetailsPK orderDetailsPK) {
        this.orderDetailsPK = orderDetailsPK;
    }
}
