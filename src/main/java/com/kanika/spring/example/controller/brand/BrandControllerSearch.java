package com.kanika.spring.example.controller.brand;

import com.kanika.spring.example.domain.persistence.entity.Brand;
import com.kanika.spring.example.domain.service.brand.BrandServiceSearch;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
public class BrandControllerSearch {

    private final BrandServiceSearch brandServiceSearch;

    //@Autowired
    public BrandControllerSearch(BrandServiceSearch brandServiceSearch) {
        this.brandServiceSearch = brandServiceSearch;
    }

    @GetMapping("/all")
    public List<Brand> findAllBrands() {
        return brandServiceSearch.getBrands();
    }

    @GetMapping
    List<Brand> findBrandByIds(@RequestParam(name = "id") List<Integer> ids) {
        return brandServiceSearch.getBrandByIds(ids);
    }

    @GetMapping("/{name}")
    Brand findBrandByName(@PathVariable String name) {
        return brandServiceSearch.getBrandByName(name);
    }
}
