package com.kanika.spring.example.service.brand;

import com.kanika.spring.example.entity.Brand;
import com.kanika.spring.example.repository.BrandRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceUpdateImpl implements BrandServiceUpdate  {

    private final BrandRepository brandRepository;

    //@Autowired
    public BrandServiceUpdateImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public String deleteBrand(int id) {
        brandRepository.deleteById(id);
        return "Brand removed !! " + id;
    }

    @Override
    public Brand updateBrand(Brand brand) {
        Brand existingBrand = brandRepository.findById(brand.getId()).orElse(null);
        assert existingBrand != null;
        existingBrand.setName(brand.getName());
        return brandRepository.save(existingBrand);
    }
}
