package com.learn.order.support.entity;

import java.util.List;

import com.learn.order.entity.Ingredient;

public class IngredientSupp {
    
    public static Ingredient getIngredient1() {
        return new Ingredient(
            1L,
            "Sol",
            0,
            0.0,
            0.0,
            0.0,
            0.0
        );
    }

    public static Ingredient getIngredient2() {
        return new Ingredient(
            1L,
            "Papar",
            0,
            0.0,
            0.0,
            0.0,
            0.0
        );
    }

    public static List<Ingredient> getAll() {
        return List.of(getIngredient1(), getIngredient2());
    }
}
