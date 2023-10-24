package com.learn.order.dto.request.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.learn.order.dto.request.ProductDTO;
import com.learn.order.entity.Ingredient;
import com.learn.order.entity.Product;
import com.learn.order.service.IngredientServiceGet;

@Service
public class ProductMapper implements Function<ProductDTO, Product> {

    private IngredientServiceGet ingredientService;

    public ProductMapper(IngredientServiceGet ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Override
    public Product apply(ProductDTO t) {
        List<Ingredient> ingredients = ingredientService.getFromList(t.getIngredients());

        return new Product(
            t.getName(),
            t.getPrice(),
            ingredients
        );
    }
    
}
