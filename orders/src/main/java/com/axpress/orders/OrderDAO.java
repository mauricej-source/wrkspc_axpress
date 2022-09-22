package com.axpress.orders;

import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO {
    private static Orders listOfOrders = new Orders();
    private static Products listOfProduct = new Products();
    private static OrderTotal orderReceipt = new OrderTotal();

    static
    {
        listOfProduct.getProductList().add(new Product(1, "apple", 0.60, 241, 8));
        listOfProduct.getProductList().add(new Product(2, "orange", 0.25, 342, 6));

        listOfOrders.getOrdersList().add(new Order(1, listOfProduct.getProductList()));
    }
     
    public Products getProducts() 
    {
        return listOfProduct;
    }

    public Orders getOrders() 
    {
        return listOfOrders;
    }

    public void addOrder(Order order) {
        listOfOrders.getOrdersList().add(order);
    }

    public void addProduct(Product product) {
        listOfProduct.getProductList().add(product);
    }

    public boolean removeProduct(Product product) {
        boolean retFlag = false;

        for (int i = 0; i < listOfProduct.getProductList().size(); i++){
            int barCodeFound = listOfProduct.getProductList().get(i).getBarcode();

            if(product.getBarcode() == barCodeFound){
                listOfProduct.getProductList().remove(i);
                retFlag = true;
            }
        }

        return retFlag;
    }

    public boolean removeOrder(Order order) {
        boolean retFlag = false;

        for (int i = 0; i < listOfOrders.getOrdersList().size(); i++){
            int orderIDFound = listOfOrders.getOrdersList().get(i).getOrderID();

            if(order.getOrderID() == orderIDFound){
                listOfOrders.getOrdersList().remove(i);
                retFlag = true;
            }
        }

        return retFlag;
    }

    public Product getProduct(Product product) {
        Product foundProduct = new Product();
        for (int i = 0; i < listOfProduct.getProductList().size(); i++){
            int barCodeFound = listOfProduct.getProductList().get(i).getBarcode();

            if(product.getBarcode() == barCodeFound)
                foundProduct = listOfProduct.getProductList().get(i);
        }

        return foundProduct;
    }

    public Order getOrder(Order order) {
        Order foundOrder = new Order();
        for (int i = 0; i < listOfOrders.getOrdersList().size(); i++){
            int orderIDFound = listOfOrders.getOrdersList().get(i).getOrderID();

            if(order.getOrderID() == orderIDFound)
            foundOrder = listOfOrders.getOrdersList().get(i);
        }

        return foundOrder;
    }

    public OrderTotal getOrderTotal() 
    {
        String lineItem = "";
        String product = "";
        int quantity = 0;
        double cost = 0.00;
        double totalLineCost = 0.00;
        double totalCost = 0.00;
        int offer = 0;
        int productOfferDivisor = 0;
        int productOfferMultiplier = 0;

        orderReceipt = new OrderTotal();

        for (int i = 0; i < listOfProduct.getProductList().size(); i++){
            product = listOfProduct.getProductList().get(i).getType();
            quantity = listOfProduct.getProductList().get(i).getQuantity();
            cost = listOfProduct.getProductList().get(i).getCost();
            offer = listOfProduct.getProductList().get(i).getOffer();

            productOfferDivisor = Integer.parseInt(Integer.toString(offer).substring(0, 1));
            productOfferMultiplier = Integer.parseInt(Integer.toString(offer).substring(2, 3));

            totalLineCost = (quantity/productOfferDivisor) * (cost*productOfferMultiplier);

            lineItem = lineItem + product + " x " + quantity + " @ " + cost + " DSCNT-" + offer + ": " + totalLineCost;
            orderReceipt.getLineItems().add(lineItem);

            totalCost = Double.sum(totalCost, totalLineCost);

            totalLineCost = 0;
            lineItem = "";
        }
        
        orderReceipt.setTotalCost(totalCost);

        return orderReceipt;
    }    
}
