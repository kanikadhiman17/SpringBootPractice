package com.kanika.spring.example.domain.service.product;

import com.kanika.spring.example.domain.dto.entity.ProductDTO;
import com.kanika.spring.example.domain.persistence.entity.Product;
import com.kanika.spring.example.domain.persistence.repository.ProductRepository;
import com.kanika.spring.example.mapper.ProductDTOtoProduct;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceUpdateImpl implements ProductServiceUpdate{

    private final ProductRepository productRepository;

    //@Autowired
    public ProductServiceUpdateImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // DELETE product from Id
    @Override
    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Product removed !! " + id;
    }

    // UPDATE product
    @Override
    public Product updateProduct(ProductDTO productDTO, int id) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        assert existingProduct != null;
        // TODO: Handle here
        return productRepository.save(ProductDTOtoProduct.updateProductFromProductDTO(existingProduct,productDTO));
    }
}
