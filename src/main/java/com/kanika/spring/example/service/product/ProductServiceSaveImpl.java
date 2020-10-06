package com.kanika.spring.example.service.product;

import com.kanika.spring.example.dto.entity.ProductDTO;
import com.kanika.spring.example.entity.Product;
import com.kanika.spring.example.repository.ProductRepository;
import com.kanika.spring.example.util.dtoToEntityMapper.ProductDTOtoProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceSaveImpl implements ProductServiceSave{

    private final ProductRepository productRepository;

    //@Autowired
    public ProductServiceSaveImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /*@Override
    public Product saveProduct (Product product) {
        return productRepository.save(product);
    }*/

    @Override
    public List<Product> saveProducts (List<ProductDTO> productDTOs) {

        List<Product> saveProducts = ProductDTOtoProduct.convertProductDTOtoProduct(productDTOs);
        return productRepository.saveAll(saveProducts);
    }

}
