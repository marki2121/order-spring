package com.learn.order.service;

import com.learn.order.dto.request.IngredientDTO;
import com.learn.order.entity.Ingredient;

public interface IngredientService {

    String addNewIngredient(Ingredient data);

    String deleteById(Long id);

    String updateById(Long id, IngredientDTO data);
    
}
