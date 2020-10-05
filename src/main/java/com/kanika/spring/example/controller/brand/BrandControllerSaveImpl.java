
package com.kanika.spring.example.controller.brand;

import com.kanika.spring.example.entity.Brand;
import com.kanika.spring.example.service.brand.BrandServiceSave;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandControllerSaveImpl implements BrandControllerSave{

    private final BrandServiceSave brandServiceSave;

    //@Autowired
    public BrandControllerSaveImpl(BrandServiceSave brandServiceSave) {
        this.brandServiceSave = brandServiceSave;
    }

    // POST API
    @Override
    public Brand addBrand(Brand brand) {
        return brandServiceSave.saveBrand(brand); // Shows saved brand
    }

    @Override
    public List<Brand> addBrands(List<Brand> brands) {
        return brandServiceSave.saveBrands(brands);
    }
}

