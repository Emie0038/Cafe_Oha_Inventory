package com.example.cafebackend.Controller;


import com.example.cafebackend.Entity.MenuItem;
import com.example.cafebackend.Service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MenuItemController {

    private final MenuItemService menuItemService;

    @Autowired
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    //Return all activities
    @GetMapping("menu")
    public List<MenuItem> getAllMenuItems() {return menuItemService.getAllMenuItems();}

    //Create a method that returns a single menu

    @GetMapping("menu/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable("id")Long id){
        MenuItem menuItem = menuItemService.getMenuItemById(id);
        return new ResponseEntity<>(menuItem, HttpStatus.OK);
    }

    @PostMapping("menu")
    public ResponseEntity<MenuItem> createMenuItem(@RequestBody MenuItem menuItem){
        MenuItem newMenu = menuItemService.createMenuItem(menuItem);
        return new ResponseEntity<>(newMenu, HttpStatus.CREATED);
    }

    @PutMapping("menu/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@RequestBody MenuItem newMenuItem, @PathVariable("id") Long id){
        return new ResponseEntity<>(menuItemService.updateMenuItem(id, newMenuItem), HttpStatus.OK);
    }

    @DeleteMapping("menu/{id}")
    public ResponseEntity<?> deleteMenuItem(@PathVariable("id") Long id){
        menuItemService.deleteMenuItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
