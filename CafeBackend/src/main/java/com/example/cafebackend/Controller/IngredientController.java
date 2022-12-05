package com.example.cafebackend.Controller;

import com.example.cafebackend.Entity.Ingredient;
import com.example.cafebackend.Repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/ingredients")
@CrossOrigin
public class IngredientController {

    @Autowired
    IngredientRepository ingredientRepository;

    @GetMapping()
    public List<Ingredient> getIngredients(){
        return ingredientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable("id") Long id){
        return ingredientRepository.findById(id).orElseThrow(()-> new IllegalStateException("ingredient with id="+id+" not found"));
    }

    @PostMapping()
    public ResponseEntity<String> addIngredient(@RequestBody Ingredient ingredient){
        ingredientRepository.save(ingredient);
        return new ResponseEntity<>("added ingredient", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateIngredient(@PathVariable("id") Long id, @RequestBody Ingredient ingredient){
        ingredient.setId(id);
        ingredientRepository.save(ingredient);
        return new ResponseEntity<>("updated ingredient", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIngredient(@PathVariable("id") Long id){
        ingredientRepository.deleteById(id);
        return new ResponseEntity<>("deleted ingredient", HttpStatus.OK);
    }
    @DeleteMapping()
    public ResponseEntity<String> deleteIngredients(){
        ingredientRepository.deleteAll();
        return new ResponseEntity<>("deleted all ingredient", HttpStatus.OK);
    }
}
