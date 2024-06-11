package com.dmanso.pizzashackSpringboot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dmanso.pizzashackSpringboot.model.MenuItem;

@Repository
public interface MenuItemRepo extends CrudRepository<MenuItem, Long>{
}
