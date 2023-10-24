package com.learn.order.dto.request;

import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {
    @NotEmpty(message = "Missing name")
    private String name;
    @jakarta.validation.constraints.NotNull(message = "Missing price")
    @Min(value = 0L, message = "Price can not be negative")
    private Double price;
    private List<Long> ingredients;
}
