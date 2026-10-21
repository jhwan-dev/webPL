package com.example.hw_06.dto;

import jakarta.validation.constraints.*;

public class ProductForm {
    @NotBlank(message = "상품명을 입력하세요")
    @Size(max=30, message = "상품명은 30자 이내여야 합니다")
    private String title;
    @NotNull(message = "가격을 입력하세요")
    @Min(value = 0, message = "가격은 0원 이상이어야 합니다")
    private Integer price;
    @NotNull(message = "수량을 입력하세요")
    @Min(value = 1, message = "수량은 1개 이상이어야 합니다")
    @Max(value = 5000, message = "수량은 5000개를 넘을 수 없습니다")
    private Integer quantity;
    @NotBlank(message = "카테고리를 입력하세요")
    private String category;
    @NotNull(message = "판매 여부를 선택하세요")
    private Boolean onSale;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }
}
// title, price, quantity, category, onSale