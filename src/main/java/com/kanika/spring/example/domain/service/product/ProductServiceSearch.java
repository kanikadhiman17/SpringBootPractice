package com.kanika.spring.example.domain.service.product;

import com.kanika.spring.example.domain.dto.ProductBrandPriceDTO;
import com.kanika.spring.example.domain.dto.ProductFiltersDTO;
import com.kanika.spring.example.domain.dto.ResponseDTO;
import com.kanika.spring.example.domain.persistence.entity.Product;

import java.util.List;

public interface ProductServiceSearch {

    List<ProductBrandPriceDTO> getProducts();
    List<ProductBrandPriceDTO> getProductByIds(List<Integer> ids);
    //List<ProductBrandPriceDTO> getProductByName(String name);
    List<ProductBrandPriceDTO> getProductByBrand(String name);
    //List<ProductBrandPriceDTO> getProductByNameUsingSQL(String name);
    //List<ProductBrandPriceDTO> getProductByNameUsingCF(String name);
    List<ProductBrandPriceDTO> dynamicProductQuery(ProductFiltersDTO filtersDTO) throws NoSuchFieldException;

}
