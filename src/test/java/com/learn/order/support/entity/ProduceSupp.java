/* (C) 2023 */
package com.learn.order.support.entity;

import com.learn.order.dto.request.ProductDTO;
import com.learn.order.entity.Ingredient;
import com.learn.order.entity.Product;
import java.util.List;

public class ProduceSupp {

  public static Product getProduct1() {
    List<Ingredient> list = IngredientSupp.getAll();

    return new Product("proizvod", 0.1, list);
  }

  public static Product getProduct2() {
    List<Ingredient> list = IngredientSupp.getAll();

    return new Product("proizvod1", 0.1, list);
  }

  public static ProductDTO getProductDTO() {
    return new ProductDTO("proizvod", 0.1, List.of(1L, 2L));
  }

  public static ProductDTO getProductDTOMirror() {
    return new ProductDTO("DTO", 0.1, List.of(1L, 1L));
  }

  public static List<Product> getProductAll() {
    return List.of(getProduct1(), getProduct2());
  }
}
