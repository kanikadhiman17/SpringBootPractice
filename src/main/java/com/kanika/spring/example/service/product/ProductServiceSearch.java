package com.kanika.spring.example.service.product;

import com.kanika.spring.example.dto.ProductBrandPriceDTO;
import com.kanika.spring.example.dto.ResponseProductBrandPriceDTO;
import com.kanika.spring.example.entity.Product;

import java.util.List;

public interface ProductServiceSearch {

    List<Product> getProducts();
    Product getProductById(int id);
    List<Product> getProductByIds(List<Integer> ids);
    ResponseProductBrandPriceDTO getProductByNameAndBrand(String name, String brand, int pageNo, int size);
    ResponseProductBrandPriceDTO getProductByName(String name);
    ResponseProductBrandPriceDTO getProductByBrand(String name);
    //List<ProductBrandPriceDTO> getProductByNameUsingSQL(String name);
    //List<ProductBrandPriceDTO> getProductByNameUsingCF(String name);
}
