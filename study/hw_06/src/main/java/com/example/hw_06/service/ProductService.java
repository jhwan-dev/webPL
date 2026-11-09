package com.example.hw_06.service;
import com.example.hw_06.domain.Product;
import com.example.hw_06.dto.ProductForm;
import com.example.hw_06.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public void save(ProductForm productForm){
        Product product = new Product(
                productForm.getTitle(),
                productForm.getPrice(),
                productForm.getQuantity(),
                productForm.getCategory(),
                productForm.getOnSale());
        productRepository.save(product);
    }
    //     자료형: List<Study>
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품을 찾을 수 없습니다."));
    }

    public void update(Long id, ProductForm productForm) {
        Product product = findById(id);
        product.update(
                productForm.getTitle(),
                productForm.getPrice(),
                productForm.getQuantity(),
                productForm.getCategory(),
                productForm.getOnSale());
        productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
