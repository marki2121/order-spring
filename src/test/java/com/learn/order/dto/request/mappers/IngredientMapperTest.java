/* (C) 2023 */
package com.learn.order.dto.request.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.learn.order.dto.request.IngredientDTO;
import com.learn.order.entity.Ingredient;
import com.learn.order.support.entity.IngredientSupp;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IngredientMapperTest {

  @Autowired private IngredientMapper ingredientMapper;

  @Test
  void testApply() {
    IngredientDTO dto = IngredientSupp.getIngredientDTO();
    Ingredient ingredient = IngredientSupp.getIngredientMapper();

    Ingredient test = ingredientMapper.apply(dto);

    assertEquals(ingredient.getCarbs(), test.getCarbs());
    assertEquals(ingredient.getName(), test.getName());
    assertEquals(ingredient.getEnergy(), test.getEnergy());
    assertEquals(ingredient.getFat(), test.getFat());
  }

  @Test
  void testMapToList() {
    List<IngredientDTO> listDto = List.of(IngredientSupp.getIngredientDTO());
    List<Ingredient> list = List.of(IngredientSupp.getIngredientMapper());

    List<Ingredient> test = ingredientMapper.mapToList(listDto);

    assertEquals(test.get(0).getName(), list.get(0).getName());
  }
}
