/* (C) 2023 */
package com.learn.order.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.learn.order.dto.request.IngredientDTO;
import com.learn.order.entity.Ingredient;
import com.learn.order.errors.ErrorResponse;
import com.learn.order.repository.IngredientRepository;
import com.learn.order.support.entity.IngredientSupp;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class IngredientServiceImplTest {

  @MockBean private IngredientRepository ingredientRepository;
  @Autowired private IngredientServiceImpl ingredientService;

  @Test
  void testAddNewIngredient() {
    when(ingredientRepository.save(any(Ingredient.class))).thenReturn(new Ingredient());

    String test = ingredientService.addNewIngredient(new Ingredient());

    assertEquals(test, "Ingredient created.");
  }

  @Test
  void testDeleteById() {
    doNothing().when(ingredientRepository).deleteById(anyLong());

    assertEquals(ingredientService.deleteById(1L), "Deleted.");
  }

  @Test
  void testUpdateById() throws Exception {
    Ingredient ingredientDb = IngredientSupp.getIngredient1();
    IngredientDTO ingredientDTO = IngredientSupp.getIngredientDTO();

    when(ingredientRepository.findById(anyLong())).thenReturn(Optional.of(ingredientDb));

    assertEquals(ingredientService.updateById(1L, ingredientDTO), "Updated.");
  }

  @Test
  void testUpdateByIdAndThrow() throws Exception {
    IngredientDTO ingredientDTO = IngredientSupp.getIngredientDTO();

    when(ingredientRepository.findById(anyLong()))
        .thenThrow(new ErrorResponse(HttpStatus.NOT_FOUND, "Ingredient not found."));

    assertThrows(ErrorResponse.class, () -> ingredientService.updateById(1L, ingredientDTO));
  }
}
