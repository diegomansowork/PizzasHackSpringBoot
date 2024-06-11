package com.dmanso.pizzashackSpringboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dmanso.pizzashackSpringboot.model.MenuItem;
import com.dmanso.pizzashackSpringboot.repositories.MenuItemRepo;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    MenuItemRepo menuItemRepository;
 
    public MenuItemServiceImpl(MenuItemRepo menuItemRepository){
        this.menuItemRepository = menuItemRepository;
    }
    
    @Override
    public List<MenuItem> getMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItemRepository.findAll().forEach(menuItems::add);
        return menuItems;
    }

    @Override
    public Optional<MenuItem> getMenuItemById(Long id) {
        return menuItemRepository.findById(id);
    }

    @Override
    public MenuItem insert(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public void updateMenuItem(Long id, MenuItem menuItem) {
        MenuItem itemFromDb = menuItemRepository.findById(id).get();
        //System.out.println(itemFromDb.toString());
        itemFromDb.setDescription(menuItem.getDescription());
        itemFromDb.setName(menuItem.getName());
        itemFromDb.setIcon(menuItem.getIcon());
        itemFromDb.setPrice(menuItem.getPrice());
        menuItemRepository.save(itemFromDb);
    }

    @Override
    public void deleteMenuItem(Long menuItemId) {
        menuItemRepository.deleteById(menuItemId);
    }
    
}
