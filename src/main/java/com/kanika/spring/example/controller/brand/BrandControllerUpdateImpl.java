package com.kanika.spring.example.controller.brand;

import com.kanika.spring.example.entity.Brand;
import com.kanika.spring.example.service.brand.BrandServiceUpdate;
import org.springframework.web.bind.annotation.*;

@RestController
public abstract class BrandControllerUpdateImpl implements BrandControllerUpdate{

    private final BrandServiceUpdate brandServiceUpdate;

    //@Autowired
    public BrandControllerUpdateImpl(BrandServiceUpdate brandServiceUpdate) {
        this.brandServiceUpdate = brandServiceUpdate;
    }

    // PUT API
    @Override
    public Brand updateBrand(Brand brand) {
        return brandServiceUpdate.updateBrand(brand);
    }

    // DELETE API
    @Override
    public String deleteBrand(int id) {
        return brandServiceUpdate.deleteBrand(id);
    }
}
