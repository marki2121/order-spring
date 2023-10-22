package com.learn.order.service.impl;

import org.springframework.stereotype.Service;

import com.learn.order.dto.request.IngredientDTO;
import com.learn.order.entity.Ingredient;
import com.learn.order.repository.IngredientRepository;
import com.learn.order.service.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService {
    
    private IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public String addNewIngredient(Ingredient data) {
        ingredientRepository.save(data);

        return "Ingredient created.";
    }

    @Override
    public String deleteById(Long id) {
        ingredientRepository.deleteById(id);

        return "Deleted.";
    }

    @Override
    public String updateById(Long id, IngredientDTO data) {
        Ingredient ingredientDb = ingredientRepository.findById(id).orElseThrow(RuntimeException::new);

        if(!ingredientDb.getName().equals(data.getName()) && !data.getName().isBlank()) {
            ingredientDb.setName(data.getName());
        }
        if(!ingredientDb.getProtein().equals(data.getProtein()) && data.getProtein() >= 0) {
            ingredientDb.setProtein(data.getProtein());
        }
        if(!ingredientDb.getEnergy().equals(data.getEnergy()) && data.getEnergy() >= 0) {
            ingredientDb.setEnergy(data.getEnergy());
        }
        if(!ingredientDb.getFat().equals(data.getFat()) && data.getFat() >= 0) {
            ingredientDb.setFat(data.getFat());
        }
        if(!ingredientDb.getSodium().equals(data.getSodium()) && data.getSodium() >= 0) {
            ingredientDb.setSodium(data.getSodium());
        }
        if(!ingredientDb.getCarbs().equals(data.getCarbs()) && data.getCarbs() >= 0) {
            ingredientDb.setCarbs(data.getCarbs());
        }

        ingredientRepository.save(ingredientDb);

        return "Updated.";
    }
}
