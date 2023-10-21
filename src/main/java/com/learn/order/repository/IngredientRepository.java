package com.learn.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.order.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long>{
    
}
