/* (C) 2023 */
package com.learn.order.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.order.dto.request.ProductDTO;
import com.learn.order.service.ProductService;
import com.learn.order.service.ProductServiceGet;
import com.learn.order.support.entity.ProduceSupp;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

  @MockBean private ProductService productService;
  @MockBean private ProductServiceGet privatServiceGet;

  @Autowired private MockMvc mockMvc;

  @Test
  void testDeleteById() throws Exception {
    when(productService.deleteById(anyLong())).thenReturn("Deleted.");

    mockMvc.perform(delete("/product/1")).andExpect(status().isOk());
  }

  @Test
  void testGetAll() throws Exception {
    ObjectMapper om = new ObjectMapper();

    when(privatServiceGet.getAll()).thenReturn(ProduceSupp.getProductAll());

    mockMvc
        .perform(get("/product"))
        .andExpect(status().isOk())
        .andExpect(content().json(om.writeValueAsString(ProduceSupp.getProductAll())));
  }

  @Test
  void testSaveNew() throws JsonProcessingException, Exception {
    ObjectMapper om = new ObjectMapper();

    mockMvc
        .perform(
            post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(ProduceSupp.getProductDTO())))
        .andExpect(status().isOk());
  }

  @Test
  void testSaveNewFailName() throws JsonProcessingException, Exception {
    ObjectMapper om = new ObjectMapper();
    ProductDTO dto = new ProductDTO(null, 0.1, List.of(1L));

    mockMvc
        .perform(
            post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(dto)))
        .andExpect(status().isBadRequest());
  }

  @Test
  void testSaveNewFailPrice() throws JsonProcessingException, Exception {
    ObjectMapper om = new ObjectMapper();
    ProductDTO dto = new ProductDTO("alo", null, List.of(1L));

    mockMvc
        .perform(
            post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(dto)))
        .andExpect(status().isBadRequest());
  }

  @Test
  void testUpdateById() throws JsonProcessingException, Exception {
    ObjectMapper om = new ObjectMapper();

    when(productService.updateById(anyLong(), any(ProductDTO.class))).thenReturn("Updated.");

    mockMvc
        .perform(
            put("/product/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(ProduceSupp.getProductDTO())))
        .andExpect(status().isOk());
  }
}
