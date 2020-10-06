package com.kanika.spring.example.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    int id;
    private String name;
    private int quantity;
    private double price;
    private int brandId;
}
