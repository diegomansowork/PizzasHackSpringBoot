package com.dmanso.pizzashackSpringboot.services;

import com.dmanso.pizzashackSpringboot.model.MenuItem;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public interface MenuItemService {
    
    List<MenuItem> getMenuItems();

    Optional<MenuItem> getMenuItemById(Long id);

    MenuItem insert(MenuItem menuItem);

    void updateMenuItem(Long id, MenuItem menuItem);

    void deleteMenuItem(Long menuItemId);
    
}
