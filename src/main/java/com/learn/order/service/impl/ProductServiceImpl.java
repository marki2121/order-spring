package com.learn.order.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.order.dto.request.ProductDTO;
import com.learn.order.entity.Ingredient;
import com.learn.order.entity.Product;
import com.learn.order.repository.ProductRepository;
import com.learn.order.service.IngredientServiceGet;
import com.learn.order.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final IngredientServiceGet ingredientService;

    public ProductServiceImpl(ProductRepository productRepository, IngredientServiceGet ingredientService) {
        this.productRepository = productRepository;
        this.ingredientService = ingredientService;
    }

    @Override
    public String saveNew(Product product) {
        productRepository.save(product);

        return "Saved.";
    }

    @Override
    public String deleteById(Long id) {
        productRepository.deleteById(id);

        return "Deleted.";
    }

    @Override
    public String updateById(Long id, ProductDTO data) {
        Boolean changed = false;
        Product productDb = productRepository.findById(id).orElseThrow(RuntimeException::new);
        List<Ingredient> ingredients = ingredientService.getFromList(data.getIngredients());

        if(productDb.getName() != data.getName() && !data.getName().isEmpty()) {
            productDb.setName(data.getName());
            changed = true;
        }
        if(productDb.getPrice() != data.getPrice() && data.getPrice() >= 0) {
            productDb.setPrice(data.getPrice());
            changed = true;
        }

        if(ingredients != productDb.getIngredients()) {
            productDb.setIngredients(ingredients);
            changed = true;
        }
        

        if(changed) {
            productRepository.save(productDb);
            return "Updated.";
        } else return "Nothing updated.";

        
    }
    
}
