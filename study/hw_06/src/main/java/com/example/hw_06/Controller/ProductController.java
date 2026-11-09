package com.example.hw_06.Controller;

import com.example.hw_06.domain.Product;
import com.example.hw_06.dto.ProductForm;
import com.example.hw_06.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public String showProductDetail(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product-detail";
    }


    @GetMapping("/{id}/edit")
    public String showProductEditForm(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        ProductForm productForm = new ProductForm();
        productForm.setTitle(product.getTitle());
        productForm.setPrice(product.getPrice());
        productForm.setQuantity(product.getQuantity());
        productForm.setCategory(product.getCategory());
        productForm.setOnSale(product.isOnSale());

        model.addAttribute("productId", id);
        model.addAttribute("productForm", productForm);
        return "product-edit-form";
    }

    @PostMapping("/{id}/edit")
    public String updateProduct(@PathVariable Long id,
                                @Valid @ModelAttribute("productForm") ProductForm productForm,
                                BindingResult bindingResult,
                                Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("productId", id);
            return "product-edit-form";
        }
        productService.update(id, productForm);
        return "redirect:/products/" + id;
    }


    @PostMapping("/{id}/delete")
    public String deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/products";
    }
}
