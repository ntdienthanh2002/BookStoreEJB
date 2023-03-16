package com.entitybean;

import com.entitybean.Products;
import com.entitybean.UserAccounts;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-11-28T10:57:53")
@StaticMetamodel(Feedbacks.class)
public class Feedbacks_ { 

    public static volatile SingularAttribute<Feedbacks, String> feedbackContent;
    public static volatile SingularAttribute<Feedbacks, Products> productID;
    public static volatile SingularAttribute<Feedbacks, UserAccounts> userAccountID;
    public static volatile SingularAttribute<Feedbacks, Date> feedbackDate;
    public static volatile SingularAttribute<Feedbacks, Integer> feedbackID;

}