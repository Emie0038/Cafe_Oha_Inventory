package com.example.cafebackend.Controller;

import com.example.cafebackend.Entity.Ingredient;
import com.example.cafebackend.Entity.IngredientPrice;
import com.example.cafebackend.Repository.IngredientPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ingredients/price")
@CrossOrigin
public class IngredientPriceController {

    @Autowired
    IngredientPriceRepository ingredientPriceRepository;

    @GetMapping()
    public List<IngredientPrice> getIngredientsPrice(){
        return ingredientPriceRepository.findAll();
    }

    @GetMapping("/{id}")
    public IngredientPrice getIngredientPriceById(@PathVariable("id") Long id){
        return ingredientPriceRepository.findById(id).orElseThrow(()-> new IllegalStateException("ingredient with id="+id+" not found"));
    }

    @PostMapping()
    public ResponseEntity<String> addIngredientPrice(@RequestBody IngredientPrice ingredientPrice){
        ingredientPriceRepository.save(ingredientPrice);
        return new ResponseEntity<>("added ingredient", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateIngredientPrice(@PathVariable("id") Long id, @RequestBody IngredientPrice ingredientPrice){
        ingredientPrice.setId(id);
        ingredientPriceRepository.save(ingredientPrice);
        return new ResponseEntity<>("updated ingredient", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIngredientPrice(@PathVariable("id") Long id){
        ingredientPriceRepository.deleteById(id);
        return new ResponseEntity<>("deleted ingredient", HttpStatus.OK);    }
}
