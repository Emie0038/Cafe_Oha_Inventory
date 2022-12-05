package com.example.cafebackend.Repository;

import com.example.cafebackend.Entity.MainMenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainMenuItemRepository extends JpaRepository<MainMenuItem, Long> {
}
