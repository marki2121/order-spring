package com.learn.order.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IngredientDTO {
    @NotEmpty(message = "Missing name")
    private String name;
    @NotEmpty(message = "Missing energy")
    @Positive(message = "Energy can not be negative")
    private Integer energy;
    @NotEmpty(message = "Missing protein")
    @Positive(message = "Protein can not be negative")
    private Double protein;
    @NotEmpty(message = "Missing fat")
    @Positive(message = "Fat can not be negative")
    private Double fat;
    @NotEmpty(message = "Missing name")
    @Positive(message = "Carbs can not be negative")
    private Double carbs;
    @NotEmpty(message = "Missing carbs")
    @Positive(message = "Sodium can not be negative")
    private Double sodium;
}
