package com.example.cafebackend.Repository;

import com.example.cafebackend.Entity.IngredientPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientPriceRepository extends JpaRepository<IngredientPrice,Long> {
}
