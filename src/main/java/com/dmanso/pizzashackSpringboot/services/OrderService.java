package com.dmanso.pizzashackSpringboot.services;

import com.dmanso.pizzashackSpringboot.model.PizzaOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface OrderService {
    
    List<PizzaOrder> getOrders();

    Optional<PizzaOrder> getOrderById(Long id);

    PizzaOrder insert(PizzaOrder order);

    void updateOrder(Long id, PizzaOrder order);

    void deleteOrder(Long orderId);

    void deliverOrder(Long orderId);

}
