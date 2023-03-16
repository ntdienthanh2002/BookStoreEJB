package com.entitybean;

import com.entitybean.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-11-28T10:57:53")
@StaticMetamodel(Languages.class)
public class Languages_ { 

    public static volatile CollectionAttribute<Languages, Products> productsCollection;
    public static volatile SingularAttribute<Languages, Integer> languageID;
    public static volatile SingularAttribute<Languages, String> languageName;

}