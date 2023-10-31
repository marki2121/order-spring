/* (C) 2023 */
package com.learn.order.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.learn.order.repository.ProductRepository;
import com.learn.order.service.ProductServiceGet;
import com.learn.order.support.entity.ProduceSupp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ProductServiceGetImplTest {

  @MockBean private ProductRepository productRepository;
  @Autowired private ProductServiceGet productService;

  @Test
  void testGetAll() {
    when(productRepository.findAll()).thenReturn(ProduceSupp.getProductAll());

    assertEquals(
        ProduceSupp.getProductAll().get(0).getName(), productService.getAll().get(0).getName());
  }
}
