package com.dmanso.pizzashackSpringboot.controllers;


import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmanso.pizzashackSpringboot.model.PizzaOrder;
import com.dmanso.pizzashackSpringboot.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping({"/{orderId}"})
    public ResponseEntity<PizzaOrder> getOrder(@PathVariable Long orderId) {
        try {
            Optional<PizzaOrder> optionalOrder = orderService.getOrderById(orderId);
            return optionalOrder.map(order -> new ResponseEntity<>(order, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<PizzaOrder> saveOrder(@RequestBody PizzaOrder order) {
        if(!order.getAddress().isEmpty() && order.getPizzaType()!= null && !order.getCustomerName().isEmpty()){
            PizzaOrder order1 = orderService.insert(order);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("order", "/order/" + order.getOrderId());
            return new ResponseEntity<>(order1, httpHeaders, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping({"/{orderId}"})
    public ResponseEntity<PizzaOrder> updateOrder(@PathVariable("orderId") Long orderId, @RequestBody PizzaOrder order) {
        orderService.updateOrder(orderId, order);
        Optional<PizzaOrder> optionalOrder = orderService.getOrderById(orderId);
        if(optionalOrder.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderService.getOrderById(orderId).get(), HttpStatus.OK);
    }

    @DeleteMapping({"/{orderId}"})
    public ResponseEntity<PizzaOrder> deleteOrder(@PathVariable("orderId") Long orderId) {
        Optional<PizzaOrder> optionalOrder = orderService.getOrderById(orderId);
        if(optionalOrder.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
    

}
