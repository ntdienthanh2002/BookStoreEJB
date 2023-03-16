package com.entitybean;

import com.entitybean.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-11-28T10:57:53")
@StaticMetamodel(Publishers.class)
public class Publishers_ { 

    public static volatile SingularAttribute<Publishers, Integer> publisherID;
    public static volatile CollectionAttribute<Publishers, Products> productsCollection;
    public static volatile SingularAttribute<Publishers, String> publisherName;

}