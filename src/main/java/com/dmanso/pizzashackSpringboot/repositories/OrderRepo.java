package com.dmanso.pizzashackSpringboot.repositories;

import com.dmanso.pizzashackSpringboot.model.PizzaOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends CrudRepository<PizzaOrder, Long>{
}
