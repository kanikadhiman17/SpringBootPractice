package com.kanika.spring.example.domain.service.brand;

import com.kanika.spring.example.domain.persistence.entity.Brand;
import com.kanika.spring.example.domain.persistence.entity.BrandDTO;
import com.kanika.spring.example.domain.persistence.repository.BrandRepository;
import com.kanika.spring.example.mapper.BrandDTOtoBrand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceSaveImpl implements BrandServiceSave {

    private final BrandRepository brandRepository;

    //@Autowired
    public BrandServiceSaveImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand saveBrand(BrandDTO brandDTO) {
        Brand brand = new Brand();
        return brandRepository.save(BrandDTOtoBrand.updateBrandFromBrandDTO(brand, brandDTO));
    }

    @Override
    public List<Brand> saveBrands (List<BrandDTO> brandDTOs) {

        // TODO: Handle here.. Don't let spring handle it
        List<Brand> saveBrands = BrandDTOtoBrand.convertBrandDTOtoBrand(brandDTOs);
        return brandRepository.saveAll(saveBrands);
    }
}
