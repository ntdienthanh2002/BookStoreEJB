/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;

import com.entitybean.OrderDetails;
import com.sessionbean.OrderDetailsFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author OS
 */
@Named(value = "orderDetailsMB")
@RequestScoped
public class OrderDetailsMB {

    @EJB
    private OrderDetailsFacadeLocal orderDetailsFacade;

    public OrderDetailsMB() {
    }
    
    public List<OrderDetails> showAllOrderDetails() {
        return orderDetailsFacade.findAll();
    }
}
