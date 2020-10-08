package com.kanika.spring.example.domain.service.brand;

import com.kanika.spring.example.domain.persistence.entity.Brand;
import com.kanika.spring.example.domain.persistence.entity.BrandDTO;

import java.util.List;

public interface BrandServiceSave {

    Brand saveBrand(BrandDTO brand);
    List<Brand> saveBrands (List<BrandDTO> brandDTOs);

}
