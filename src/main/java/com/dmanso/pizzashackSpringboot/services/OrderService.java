package com.dmanso.pizzashackSpringboot.services;

import com.dmanso.pizzashackSpringboot.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface OrderService {
    
    List<Order> getOrders();

    Optional<Order> getOrderById(Long id);

    Order insert(Order order);

    void updateOrder(Long id, Order order);

    void deleteOrder(Long orderId);

    void deliverOrder(Long orderId);

}
