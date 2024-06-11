package com.dmanso.pizzashackSpringboot.bootstrap;

import com.dmanso.pizzashackSpringboot.model.MenuItem;
import com.dmanso.pizzashackSpringboot.repositories.MenuItemRepo;

import java.text.DecimalFormat;
import java.util.Random;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MenuItemLoader implements CommandLineRunner {
    public final MenuItemRepo menuItemRepository;

    public MenuItemLoader(MenuItemRepo menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadItems();
    }

    private void loadItems() {
        Random rand = new Random();
        DecimalFormat format = new DecimalFormat("#.##");
        System.out.println("Loading menus...");
        if (menuItemRepository.count() == 0) {
            menuItemRepository.save(
                    MenuItem.builder()
                            .name("Chicken Parmesan")
                            .description("Grilled chicken, fresh tomatoes, feta and mozzarella cheese")
                            .price(format.format(rand.nextInt(20) + 10 - 0.01))
                            .icon("/images/1.png")
                            .build()
            );
            menuItemRepository.save(
                    MenuItem.builder()
                            .name("Spicy Italian")
                            .description("Pepperoni and a double portion of spicy Italian sausage")
                            .price(format.format(rand.nextInt(20) + 10 - 0.01))
                            .icon("/images/2.png")
                            .build()
            );
            menuItemRepository.save(
                    MenuItem.builder()
                            .name("Garden Fresh")
                            .description("Slices onions and green peppers, gourmet " +
                                    "mushrooms, black olives and ripe Roma tomatoes")
                            .price(format.format(rand.nextInt(20) + 10 - 0.01))
                            .icon("/images/3.png")
                            .build()
            );
            menuItemRepository.save(
                    MenuItem.builder()
                            .name("Tuscan Six Cheese")
                            .description("Six cheese blend of mozzarella, Parmesan, Romano, Asiago and Fontina")
                            .price(format.format(rand.nextInt(20) + 10 - 0.01))
                            .icon("/images/4.png")
                            .build()
            );
            menuItemRepository.save(
                    MenuItem.builder()
                            .name("Spinach Alfredo")
                            .description("Rich and creamy blend of spinach and garlic Parmesan with Alfredo sauce")
                            .price(format.format(rand.nextInt(20) + 10 - 0.01))
                            .icon("/images/5.png")
                            .build()
            );
            menuItemRepository.save(
                    MenuItem.builder()
                            .name("BBQ Chicken Bacon")
                            .description("Grilled white chicken, hickory-smoked bacon and fresh sliced onions in barbeque sauce")
                            .price(format.format(rand.nextInt(20) + 10 - 0.01))
                            .icon("/images/6.png")
                            .build()
            );
            menuItemRepository.save(
                    MenuItem.builder()
                            .name("Hawaiian BBQ Chicken")
                            .description("Grilled white chicken, hickory-smoked bacon, barbeque sauce topped with sweet pine-apple")
                            .price(format.format(rand.nextInt(20) + 10 - 0.01))
                            .icon("/images/7.png")
                            .build()
            );
            menuItemRepository.save(
                    MenuItem.builder()
                            .name("Grilled Chicken Club")
                            .description("Grilled white chicken, hickory-smoked bacon and fresh sliced onions topped with Roma tomatoes")
                            .price(format.format(rand.nextInt(20) + 10 - 0.01))
                            .icon("/images/8.png")
                            .build()
            );
            menuItemRepository.save(
                    MenuItem.builder()
                            .name("Double Bacon 6Cheese")
                            .description("Hickory-smoked bacon, Julienne cut Canadian bacon, Parmesan, " +
                                    "mozzarella, Romano, Asiago and and Fontina cheese")
                            .price(format.format(rand.nextInt(20) + 10 - 0.01))
                            .icon("/images/9.png")
                            .build()
            );
            menuItemRepository.save(
                    MenuItem.builder()
                            .name("Chilly Chicken Cordon Bleu")
                            .description("Spinash Alfredo sauce topped with grilled chicken, ham, onions and " +
                                    "mozzarella")
                            .price(format.format(rand.nextInt(20) + 10 - 0.01))
                            .icon("/images/10.png")
                            .build()
            );
            System.out.println("Sample Menus Loaded");
        }
    }
}

