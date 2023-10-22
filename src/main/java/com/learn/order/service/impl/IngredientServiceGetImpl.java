package com.learn.order.service.impl;

import java.util.List;

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

}
