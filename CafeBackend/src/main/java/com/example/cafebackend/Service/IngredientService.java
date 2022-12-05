package com.example.cafebackend.Service;

import com.example.cafebackend.Entity.Ingredient;
import com.example.cafebackend.Repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    public List<Ingredient> getIngredient() {
        return ingredientRepository.findAll();
    }

    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }

    public Ingredient updateIngredient(Long id, Ingredient newIngredient) {
        if(ingredientRepository.findById(id).isEmpty()) {
            return null;
        }

        return ingredientRepository.save(newIngredient);
    }
}
