package com.kanika.spring.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok
@AllArgsConstructor // Lombok - All arguments constructor
@NoArgsConstructor // Lombok - No Argument Constructor
public class ProductBrandPriceDTO {
    private String brandName;
    private String productName;
    private double price;
}
