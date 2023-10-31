/* (C) 2023 */
package com.learn.order.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.learn.order.dto.request.ProductDTO;
import com.learn.order.entity.Product;
import com.learn.order.errors.ErrorResponse;
import com.learn.order.repository.ProductRepository;
import com.learn.order.service.IngredientServiceGet;
import com.learn.order.service.ProductService;
import com.learn.order.support.entity.IngredientSupp;
import com.learn.order.support.entity.ProduceSupp;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ProductServiceImplTest {

  @MockBean private ProductRepository productRepository;
  @MockBean private IngredientServiceGet ingredientService;
  @Autowired private ProductService productService;

  @Test
  void testDeleteById() {
    doNothing().when(productRepository).deleteById(anyLong());

    assertEquals("Deleted.", productService.deleteById(1L));
  }

  @Test
  void testSaveNew() {
    when(productRepository.save(any(Product.class))).thenReturn(ProduceSupp.getProduct1());

    assertEquals("Saved.", productService.saveNew(ProduceSupp.getProduct1()));
  }

  @Test
  void testUpdateById() {
    ProductDTO dto = ProduceSupp.getProductDTO();

    when(productRepository.save(any(Product.class))).thenReturn(ProduceSupp.getProduct1());
    when(productRepository.findById(anyLong())).thenReturn(Optional.of(ProduceSupp.getProduct2()));
    when(ingredientService.getFromList(anyList())).thenReturn(IngredientSupp.getAll());

    assertEquals("Updated.", productService.updateById(1L, dto));
  }

  @Test
  void testUpdateByIdAndThrow() {
    ProductDTO dto = ProduceSupp.getProductDTO();

    when(productRepository.save(any(Product.class))).thenReturn(ProduceSupp.getProduct1());
    when(productRepository.findById(anyLong())).thenThrow(new ErrorResponse());
    when(ingredientService.getFromList(anyList())).thenReturn(IngredientSupp.getAll());

    assertThrows(ErrorResponse.class, () -> productService.updateById(1L, dto));
  }
}
