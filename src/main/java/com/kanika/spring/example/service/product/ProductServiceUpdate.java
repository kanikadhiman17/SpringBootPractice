package com.kanika.spring.example.service.product;

import com.kanika.spring.example.dto.entity.ProductDTO;
import com.kanika.spring.example.entity.Product;

public interface ProductServiceUpdate {

    String deleteProduct(int id);
    Product updateProduct(ProductDTO productDTO, int id);
}
