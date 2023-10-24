package com.learn.order.controller;

import com.learn.order.dto.request.IngredientDTO;
import com.learn.order.dto.request.mappers.IngredientMapper;
import com.learn.order.entity.Ingredient;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.order.service.IngredientService;
import com.learn.order.service.IngredientServiceGet;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path= "/ingredient")
public class IngredientController {
    
    private final IngredientService ingredientService;
    private final IngredientServiceGet ingredientServiceGet;
    private final IngredientMapper ingredientMapper;

    public IngredientController(IngredientService ingredientService, IngredientServiceGet ingredientServiceGet,
            IngredientMapper ingredientMapper) {
        this.ingredientService = ingredientService;
        this.ingredientServiceGet = ingredientServiceGet;
        this.ingredientMapper = ingredientMapper;
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> getAll() {
        return ResponseEntity.ok(ingredientServiceGet.getAll());
    }

    @PostMapping
    public ResponseEntity<String> addNewIngredient(@Valid @RequestBody IngredientDTO data) {
        return ResponseEntity.ok(ingredientService.addNewIngredient(ingredientMapper.apply(data)));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(ingredientService.deleteById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody IngredientDTO data) {
        return ResponseEntity.ok(ingredientService.updateById(id, data));
    }
}
