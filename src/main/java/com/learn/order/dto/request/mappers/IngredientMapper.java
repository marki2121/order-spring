/* (C) 2023 */
package com.learn.order.dto.request.mappers;

import com.learn.order.dto.request.IngredientDTO;
import com.learn.order.entity.Ingredient;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.springframework.stereotype.Service;

@Service
public class IngredientMapper implements Function<IngredientDTO, Ingredient> {

  @Override
  public Ingredient apply(IngredientDTO t) {
    return new Ingredient(
        t.getName(), t.getEnergy(), t.getProtein(), t.getFat(), t.getCarbs(), t.getSodium());
  }

  public List<Ingredient> mapToList(List<IngredientDTO> data) {
    List<Ingredient> list = new ArrayList<Ingredient>();

    for (IngredientDTO d : data) {
      list.add(apply(d));
    }

    return list;
  }
}
