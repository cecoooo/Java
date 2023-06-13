package org.example;

import java.util.Date;

public class Order {
    private java.sql.Timestamp orderDate;
    private String firmName;

    public Order(){}

    public Order(java.sql.Timestamp date, String firmName){
        this.orderDate = date;
        this.firmName = firmName;
    }

    public java.sql.Timestamp getOrderDate() {
        return orderDate;
    }

    public String getFirmName() {
        return firmName;
    }
}
