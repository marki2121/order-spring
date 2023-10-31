/* (C) 2023 */
package com.learn.order.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.learn.order.entity.Ingredient;
import com.learn.order.errors.ErrorResponse;
import com.learn.order.repository.IngredientRepository;
import com.learn.order.support.entity.IngredientSupp;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class IngredientServiceGetImplTest {

  @MockBean private IngredientRepository ingredientRepository;
  @Autowired private IngredientServiceGetImpl ingredientService;

  @Test
  void testGetAll() {
    List<Ingredient> list = IngredientSupp.getAll();

    when(ingredientRepository.findAll()).thenReturn(list);

    List<Ingredient> test = ingredientService.getAll();

    assertEquals(list, test);
  }

  @Test
  void testGetAllFromList() {

    when(ingredientRepository.findById(1L))
        .thenReturn(Optional.of(IngredientSupp.getIngredient1()));
    when(ingredientRepository.findById(2L))
        .thenReturn(Optional.of(IngredientSupp.getIngredient2()));

    assertEquals(
        IngredientSupp.getAll().get(0).getName(),
        ingredientService.getFromList(List.of(1L, 2L)).get(0).getName());
  }

  @Test
  void testGetAllFromListAndFail() {

    when(ingredientRepository.findById(1L))
        .thenReturn(Optional.of(IngredientSupp.getIngredient1()));
    when(ingredientRepository.findById(2L))
        .thenThrow(new ErrorResponse(HttpStatus.NOT_FOUND, "Ingredient not found."));

    assertThrows(ErrorResponse.class, () -> ingredientService.getFromList(List.of(1L, 2L)));
  }
}
