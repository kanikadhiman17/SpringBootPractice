package com.kanika.spring.example.controller.product;

import com.kanika.spring.example.dto.ResponseProductBrandPriceDTO;
import com.kanika.spring.example.entity.Product;
import com.kanika.spring.example.service.product.ProductServiceSearch;
import com.kanika.spring.example.util.ExceptionHandling;
import org.springframework.web.bind.annotation.*;

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
    List<Product> findAllProducts() {
        return productServiceSearch.getProducts();
    }

    @GetMapping("/{id}")
    Product findProductById(@PathVariable int id) {
        return productServiceSearch.getProductById(id);
    }

    @GetMapping //products?id=1,2,3 OR products?id=1&id=2
    List<Product> findProductByIds(@RequestParam(name="id") List<Integer> ids) {
        return productServiceSearch.getProductByIds(ids);
    }

    /*
    @GetMapping("/product-name/{name}")
    List<ProductBrandPriceDTO> findProductByNameUsingStream(@PathVariable String product){
        return productServiceSearch.getProductByName(product);
    }*/

    /*@GetMapping("/product-name/{name}")
    List<ProductBrandPriceDTO> findProductByNameUsingSQL(@PathVariable String product) {
        return productServiceSearch.getProductByNameUsingSQL(product);
    }*/

    /* @GetMapping("/product-name/{name}")
    //List<ProductBrandPriceDTO> findProductBySubstringUsingCF(@PathVariable String product) {
        return productServiceSearch.getProductByNameUsingCF(product);
    }*/

    /*@GetMapping("/brand-name/{name}")
    List<ProductBrandPriceDTO> findProductByBrand(@PathVariable String brand) {
        return productServiceSearch.getProductByBrand(brand);
    }*/

    @GetMapping("/filter") // Query Parameters /product?name=something&brand=something
    ResponseProductBrandPriceDTO findProductByNameOrBrand(@RequestParam(name = "product", required = false) String product,
                                                           @RequestParam(name = "brand", required = false) String brand,
                                                           @RequestParam(name= "pageNo", required = false) Integer pageNo,
                                                           @RequestParam(name="size", required = false) Integer size) {

        if(product != null && brand != null)
            return productServiceSearch.getProductByNameAndBrand(product, brand, pageNo, size);

        else if(product !=null)
            return productServiceSearch.getProductByName(product);

        else if(brand !=null)
            return productServiceSearch.getProductByBrand(brand);

        else
            return ExceptionHandling.noArgumentProvided();
    }
}
