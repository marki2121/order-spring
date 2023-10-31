/* (C) 2023 */
package com.learn.order.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.learn.order.entity.Ingredient;
import com.learn.order.repository.IngredientRepository;
import com.learn.order.support.entity.IngredientSupp;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
}
