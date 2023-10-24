package com.learn.order.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.learn.order.repository.ProductRepository;
import com.learn.order.service.ProductServiceGet;
import com.learn.order.support.entity.ProduceSupp;

@SpringBootTest
public class ProductServiceGetImplTest {

    @MockBean
    private ProductRepository productRepository;
    @Autowired
    private ProductServiceGet productService;

    @Test
    void testGetAll() {
        when(productRepository.findAll()).thenReturn(ProduceSupp.getProductAll());

        assertEquals(ProduceSupp.getProductAll().get(0).getName(), productService.getAll().get(0).getName());
    }
}
