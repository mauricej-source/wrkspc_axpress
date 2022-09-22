package com.axpress.orders;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<Order> orderList;
     
    public List<Order> getOrdersList() {
        if(orderList == null) {
            orderList = new ArrayList<>();
        }
        return orderList;
    }
  
    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    } 
}
