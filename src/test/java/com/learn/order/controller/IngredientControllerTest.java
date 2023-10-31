/* (C) 2023 */
package com.learn.order.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.order.dto.request.IngredientDTO;
import com.learn.order.dto.request.mappers.IngredientMapper;
import com.learn.order.entity.Ingredient;
import com.learn.order.service.IngredientService;
import com.learn.order.service.IngredientServiceGet;
import com.learn.order.support.entity.IngredientSupp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class IngredientControllerTest {

  @MockBean private IngredientService ingredientService;
  @MockBean private IngredientServiceGet ingredientServiceGet;
  @MockBean private IngredientMapper ingredientMapper;
  @Autowired private MockMvc mockMvc;

  @Test
  public void getTest() throws Exception {
    ObjectMapper om = new ObjectMapper();

    when(ingredientServiceGet.getAll()).thenReturn(IngredientSupp.getAll());

    mockMvc
        .perform(get("/ingredient"))
        .andExpect(status().isOk())
        .andExpect(content().json(om.writeValueAsString(IngredientSupp.getAll())));
  }

  @Test
  public void deleteTest() throws Exception {
    when(ingredientService.deleteById(anyLong())).thenReturn("Deleted.");

    mockMvc
        .perform(delete("/ingredient/1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("Deleted."));
  }

  @Test
  public void postTestSuccess() throws JsonProcessingException, Exception {
    IngredientDTO dto = IngredientSupp.getIngredientDTO();
    ObjectMapper om = new ObjectMapper();

    when(ingredientService.addNewIngredient(any(Ingredient.class))).thenReturn("Saved.");

    mockMvc
        .perform(
            post("/ingredient")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(dto)))
        .andExpect(status().isOk());
  }

  @Test
  public void postTestFailNoName() throws JsonProcessingException, Exception {
    IngredientDTO dto = IngredientSupp.getIngredientDTO();
    ObjectMapper om = new ObjectMapper();

    dto.setName("");

    mockMvc
        .perform(
            post("/ingredient")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(dto)))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postTestFailBadEnergy() throws JsonProcessingException, Exception {
    IngredientDTO dto = IngredientSupp.getIngredientDTO();
    ObjectMapper om = new ObjectMapper();

    dto.setEnergy(-1);

    mockMvc
        .perform(
            post("/ingredient")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(dto)))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postTestFailBadProtein() throws JsonProcessingException, Exception {
    IngredientDTO dto = IngredientSupp.getIngredientDTO();
    ObjectMapper om = new ObjectMapper();

    dto.setProtein(-1.0);

    mockMvc
        .perform(
            post("/ingredient")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(dto)))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postTestFailBadSodium() throws JsonProcessingException, Exception {
    IngredientDTO dto = IngredientSupp.getIngredientDTO();
    ObjectMapper om = new ObjectMapper();

    dto.setSodium(-1.0);

    mockMvc
        .perform(
            post("/ingredient")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(dto)))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postTestFailBadFat() throws JsonProcessingException, Exception {
    IngredientDTO dto = IngredientSupp.getIngredientDTO();
    ObjectMapper om = new ObjectMapper();

    dto.setFat(-1.0);

    mockMvc
        .perform(
            post("/ingredient")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(dto)))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postTestFailBadCarbs() throws JsonProcessingException, Exception {
    IngredientDTO dto = IngredientSupp.getIngredientDTO();
    ObjectMapper om = new ObjectMapper();

    dto.setCarbs(-1.0);

    mockMvc
        .perform(
            post("/ingredient")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(dto)))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void putTestSuccess() throws JsonProcessingException, Exception {
    ObjectMapper om = new ObjectMapper();
    IngredientDTO dto = IngredientSupp.getIngredientDTO();

    when(ingredientService.updateById(anyLong(), any(IngredientDTO.class))).thenReturn("Updated.");

    mockMvc
        .perform(
            put("/ingredient/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(dto)))
        .andExpect(status().isOk());
  }
}
