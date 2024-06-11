package com.dmanso.pizzashackSpringboot.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dmanso.pizzashackSpringboot.model.PizzaOrder;
import com.dmanso.pizzashackSpringboot.services.OrderService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    
    OrderService orderService;

    public DeliveryController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaOrder>> getAllItems() {
        try {
            List<PizzaOrder> orders = orderService.getOrders();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping({"/{orderId}"})
    public ResponseEntity<PizzaOrder> updateOrder(@PathVariable("orderId") Long orderId) {
        orderService.deliverOrder(orderId);
        Optional<PizzaOrder> optionalOrder = orderService.getOrderById(orderId);
        if(optionalOrder.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderService.getOrderById(orderId).get(), HttpStatus.OK);
    }

}
