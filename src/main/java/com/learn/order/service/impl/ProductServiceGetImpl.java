package com.learn.order.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.order.entity.Product;
import com.learn.order.repository.ProductRepository;
import com.learn.order.service.ProductServiceGet;

@Service
public class ProductServiceGetImpl implements ProductServiceGet{

    private ProductRepository productRepository;

    public ProductServiceGetImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
    
}
