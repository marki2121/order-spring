package com.learn.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.order.dto.request.ProductDTO;
import com.learn.order.dto.request.mappers.ProductMapper;
import com.learn.order.entity.Product;
import com.learn.order.service.ProductService;
import com.learn.order.service.ProductServiceGet;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/product")
public class ProductController {
    
    private final ProductService productService;
    private final ProductServiceGet productServiceGet;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductServiceGet productServiceGet, ProductMapper productMapper) {
        this.productService = productService;
        this.productServiceGet = productServiceGet;
        this.productMapper = productMapper;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productServiceGet.getAll());
    }

    //Map dto and validate
    @PostMapping
    public ResponseEntity<String> saveNew(@Valid @RequestBody ProductDTO data) {
        Product product = productMapper.apply(data);

        return ResponseEntity.ok(productService.saveNew(product));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody ProductDTO data) {
        return ResponseEntity.ok(productService.updateById(id, data));
    }
}
