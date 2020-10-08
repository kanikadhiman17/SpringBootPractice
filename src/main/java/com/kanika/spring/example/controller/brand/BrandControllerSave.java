package com.kanika.spring.example.controller.brand;

import com.kanika.spring.example.domain.persistence.entity.Brand;
import com.kanika.spring.example.domain.persistence.entity.BrandDTO;
import com.kanika.spring.example.domain.service.brand.BrandServiceSave;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
public class BrandControllerSave{

    private final BrandServiceSave brandServiceSave;

    //@Autowired
    public BrandControllerSave(BrandServiceSave brandServiceSave) {
        this.brandServiceSave = brandServiceSave;
    }


    /*@PostMapping("")
    public Brand addBrand(@RequestBody BrandDTO brand) {
        return brandServiceSave.saveBrand(brand); // Shows saved brand
    }*/

    @PostMapping
    public List<Brand> addBrands(@RequestBody List<BrandDTO> brandDTOs) {
        return brandServiceSave.saveBrands(brandDTOs);
    }
}

