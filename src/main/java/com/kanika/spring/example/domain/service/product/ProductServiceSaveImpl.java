package com.kanika.spring.example.domain.service.product;

import com.kanika.spring.example.domain.dto.entity.ProductDTO;
import com.kanika.spring.example.domain.persistence.entity.Product;
import com.kanika.spring.example.domain.persistence.repository.ProductRepository;
import com.kanika.spring.example.mapper.ProductDTOtoProduct;
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
    public Product saveProduct (ProductDTO productDTO) {
        Product product = new Product();
        return productRepository.save(ProductDTOtoProduct.updateProductFromProductDTO(product,productDTO));
    }*/

    @Override
    public List<Product> saveProducts (List<ProductDTO> productDTOs) {

        List<Product> saveProducts = ProductDTOtoProduct.convertProductDTOtoProduct(productDTOs);
        return productRepository.saveAll(saveProducts);
    }

}
