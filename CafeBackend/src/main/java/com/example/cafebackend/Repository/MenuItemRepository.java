package com.example.cafebackend.Repository;

import com.example.cafebackend.Entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
