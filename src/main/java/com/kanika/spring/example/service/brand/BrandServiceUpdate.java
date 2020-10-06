package com.kanika.spring.example.service.brand;

import com.kanika.spring.example.dto.entity.BrandDTO;
import com.kanika.spring.example.entity.Brand;

public interface BrandServiceUpdate {

    String deleteBrand(int id);
    Brand updateBrand(BrandDTO brandDTO, int id);

}
