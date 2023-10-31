/* (C) 2023 */
package com.learn.order.service;

import com.learn.order.dto.request.ProductDTO;
import com.learn.order.entity.Product;

public interface ProductService {

  String saveNew(Product product);

  String deleteById(Long id);

  String updateById(Long id, ProductDTO data);
}
