package com.example.cafebackend.Service;

import com.example.cafebackend.Entity.MenuItem;
import com.example.cafebackend.Repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;
    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository){
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItem> getAllMenuItems(){ return menuItemRepository.findAll();}


    public MenuItem getMenuItemById(Long id) {
        return menuItemRepository.findById(id).orElse(null);
    }

    public MenuItem createMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public void deleteMenuItem(Long id) {
        menuItemRepository.deleteById(id);
    }

    public MenuItem updateMenuItem(Long id, MenuItem newMenuItem) {
        if(menuItemRepository.findById(id).isEmpty()) {
            return null;
        }

        return menuItemRepository.save(newMenuItem);
    }

}
