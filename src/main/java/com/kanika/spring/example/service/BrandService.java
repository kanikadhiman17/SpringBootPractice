package com.kanika.spring.example.service;

import com.kanika.spring.example.entity.Brand;
import com.kanika.spring.example.entity.Product;
import com.kanika.spring.example.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public List<Brand> saveBrands (List<Brand> brands) {
        return brandRepository.saveAll(brands);
    }

    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }

    public Brand getBrandById(int id) {
        return brandRepository.findById(id).orElse(null);
    }

    public List<Brand> getBrandByIds(List<Integer> ids) {
        return brandRepository.findAllById(ids);
    }

    public String deleteBrand(int id) {
        brandRepository.deleteById(id);
        return "Brand removed !! " + id;
    }

    public Brand updateBrand(Brand brand) {
        Brand existingBrand = brandRepository.findById(brand.getId()).orElse(null);
        existingBrand.setName(brand.getName());
        return brandRepository.save(existingBrand);
    }

    public List<Brand> getBrandByName(String name) {
        return brandRepository.findByName(name);

    }
}
