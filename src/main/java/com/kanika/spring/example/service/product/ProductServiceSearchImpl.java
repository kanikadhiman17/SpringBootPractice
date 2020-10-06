package com.kanika.spring.example.service.product;

import com.kanika.spring.example.dto.ProductBrandPriceDTO;
import com.kanika.spring.example.dto.ResponseProductBrandPriceDTO;
import com.kanika.spring.example.entity.Product;
import com.kanika.spring.example.repository.ProductRepository;
import com.kanika.spring.example.util.exceptionHandling.ExceptionHandling;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceSearchImpl implements ProductServiceSearch {

    private final ProductRepository productRepository;

    //@Autowired
    public ProductServiceSearchImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // GET all products
    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // GET all products by Id
    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    // GET all products by IDs
    @Override
    public List<Product> getProductByIds(List<Integer> ids) {
        return productRepository.findAllById(ids);
    }

    // GET product based on name and quantity
    @Override
    public ResponseProductBrandPriceDTO getProductByNameAndBrand(String name, String brand, int pageNo, int size) {

        try {
            // Filter
            List<Product> matchedProducts = productRepository.findByNameAndBrand(name, brand,
                    PageRequest.of(pageNo, size, Sort.by(Sort.Direction.ASC, "price")))
                    .getContent();

            // Mapping
            ModelMapper modelMapper = new ModelMapper();
            List<ProductBrandPriceDTO> resultList = matchedProducts.stream()
                    .map(p -> modelMapper.map(p, ProductBrandPriceDTO.class))
                    .collect(Collectors.toList());

            return ExceptionHandling.successListOfSeries(resultList);
        }
        catch (Exception e){
            return ExceptionHandling.errorListOfSeries(e);
        }

    }


    // GET product from name using Stream
    @Override
    public ResponseProductBrandPriceDTO getProductByName(String name)
    {
        try {
            // Filter
            List<Product> matchedProducts = productRepository.findAll().parallelStream()
                    .filter(p -> p.getName().contains(name))
                    .sorted(Comparator.comparingDouble(Product::getPrice))
                    .collect(Collectors.toList());

            // Mapping
            ModelMapper modelMapper = new ModelMapper();
            List<ProductBrandPriceDTO> resultList = matchedProducts.stream()
                    .map(p -> modelMapper.map(p, ProductBrandPriceDTO.class))
                    .collect(Collectors.toList());

            return ExceptionHandling.successListOfSeries(resultList);
        }
        catch (Exception e){
            return ExceptionHandling.errorListOfSeries(e);
        }
    }

    // Get product from brand using Parallel Stream
    @Override
    public ResponseProductBrandPriceDTO getProductByBrand(String name) {
        try {
            // Filter
            List<Product> matchedProducts = productRepository.findAll();
            matchedProducts = matchedProducts.parallelStream()
                    .filter(p -> p.getBrand().getName().contains(name))
                    .sorted(Comparator.comparing(Product::getName))
                    .collect(Collectors.toList());

            // Mapping
            ModelMapper modelMapper = new ModelMapper();
            List<ProductBrandPriceDTO> resultList = matchedProducts.stream()
                    .map(p -> modelMapper.map(p,ProductBrandPriceDTO.class))
                    .collect(Collectors.toList());

            return ExceptionHandling.successListOfSeries(resultList);
        }
        catch (Exception e){
            return ExceptionHandling.errorListOfSeries(e);
        }

    }

    /*// Get product from name using JPA Query
    @Override
    public List<ProductBrandPriceDTO> getProductByNameUsingSQL(String name) {
        ModelMapper modelMapper = new ModelMapper();
        List<Product> matchedProducts = productRepository.getProductByName(name);
        return matchedProducts.stream().map(p -> modelMapper.map(p,ProductBrandPriceDTO.class)).collect(Collectors.toList());
    }*/

    /*// Get product from name using CompletableFuture
    @Override
    public List<ProductBrandPriceDTO> getProductByNameUsingCF(String name) {
        ModelMapper modelMapper = new ModelMapper();
        List<Product> allProducts = productRepository.findAll();
        allProducts = allProducts.stream()
                .filter(p -> CompletableFuture.supplyAsync(() -> p.getName().contains(name)).get()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList()));

        return allProducts.stream().map(p -> modelMapper.map(p,ProductBrandPriceDTO.class)).collect(Collectors.toList());
    }*/
}
