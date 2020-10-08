package com.kanika.spring.example.mapper;

import com.kanika.spring.example.domain.persistence.entity.Brand;
import com.kanika.spring.example.domain.persistence.entity.BrandDTO;

import java.util.List;
import java.util.stream.Collectors;

public class BrandDTOtoBrand {

    public static Brand brandDTOtoBrand(BrandDTO brandDTO)
    {
        Brand brand = new Brand();
        brand.setName(brandDTO.getName());
        return brand;
    }

    public static Brand updateBrandFromBrandDTO(Brand existingBrand, BrandDTO brandDTO)
    {
        existingBrand.setName(brandDTO.getName());
        return existingBrand;
    }

    public static List<Brand> convertBrandDTOtoBrand(List<BrandDTO> brandDTOs)
    {
        return brandDTOs.stream().map(BrandDTOtoBrand::brandDTOtoBrand).collect(Collectors.toList());
    }
}
