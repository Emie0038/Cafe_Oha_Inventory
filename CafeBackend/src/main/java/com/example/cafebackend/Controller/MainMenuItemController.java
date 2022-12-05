package com.example.cafebackend.Controller;


import com.example.cafebackend.Entity.MainMenuItem;
import com.example.cafebackend.Entity.MenuItem;
import com.example.cafebackend.Service.MainMenuItemService;
import com.example.cafebackend.Service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MainMenuItemController {

    private final MainMenuItemService mainMenuItemService;

    @Autowired
    public MainMenuItemController(MainMenuItemService mainMenuItemService) {
        this.mainMenuItemService = mainMenuItemService;
    }

    //Return all activities
    @GetMapping("mainMenu")
    public List<MainMenuItem> getAllMainMenuItems() {return mainMenuItemService.getAllMainMenuItems();}

    //Create a method that returns a single menu

    @GetMapping("mainMenu/{id}")
    public ResponseEntity<MainMenuItem> getMainMenuItemById(@PathVariable("id")Long id){
        MainMenuItem mainMenuItem = mainMenuItemService.getMainMenuItemById(id);
        return new ResponseEntity<>(mainMenuItem, HttpStatus.OK);
    }

    @PostMapping("mainMenu")
    public ResponseEntity<MainMenuItem> createMainMenuItem(@RequestBody MainMenuItem mainMenuItem){
        MainMenuItem newMainMenu = mainMenuItemService.createMainMenuItem(mainMenuItem);
        return new ResponseEntity<>(newMainMenu, HttpStatus.CREATED);
    }

    @PutMapping("mainMenu/{id}")
    public ResponseEntity<MainMenuItem> updateMainMenuItem(@RequestBody MainMenuItem newMainMenuItem, @PathVariable("id") Long id){
        return new ResponseEntity<>(mainMenuItemService.updateMainMenuItem(id, newMainMenuItem), HttpStatus.OK);
    }

    @DeleteMapping("mainMenu/{id}")
    public ResponseEntity<?> deleteMainMenuItem(@PathVariable("id") Long id){
        mainMenuItemService.deleteMainMenuItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}