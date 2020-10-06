package com.kanika.spring.example.controller.brand;

import com.kanika.spring.example.entity.Brand;
import com.kanika.spring.example.service.brand.BrandServiceSearch;
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

    /*@GetMapping("/id/{id}")
    public Brand findBrandById(@PathVariable int id) {
        return brandServiceSearch.getBrandById(id);
    }*/

    @GetMapping
    List<Brand> findBrandByIds(@RequestParam(name = "id") List<Integer> ids) {
        return brandServiceSearch.getBrandByIds(ids);
    }

    @GetMapping("/{name}")
    List<Brand> findBrandByName(@PathVariable String name) {
        return brandServiceSearch.getBrandByName(name);
    }
}
