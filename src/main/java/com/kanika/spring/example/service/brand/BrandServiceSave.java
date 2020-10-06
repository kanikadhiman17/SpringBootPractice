package com.kanika.spring.example.service.brand;

import com.kanika.spring.example.dto.entity.BrandDTO;
import com.kanika.spring.example.entity.Brand;

import java.util.List;

public interface BrandServiceSave {

    //Brand saveBrand(Brand brand);
    List<Brand> saveBrands (List<BrandDTO> brandDTOs);

}
