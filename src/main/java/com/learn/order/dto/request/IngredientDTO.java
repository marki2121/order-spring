package com.learn.order.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
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
    @jakarta.validation.constraints.NotNull(message = "Missing energy")
    @Min(value = 0L, message = "Energy can not be negative")
    private Integer energy;
    @jakarta.validation.constraints.NotNull(message = "Missing protein")
    @Min(value = 0L, message = "Protein can not be negative")
    private Double protein;
    @jakarta.validation.constraints.NotNull(message = "Missing fat")
    @Min(value = 0L, message = "Fat can not be negative")
    private Double fat;
    @jakarta.validation.constraints.NotNull(message = "Missing name")
    @Min(value = 0L, message = "Carbs can not be negative")
    private Double carbs;
    @jakarta.validation.constraints.NotNull(message = "Missing carbs")
    @Min(value = 0L, message = "Sodium can not be negative")
    private Double sodium;
}
