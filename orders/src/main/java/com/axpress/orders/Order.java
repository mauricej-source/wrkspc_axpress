package com.axpress.orders;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderID;
    private List<Product> prouductList;

    public Order (int orderID, List<Product> prouductList){
        this.orderID = orderID;
        this.prouductList = prouductList;
    }

    public Order() {
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public List<Product> getProductList() {
        if(prouductList == null) {
            prouductList = new ArrayList<>();
        }
        return prouductList;
    }
  
    public void setProductList(List<Product> prouductList) {
        this.prouductList = prouductList;
    }      
}
