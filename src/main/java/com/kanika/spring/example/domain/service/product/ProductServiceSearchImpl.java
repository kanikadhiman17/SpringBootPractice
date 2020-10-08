package com.kanika.spring.example.domain.service.product;

import com.kanika.spring.example.domain.dto.ProductBrandPriceDTO;
import com.kanika.spring.example.domain.dto.ProductFiltersDTO;
import com.kanika.spring.example.domain.persistence.criteria.BaseSpecification;
import com.kanika.spring.example.domain.persistence.entity.Product;
import com.kanika.spring.example.domain.persistence.repository.ProductRepository;
import com.kanika.spring.example.domain.persistence.criteria.SearchCriteria;
import com.kanika.spring.example.domain.persistence.criteria.SearchOperation;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
//import java.util.concurrent.CompletableFuture;
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
    public List<ProductBrandPriceDTO> getProducts() {
        //Filter
        PageRequest paging = PageRequest.of(1,10, Sort.by(Sort.Direction.ASC, "price"));
        List<Product> matchedProducts = productRepository.findAll(paging).getContent();
        // Mapping
        ModelMapper modelMapper = new ModelMapper();
        return matchedProducts.stream().map(p -> modelMapper.map(p, ProductBrandPriceDTO.class))
                .collect(Collectors.toList());
    }

    // GET all products by IDs
    @Override
    public List<ProductBrandPriceDTO> getProductByIds(List<Integer> ids) {
        //Filter // Pagination not working here... because we're giving specific ids...
        List<Product> matchedProducts = productRepository.findAllById(ids);
        // Mapping
        ModelMapper modelMapper = new ModelMapper();
        return matchedProducts.stream().map(p -> modelMapper.map(p, ProductBrandPriceDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public List<ProductBrandPriceDTO> dynamicProductQuery(ProductFiltersDTO filtersDTO) throws NoSuchFieldException {

        PageRequest paging = PageRequest.of(1,10, Sort.by(Sort.Direction.ASC, "price"));

        BaseSpecification<Product> productCriteria = new BaseSpecification<>();

        productCriteria.add(new SearchCriteria(Product.class.getDeclaredField("name").getName(), filtersDTO.getProductName(), SearchOperation.MATCH));
        productCriteria.add(new SearchCriteria(Product.class.getDeclaredField("brand").getDeclaringClass().getDeclaredField("name").getName(), filtersDTO.getBrandName(), SearchOperation.MATCH));

        // Filter
        List<Product> matchedProducts = productRepository.findAll(productCriteria, paging).getContent();

        // Mapping
        ModelMapper modelMapper = new ModelMapper();
        return matchedProducts.stream().map(p -> modelMapper.map(p, ProductBrandPriceDTO.class))
                .collect(Collectors.toList());
    }

    /*// GET product from name using Stream
    @Override
    public List<ProductBrandPriceDTO> getProductByName(String name)
    {
        // Filter
        List<Product> matchedProducts = productRepository.findAll().parallelStream()
                .filter(p -> p.getName().contains(name))
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());

        // Mapping
        ModelMapper modelMapper = new ModelMapper();
        return matchedProducts.stream()
                .map(p -> modelMapper.map(p, ProductBrandPriceDTO.class))
                .collect(Collectors.toList());
    }*/

    // Get product from brand using Parallel Stream
    @Override
    public List<ProductBrandPriceDTO> getProductByBrand(String name) {

        // Filter
        List<Product> matchedProducts = productRepository.findAll();
        matchedProducts = matchedProducts.parallelStream()
                .filter(p -> p.getBrand().getName().contains(name))
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());

        // Mapping
        ModelMapper modelMapper = new ModelMapper();
        return matchedProducts.stream()
                .map(p -> modelMapper.map(p,ProductBrandPriceDTO.class))
                .collect(Collectors.toList());
    }

    /*// Get product from name using JPA Query
    @Override
    public List<ProductBrandPriceDTO> getProductByNameUsingSQL(String name) {
        // Filter
        PageRequest paging = PageRequest.of(1,10, Sort.by(Sort.Direction.ASC, "price"));
        List<Product> matchedProducts = productRepository.getProductByName(name, paging);

        // Mapping
        ModelMapper modelMapper = new ModelMapper();
        return matchedProducts.stream().map(p -> modelMapper.map(p,ProductBrandPriceDTO.class)).collect(Collectors.toList());
    }*/

    /*// Get product from name using CompletableFuture
    @Override
    public List<ProductBrandPriceDTO> getProductByNameUsingCF(String name) {
        // Filter
        List<Product> allProducts = productRepository.findAll();
        allProducts = allProducts.stream()
                .filter(p -> CompletableFuture.supplyAsync(() -> p.getName().contains(name)).get()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList()));

        // Mapping
        ModelMapper modelMapper = new ModelMapper();
        return allProducts.stream().map(p -> modelMapper.map(p,ProductBrandPriceDTO.class)).collect(Collectors.toList());
    }*/
}
