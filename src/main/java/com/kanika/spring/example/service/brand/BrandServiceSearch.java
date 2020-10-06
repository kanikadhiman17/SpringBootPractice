package com.kanika.spring.example.service.brand;

import com.kanika.spring.example.entity.Brand;

import java.util.List;

public interface BrandServiceSearch {

    List<Brand> getBrands();
    //Brand getBrandById(int id);
    List<Brand> getBrandByIds(List<Integer> ids);
    List<Brand> getBrandByName(String name);

}
