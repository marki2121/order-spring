/* (C) 2023 */
package com.learn.order.repository;

import com.learn.order.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {}
