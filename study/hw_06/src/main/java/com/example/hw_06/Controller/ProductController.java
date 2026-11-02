package com.example.hw_06.Controller;

import com.example.hw_06.dto.ProductForm;
import com.example.hw_06.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/new")
    public String newproduct(Model model){
        model.addAttribute("productForm", new ProductForm());
        return "product-form";
    }
    @PostMapping
    public String product(
            @Valid @ModelAttribute("productForm")
            ProductForm productForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "product-form";
        }
        productService.save(productForm);
        return "redirect:/products";
    }
    @GetMapping
    public String showProductList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }
}
