package com.kanika.spring.example.domain.service.brand;

import com.kanika.spring.example.domain.persistence.entity.Brand;

import java.util.List;

public interface BrandServiceSearch {

    List<Brand> getBrands();
    List<Brand> getBrandByIds(List<Integer> ids);
    Brand getBrandByName(String name);

}
