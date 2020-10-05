package com.kanika.spring.example.service.product;

import com.kanika.spring.example.entity.Product;
import com.kanika.spring.example.repository.ProductRepository;
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
    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        assert existingProduct != null;
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setBrand(product.getBrand());
        return productRepository.save(existingProduct);
    }
}
