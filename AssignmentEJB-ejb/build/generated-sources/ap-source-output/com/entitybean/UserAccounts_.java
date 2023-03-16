package com.entitybean;

import com.entitybean.Feedbacks;
import com.entitybean.Orders;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-11-28T10:57:53")
@StaticMetamodel(UserAccounts.class)
public class UserAccounts_ { 

    public static volatile SingularAttribute<UserAccounts, String> userAccountUsername;
    public static volatile SingularAttribute<UserAccounts, String> userAccountAddress;
    public static volatile SingularAttribute<UserAccounts, String> userAccountPassword;
    public static volatile SingularAttribute<UserAccounts, String> userAccountEmail;
    public static volatile SingularAttribute<UserAccounts, Integer> userAccountID;
    public static volatile SingularAttribute<UserAccounts, Integer> userAccountPhone;
    public static volatile CollectionAttribute<UserAccounts, Orders> ordersCollection;
    public static volatile CollectionAttribute<UserAccounts, Feedbacks> feedbacksCollection;

}