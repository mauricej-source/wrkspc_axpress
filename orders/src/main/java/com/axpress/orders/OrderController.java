package com.axpress.orders;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    @Autowired
    private OrderDAO orderDao;
     
    @GetMapping(path="/", produces = "application/json")
    public Products getProducts() 
    {
        return orderDao.getProducts();
    }

    @GetMapping(path="/listoforders", produces = "application/json")
    public Orders getOrders() 
    {
        return orderDao.getOrders();
    }

    @GetMapping(path="/ordertotal", produces = "application/json")
    public OrderTotal getOrderTotal() 
    {
        return orderDao.getOrderTotal();
    }

    @GetMapping(path= "/findorder",  produces = "application/json")
    public Order getOrder(@RequestBody Order ord) 
    {
        Order foundOrder = orderDao.getOrder(ord);
         
        return foundOrder;
    }

    @GetMapping(path= "/product",  produces = "application/json")
    public Product getProduct(@RequestBody Product item) 
    {
        Product foundProduct = orderDao.getProduct(item);
         
        return foundProduct;
    }

    @DeleteMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> deleteProduct(@RequestBody Product item) 
    {
        boolean results = orderDao.removeProduct(item);
         
        if (!results) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(202, HttpStatus.OK);
    }

    @PostMapping(path= "/addorder", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addOrder(@RequestBody Order order) 
    {
        Integer orderID = orderDao.getOrders().getOrdersList().size() + 1;
        order.setOrderID(orderID);
         
        orderDao.addOrder(order);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{barCode}")
                                    .buildAndExpand(order.getOrderID())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addProduct(@RequestBody Product item) 
    {
        Integer barCode = orderDao.getProducts().getProductList().size() + 1;
        item.setBarcode(barCode);
         
        orderDao.addProduct(item);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{barCode}")
                                    .buildAndExpand(item.getBarcode())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }
}
