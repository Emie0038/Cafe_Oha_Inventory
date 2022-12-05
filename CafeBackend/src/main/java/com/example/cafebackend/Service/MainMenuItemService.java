package com.example.cafebackend.Service;

import com.example.cafebackend.Entity.MainMenuItem;
import com.example.cafebackend.Entity.MenuItem;
import com.example.cafebackend.Repository.MainMenuItemRepository;
import com.example.cafebackend.Repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainMenuItemService {

    private final MainMenuItemRepository mainMenuItemRepository;
    @Autowired
    public MainMenuItemService(MainMenuItemRepository mainMenuItemRepository){
        this.mainMenuItemRepository = mainMenuItemRepository;
    }

    public List<MainMenuItem> getAllMainMenuItems(){ return mainMenuItemRepository.findAll();}


    public MainMenuItem getMainMenuItemById(Long id) {
        return mainMenuItemRepository.findById(id).orElse(null);
    }

    public MainMenuItem createMainMenuItem(MainMenuItem mainMenuItem) {
        return mainMenuItemRepository.save(mainMenuItem);
    }

    public void deleteMainMenuItem(Long id) {
        mainMenuItemRepository.deleteById(id);
    }

    public MainMenuItem updateMainMenuItem(Long id, MainMenuItem newMainMenuItem) {
        if(mainMenuItemRepository.findById(id).isEmpty()) {
            return null;
        }

        return mainMenuItemRepository.save(newMainMenuItem);
    }

}