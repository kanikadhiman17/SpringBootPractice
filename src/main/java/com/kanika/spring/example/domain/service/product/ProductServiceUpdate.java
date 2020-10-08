package com.kanika.spring.example.domain.service.product;

import com.kanika.spring.example.domain.dto.entity.ProductDTO;
import com.kanika.spring.example.domain.persistence.entity.Product;

public interface ProductServiceUpdate {

    String deleteProduct(int id);
    Product updateProduct(ProductDTO productDTO, int id);
}
