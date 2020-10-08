package com.kanika.spring.example.domain.service.brand;

import com.kanika.spring.example.domain.persistence.entity.Brand;
import com.kanika.spring.example.domain.persistence.entity.BrandDTO;

public interface BrandServiceUpdate {

    String deleteBrand(int id);
    Brand updateBrand(BrandDTO brandDTO, int id);

}
