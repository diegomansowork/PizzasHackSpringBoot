package com.dmanso.pizzashackSpringboot.controllers;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmanso.pizzashackSpringboot.model.MenuItem;
import com.dmanso.pizzashackSpringboot.services.MenuItemService;

@RestController
@RequestMapping("/menu")
public class MenuItemController {
    
    MenuItemService itemsService;

    public MenuItemController(MenuItemService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping
    public ResponseEntity<List<MenuItem>> getAllItems() {
        try {
            List<MenuItem> items = itemsService.getMenuItems();
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
//
//    @GetMapping({"/"})
//    public ResponseEntity<Item> getItem(@PathVariable Long itemId, @RequestParam(required = false) Integer delayInSeconds) {
//        try {
//            if(delayInSeconds==null){
//                delayInSeconds = 0;
//            }
//            TimeUnit.SECONDS.sleep(delayInSeconds);
//
//            Optional<Item> optionalItem = itemsService.getItemById(itemId);
//
//            if(!optionalItem.isPresent()){
//                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//            }
//            return new ResponseEntity<>(optionalItem.get(), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<Item> saveItem(@RequestBody Item item) {
//        if(item.getName()!=null && !item.getName().equals("") && item.getVendorId()!= 0){
//            Item item1 = itemsService.insert(item);
//            HttpHeaders httpHeaders = new HttpHeaders();
//            httpHeaders.add("item", "/utils/items/" + item1.getId());
//            return new ResponseEntity<>(item1, httpHeaders, HttpStatus.CREATED);
//        }else{
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//
//    }
//
//    @PutMapping({"/{itemId}"})
//    public ResponseEntity<Item> updateItem(@PathVariable("itemId") Long itemId, @RequestBody Item item) {
//        itemsService.updateItem(itemId, item);
//        Optional<Item> optionalItem = itemsService.getItemById(itemId);
//        if(!optionalItem.isPresent()){
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(itemsService.getItemById(itemId).get(), HttpStatus.OK);
//    }
//
//    @DeleteMapping({"/{itemId}"})
//    public ResponseEntity<Item> deleteItem(@PathVariable("itemId") Long itemId) {
//        Optional<Item> optionalItem = itemsService.getItemById(itemId);
//        if(!optionalItem.isPresent()){
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//        itemsService.deleteItem(itemId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

}
