package com.example.productsapp.entity;


import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Embeddable
public class ProductProperties {
    private String productColor;
    @NotBlank
    private Integer productLength;
    @NotBlank
    private Integer productWidth;
    private Integer productHeight;

    public ProductProperties(String productColor, Integer productLength, Integer productWidth, Integer productHeight) {
        this.productColor = productColor;
        this.productLength = productLength;
        this.productWidth = productWidth;
        this.productHeight = productHeight;
    }

    public ProductProperties() {
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public Integer getProductLength() {
        return productLength;
    }

    public void setProductLength(Integer productLength) {
        this.productLength = productLength;
    }

    public Integer getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(Integer productWidth) {
        this.productWidth = productWidth;
    }

    public Integer getProductHeight() {
        return productHeight;
    }

    public void setProductHeight(Integer productHeight) {
        this.productHeight = productHeight;
    }
}