/* (C) 2023 */
package com.learn.order.service;

import com.learn.order.entity.Ingredient;
import java.util.List;

public interface IngredientServiceGet {

  List<Ingredient> getAll();

  List<Ingredient> getFromList(List<Long> ingredients);
}
