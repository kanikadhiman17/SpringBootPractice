package com.kanika.spring.example.controller.brand;

import com.kanika.spring.example.entity.Brand;
import com.kanika.spring.example.service.brand.BrandServiceSearch;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public abstract class BrandControllerSearchImpl implements BrandControllerSearch{

    private final BrandServiceSearch brandServiceSearch;

    //@Autowired
    public BrandControllerSearchImpl(BrandServiceSearch brandServiceSearch) {
        this.brandServiceSearch = brandServiceSearch;
    }

    // GET API
    @Override
    public List<Brand> findAllBrands() {
        return brandServiceSearch.getBrands();
    }

    @Override
    public Brand findBrandById(int id) {
        return brandServiceSearch.getBrandById(id);
    }

    @Override
    public List<Brand> findBrandByIds(List<Integer> ids) {
        return brandServiceSearch.getBrandByIds(ids);
    }

    @Override
    public List<Brand> findBrandByName(String name) {
        return brandServiceSearch.getBrandByName(name);
    }
}
