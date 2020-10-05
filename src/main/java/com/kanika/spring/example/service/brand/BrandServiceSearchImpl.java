package com.kanika.spring.example.service.brand;

import com.kanika.spring.example.entity.Brand;
import com.kanika.spring.example.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceSearchImpl implements BrandServiceSearch {

    private final BrandRepository brandRepository;

    //@Autowired
    public BrandServiceSearchImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getBrandById(int id) {
        return brandRepository.findById(id).orElse(null);
    }

    @Override
    public List<Brand> getBrandByIds(List<Integer> ids) {
        return brandRepository.findAllById(ids);
    }

    @Override
    public List<Brand> getBrandByName(String name) {
        return brandRepository.findByName(name);
    }

}
