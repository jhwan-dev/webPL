package com.example.hw_06.service;
import com.example.hw_06.domain.Product;
import com.example.hw_06.dto.ProductForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();
    private Long sequence = 1L;
    public void save(ProductForm productForm){
        Product product = new Product(sequence++,
                productForm.getTitle(),
                productForm.getPrice(),
                productForm.getQuantity(),
                productForm.getCategory(),
                productForm.getOnSale());
        products.add(product);
    }
    //     자료형: List<Study>
    public List<Product> findAll() {
        return products;
    }

}
