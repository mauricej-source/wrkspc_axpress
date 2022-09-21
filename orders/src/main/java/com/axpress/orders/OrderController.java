package com.axpress.orders;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    
    @GetMapping(path="/ordertotal", produces = "application/json")
    public OrderTotal getOrderTotal() 
    {
        return orderDao.getOrderTotal();
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
