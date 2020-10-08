package com.kanika.spring.example.domain.service.brand;

import com.kanika.spring.example.domain.persistence.entity.Brand;
import com.kanika.spring.example.domain.persistence.entity.BrandDTO;
import com.kanika.spring.example.domain.persistence.repository.BrandRepository;
import com.kanika.spring.example.mapper.BrandDTOtoBrand;
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
    public Brand updateBrand(BrandDTO brandDTO, int id) {
        Brand existingBrand = brandRepository.findById(id).orElse(null);
        assert existingBrand != null;
        // TODO: Handle Here
        return brandRepository.save(BrandDTOtoBrand.updateBrandFromBrandDTO(existingBrand,brandDTO));
    }
}
