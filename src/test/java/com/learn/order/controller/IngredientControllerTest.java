package com.learn.order.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.learn.order.dto.request.mappers.IngredientMapper;
import com.learn.order.service.IngredientService;
import com.learn.order.service.IngredientServiceGet;
import com.learn.order.support.entity.IngredientSupp;

@SpringBootTest
@AutoConfigureMockMvc
public class IngredientControllerTest {

    @MockBean
    private IngredientService ingredientService;
    @MockBean
    private IngredientServiceGet ingredientServiceGet;
    @MockBean
    private IngredientMapper ingredientMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTest() throws Exception {
        when(ingredientServiceGet.getAll()).thenReturn(IngredientSupp.getAll());

        mockMvc.perform(get("/ingredient"))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void deleteTest() throws Exception {
        when(ingredientService.deleteById(anyLong())).thenReturn("Deleted.");

        mockMvc.perform(delete("/ingredient/1"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("Deleted."));
    }

    
    
}
