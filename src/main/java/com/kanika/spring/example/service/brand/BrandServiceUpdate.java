package com.kanika.spring.example.service.brand;

import com.kanika.spring.example.entity.Brand;

public interface BrandServiceUpdate {

    String deleteBrand(int id);
    Brand updateBrand(Brand brand);

}
