package com.learn.order.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learn.order.entity.Ingredient;
import com.learn.order.repository.IngredientRepository;
import com.learn.order.service.IngredientServiceGet;

@Service
public class IngredientServiceGetImpl implements IngredientServiceGet {

    private IngredientRepository ingredientRepository;

    public IngredientServiceGetImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public List<Ingredient> getFromList(List<Long> ingredients) {
        List<Ingredient> list = new ArrayList<Ingredient>();

        for(Long i: ingredients) {
            Optional<Ingredient> ingredient = ingredientRepository.findById(i);

            if(ingredient.isPresent()) {
                list.add(ingredient.get());
            }
        }

        return list;
    }

}
