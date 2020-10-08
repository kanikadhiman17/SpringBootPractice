package com.kanika.spring.example.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductFiltersDTO {
    String brandName;
    String productName;
}
