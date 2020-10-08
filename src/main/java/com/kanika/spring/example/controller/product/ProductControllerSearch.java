package com.kanika.spring.example.controller.product;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.kanika.spring.example.domain.dto.ProductBrandPriceDTO;
import com.kanika.spring.example.domain.dto.ProductFiltersDTO;
import com.kanika.spring.example.domain.dto.ResponseDTO;
import com.kanika.spring.example.domain.service.product.ProductServiceSearch;
import com.kanika.spring.example.exceptions.ExceptionHandling;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductControllerSearch {

    private final ProductServiceSearch productServiceSearch;

    //@Autowired
    public ProductControllerSearch(ProductServiceSearch productServiceSearch) {
        this.productServiceSearch = productServiceSearch;
    }

    @GetMapping("/all")
    ResponseDTO<ProductBrandPriceDTO> findAllProducts() {
        try {
            List<ProductBrandPriceDTO> list = productServiceSearch.getProducts();
            return ExceptionHandling.successListOfSeries(list);
        } catch (Exception e) {
            return ExceptionHandling.errorListOfSeries(e);
        }
    }

    @GetMapping //products?id=1,2,3 OR products?id=1&id=2
    ResponseDTO<ProductBrandPriceDTO> findProductByIds(@RequestParam(name = "id") List<Integer> ids) {
        try {
            List<ProductBrandPriceDTO> list = productServiceSearch.getProductByIds(ids);
            return ExceptionHandling.successListOfSeries(list);
        } catch (Exception e) {
            return ExceptionHandling.errorListOfSeries(e);
        }
    }


    /*@GetMapping("/product-name-from-stream/{product}")
    ResponseDTO<ProductBrandPriceDTO> findProductByNameUsingStream(@PathVariable String product) {
        try {
            List<ProductBrandPriceDTO> list = productServiceSearch.getProductByName(product);
            return ExceptionHandling.successListOfSeries(list);
        } catch (Exception e) {
            return ExceptionHandling.errorListOfSeries(e);
        }
    }

    @GetMapping("/product-name-from-sql/{product}")
    ResponseDTO<ProductBrandPriceDTO> findProductByNameUsingSQL(@PathVariable String product) {
        try {
            List<ProductBrandPriceDTO> list = productServiceSearch.getProductByNameUsingSQL(product);
            return ExceptionHandling.successListOfSeries(list);
        } catch (Exception e) {
            return ExceptionHandling.errorListOfSeries(e);
        }
    }

    @GetMapping("/product-name-from-cf/{product}")
    ResponseDTO<ProductBrandPriceDTO> findProductBySubstringUsingCF(@PathVariable String product) {
        try {
            List<ProductBrandPriceDTO> list = productServiceSearch.getProductByNameUsingCF(product);
            return ExceptionHandling.successListOfSeries(list);
        } catch (Exception e) {
            return ExceptionHandling.errorListOfSeries(e);
        }
    }*/

    @GetMapping("/brand-name/{brand}")
    ResponseDTO<ProductBrandPriceDTO> findProductByBrand(@PathVariable String brand) {
        try {
            List<ProductBrandPriceDTO> list = productServiceSearch.getProductByBrand(brand);
            return ExceptionHandling.successListOfSeries(list);
        } catch (Exception e) {
            return ExceptionHandling.errorListOfSeries(e);
        }
    }

    @GetMapping("/filter")// Query Parameters /product?name=something&brand=something
    ResponseDTO<ProductBrandPriceDTO> findProduct(@RequestParam Map<String, String> requestParams) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);

        final ProductFiltersDTO filtersDTO = mapper.convertValue(requestParams, ProductFiltersDTO.class);
        try {
            List<ProductBrandPriceDTO> list = productServiceSearch.dynamicProductQuery(filtersDTO);
            return ExceptionHandling.successListOfSeries(list);
        } catch (Exception e) {
            return ExceptionHandling.errorListOfSeries(e);
        }

    }
}
