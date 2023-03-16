package com.entitybean;

import com.entitybean.OrderDetailsPK;
import com.entitybean.Orders;
import com.entitybean.Products;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-11-28T10:57:53")
@StaticMetamodel(OrderDetails.class)
public class OrderDetails_ { 

    public static volatile SingularAttribute<OrderDetails, OrderDetailsPK> orderDetailsPK;
    public static volatile SingularAttribute<OrderDetails, BigDecimal> orderDetailPrice;
    public static volatile SingularAttribute<OrderDetails, Integer> orderDetailDiscount;
    public static volatile SingularAttribute<OrderDetails, Orders> orders;
    public static volatile SingularAttribute<OrderDetails, Integer> orderDetailQuantity;
    public static volatile SingularAttribute<OrderDetails, Products> products;

}