package com.dmanso.pizzashackSpringboot.services;

import com.dmanso.pizzashackSpringboot.model.PizzaOrder;
import com.dmanso.pizzashackSpringboot.repositories.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    OrderRepo orderRepository;

    public OrderServiceImpl(OrderRepo orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public List<PizzaOrder> getOrders() {

        List<PizzaOrder> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;

    }

    @Override
    public Optional<PizzaOrder> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public PizzaOrder insert(PizzaOrder order) {
        return orderRepository.save(order);
    }

    @Override
    public void updateOrder(Long id, PizzaOrder order) {
        PizzaOrder orderFromDb = orderRepository.findById(id).get();
        //System.out.println(itemFromDb.toString());
        orderFromDb.setAddress(order.getAddress());
        //orderFromDb.setDelivered(true);
        orderFromDb.setQuantity(order.getQuantity());
        orderFromDb.setCustomerName(order.getCustomerName());
        orderFromDb.setPizzaType(order.getPizzaType());
        orderFromDb.setCreditCardNumber(order.getCreditCardNumber());
        orderRepository.save(orderFromDb);
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public void deliverOrder(Long id) {
        PizzaOrder orderFromDb = orderRepository.findById(id).get();
        orderFromDb.setDelivered(true);
        orderRepository.save(orderFromDb);
    }
}
