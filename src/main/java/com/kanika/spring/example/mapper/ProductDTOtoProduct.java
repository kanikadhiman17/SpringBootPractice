package com.kanika.spring.example.mapper;

import com.kanika.spring.example.domain.dto.entity.ProductDTO;
import com.kanika.spring.example.domain.persistence.entity.Brand;
import com.kanika.spring.example.domain.persistence.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDTOtoProduct {

    public static Product productDTOtoProduct(ProductDTO productDTO)
    {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setBrand(new Brand(productDTO.getBrandId(),null));

        return product;
    }

    public static Product updateProductFromProductDTO(Product existingProduct, ProductDTO productDTO)
    {
        existingProduct.setName(productDTO.getName());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setQuantity(productDTO.getQuantity());
        existingProduct.setBrand(new Brand(productDTO.getBrandId(),null));

        return existingProduct;
    }

    public static List<Product> convertProductDTOtoProduct(List<ProductDTO> productDTOs)
    {
        return productDTOs.stream().map(ProductDTOtoProduct::productDTOtoProduct).collect(Collectors.toList());
    }
}
