package com.learn.order.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.learn.order.dto.request.IngredientDTO;
import com.learn.order.entity.Ingredient;
import com.learn.order.repository.IngredientRepository;
import com.learn.order.support.entity.IngredientSupp;

@SpringBootTest
public class IngredientServiceImplTest {

    @MockBean
    private IngredientRepository ingredientRepository;
    @Autowired
    private IngredientServiceImpl ingredientService;
    
    @Test
    void testAddNewIngredient() {
        when(ingredientRepository.save(any(Ingredient.class))).thenReturn(new Ingredient());

        String test = ingredientService.addNewIngredient(new Ingredient());

        assertEquals(test, "Ingredient created.");
    }

    @Test
    void testDeleteById() {
        doNothing().when(ingredientRepository).deleteById(anyLong());

        String test = ingredientService.deleteById(1L);

        assertEquals(test, "Deleted.");
    }

    @Test
    void testUpdateById() throws Exception {
        Ingredient ingredientDb = IngredientSupp.getIngredient1();
        IngredientDTO ingredientDTO = IngredientSupp.getIngredientDTO();

        when(ingredientRepository.findById(anyLong())).thenReturn(Optional.of(ingredientDb));

        String test = ingredientService.updateById(1L, ingredientDTO);

        assertEquals(test, "Updated.");
    }

    @Test
    void testUpdateByIdAndFail() throws Exception {
        IngredientDTO ingredientDTO = IngredientSupp.getIngredientDTO();

        when(ingredientRepository.findById(anyLong())).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class,() -> ingredientService.updateById(1L, ingredientDTO));
    }
}
