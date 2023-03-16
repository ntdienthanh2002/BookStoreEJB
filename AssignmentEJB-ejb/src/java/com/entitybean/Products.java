/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entitybean;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author OS
 */
@Entity
@Table(name = "Products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByProductID", query = "SELECT p FROM Products p WHERE p.productID = :productID"),
    @NamedQuery(name = "Products.findByProductName", query = "SELECT p FROM Products p WHERE p.productName = :productName"),
    @NamedQuery(name = "Products.findByProductImage", query = "SELECT p FROM Products p WHERE p.productImage = :productImage"),
    @NamedQuery(name = "Products.findByProductSize", query = "SELECT p FROM Products p WHERE p.productSize = :productSize"),
    @NamedQuery(name = "Products.findByProductPage", query = "SELECT p FROM Products p WHERE p.productPage = :productPage"),
    @NamedQuery(name = "Products.findByProductForm", query = "SELECT p FROM Products p WHERE p.productForm = :productForm"),
    @NamedQuery(name = "Products.findByProductPrice", query = "SELECT p FROM Products p WHERE p.productPrice = :productPrice"),
    @NamedQuery(name = "Products.findByProductQuantity", query = "SELECT p FROM Products p WHERE p.productQuantity = :productQuantity"),
    @NamedQuery(name = "Products.findByProductDescription", query = "SELECT p FROM Products p WHERE p.productDescription = :productDescription"),
    @NamedQuery(name = "Products.findByProductDiscount", query = "SELECT p FROM Products p WHERE p.productDiscount = :productDiscount"),
    @NamedQuery(name = "Products.findByProductSell", query = "SELECT p FROM Products p WHERE p.productSell = :productSell")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private Integer productID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "ProductName")
    private String productName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ProductImage")
    private String productImage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ProductSize")
    private String productSize;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProductPage")
    private int productPage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ProductForm")
    private String productForm;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProductPrice")
    private BigDecimal productPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProductQuantity")
    private int productQuantity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "ProductDescription")
    private String productDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProductDiscount")
    private int productDiscount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProductSell")
    private int productSell;
    @JoinColumn(name = "AuthorID", referencedColumnName = "AuthorID")
    @ManyToOne(optional = false)
    private Authors authorID;
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    @ManyToOne(optional = false)
    private Categories categoryID;
    @JoinColumn(name = "LanguageID", referencedColumnName = "LanguageID")
    @ManyToOne(optional = false)
    private Languages languageID;
    @JoinColumn(name = "PublisherID", referencedColumnName = "PublisherID")
    @ManyToOne(optional = false)
    private Publishers publisherID;

    public Products() {
    }

    public Integer getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public int getProductPage() {
        return productPage;
    }

    public void setProductPage(int productPage) {
        this.productPage = productPage;
    }

    public String getProductForm() {
        return productForm;
    }

    public void setProductForm(String productForm) {
        this.productForm = productForm;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(int productDiscount) {
        this.productDiscount = productDiscount;
    }

    public int getProductSell() {
        return productSell;
    }

    public void setProductSell(int productSell) {
        this.productSell = productSell;
    }

    public Authors getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Authors authorID) {
        this.authorID = authorID;
    }

    public Categories getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Categories categoryID) {
        this.categoryID = categoryID;
    }

    public Languages getLanguageID() {
        return languageID;
    }

    public void setLanguageID(Languages languageID) {
        this.languageID = languageID;
    }

    public Publishers getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(Publishers publisherID) {
        this.publisherID = publisherID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Products[ productID=" + productID + " ]";
    }
    
}
