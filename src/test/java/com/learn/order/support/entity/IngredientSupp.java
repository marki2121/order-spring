package com.learn.order.support.entity;

import java.util.List;

import com.learn.order.dto.request.IngredientDTO;
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

    public static Ingredient getIngredientMapper() {
        return new Ingredient(
            1L,
            "Ime",
            1,
            1.0,
            1.0,
            1.0,
            1.0
        );
    }

    public static IngredientDTO getIngredientDTO() {
        return new IngredientDTO(
            "Ime",
            1,
            1.0,
            1.0,
            1.0,
            1.0
        );
    }

    public static List<Ingredient> getAll() {
        return List.of(getIngredient1(), getIngredient2());
    }
}
