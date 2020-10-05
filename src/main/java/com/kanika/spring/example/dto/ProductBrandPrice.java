package com.kanika.spring.example.dto;

import com.kanika.spring.example.entity.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ProductBrandPrice {
    @Data // Lombok
    @AllArgsConstructor // Lombok - All arguments constructor
    @NoArgsConstructor // Lombok - No Argument Constructor
    public static class BrandProductPriceDTO {

        private String name;
        private double price;
        private Brand brand;
    }
}
