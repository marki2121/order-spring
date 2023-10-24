package com.learn.order.support.entity;

import java.util.List;

import com.learn.order.dto.request.ProductDTO;
import com.learn.order.entity.Ingredient;
import com.learn.order.entity.Product;

public class ProduceSupp {
    
    public static Product getProduct1() {
        List<Ingredient> list = IngredientSupp.getAll();

        return new Product(
            "proizvod",
            0.1,
            list
        );
    }

    public static Product getProduct2() {
        List<Ingredient> list = IngredientSupp.getAll();

        return new Product(
            "proizvod1",
            0.1,
            list
        );
    }

    public static ProductDTO getProductDTO() {
        return new ProductDTO(
            "DTO", 
            0.1, 
            List.of(1L, 2L));
    }

    public static List<Product> getProductAll() {
        return List.of(getProduct1(), getProduct2());
    }
}
