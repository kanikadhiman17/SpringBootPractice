package com.kanika.spring.example.service.brand;

import com.kanika.spring.example.dto.entity.BrandDTO;
import com.kanika.spring.example.entity.Brand;
import com.kanika.spring.example.repository.BrandRepository;
import com.kanika.spring.example.util.dtoToEntityMapper.BrandDTOtoBrand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceSaveImpl implements BrandServiceSave {

    private final BrandRepository brandRepository;

    //@Autowired
    public BrandServiceSaveImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    /*@Override
    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }*/

    @Override
    public List<Brand> saveBrands (List<BrandDTO> brandDTOs) {

        // TODO: Handle here.. Don't let spring handle it
        List<Brand> saveBrands = BrandDTOtoBrand.convertBrandDTOtoBrand(brandDTOs);


        return brandRepository.saveAll(saveBrands);
    }
}
