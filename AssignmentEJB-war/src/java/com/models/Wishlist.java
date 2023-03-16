/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.models;

import java.math.BigDecimal;

/**
 *
 * @author OS
 */
public class Wishlist {

    private int proID;
    private String proName;
    private int quantity;
    private BigDecimal unitPrice;
    private String image;

    public Wishlist() {
    }

    public Wishlist(int proID, String proName, int quantity, BigDecimal unitPrice, String image) {
        this.proID = proID;
        this.proName = proName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.image = image;
    }

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
