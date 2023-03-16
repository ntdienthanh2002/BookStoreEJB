package com.entitybean;

import com.entitybean.Authors;
import com.entitybean.Categories;
import com.entitybean.Languages;
import com.entitybean.Publishers;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-11-28T10:57:53")
@StaticMetamodel(Products.class)
public class Products_ { 

    public static volatile SingularAttribute<Products, String> productForm;
    public static volatile SingularAttribute<Products, Integer> productID;
    public static volatile SingularAttribute<Products, String> productSize;
    public static volatile SingularAttribute<Products, Languages> languageID;
    public static volatile SingularAttribute<Products, Integer> productPage;
    public static volatile SingularAttribute<Products, Authors> authorID;
    public static volatile SingularAttribute<Products, String> productName;
    public static volatile SingularAttribute<Products, Integer> productQuantity;
    public static volatile SingularAttribute<Products, Publishers> publisherID;
    public static volatile SingularAttribute<Products, String> productImage;
    public static volatile SingularAttribute<Products, Integer> productSell;
    public static volatile SingularAttribute<Products, Integer> productDiscount;
    public static volatile SingularAttribute<Products, BigDecimal> productPrice;
    public static volatile SingularAttribute<Products, String> productDescription;
    public static volatile SingularAttribute<Products, Categories> categoryID;

}