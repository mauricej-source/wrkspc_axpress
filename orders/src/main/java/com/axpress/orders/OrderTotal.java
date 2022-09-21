package com.axpress.orders;

import java.util.ArrayList;
import java.util.List;

public class OrderTotal {
    private List<String> lineItems;
    private double totalCost;

    public OrderTotal() {
        lineItems = new ArrayList<String>();
        totalCost = 0.00;
    }

    public List<String> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<String> lineItems) {
        this.lineItems = lineItems;
    }

    public double getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
