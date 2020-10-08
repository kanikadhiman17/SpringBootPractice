package com.kanika.spring.example.domain.service.product;

import com.kanika.spring.example.domain.dto.entity.ProductDTO;
import com.kanika.spring.example.domain.persistence.entity.Product;

import java.util.List;

public interface ProductServiceSave {

    //Product saveProduct (ProductDTO product);
    List<Product> saveProducts (List<ProductDTO> productDTOs);

}
