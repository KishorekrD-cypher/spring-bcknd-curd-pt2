package com.example.productsapp.entity;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Set;
import java.time.LocalDateTime;

@Entity
@Table(name="ecommerce_products")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Class Product Attributes
    private Long id;
    @NotBlank
    private String productName;
    private String productDescription;
    @Min(value = 1)
    private double price;
    private boolean isEnabled;
    @Enumerated(EnumType.ORDINAL)
    private Category category;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    public ProductProperties getProductProperties() {
        return productProperties;
    }

    public void setProductProperties(ProductProperties productProperties) {
        this.productProperties = productProperties;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Embedded
    @Valid
    private ProductProperties productProperties;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "warranty_id")
    private Warranty warranty;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_shipper",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "shipper_id")
    )
    private Set<Shipper> shippers;

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Warranty getWarranty() {
        return warranty;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }


    public Set<Shipper> getShippers() {
        return shippers;
    }

    public void setShippers(Set<Shipper> shippers) {
        this.shippers = shippers;
    }

    //No argument constructor
    public Product() {
    }

    //All argument constructor
    public Product(String productName, String productDescription, double price, boolean isEnabled, Category category, LocalDateTime createdAt, ProductProperties productProperties, Warranty warranty, Set<Shipper> shippers) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.isEnabled = isEnabled;
        this.category = category;
        this.createdAt = createdAt;
        this.productProperties = productProperties;
        this.warranty = warranty;
        this.shippers = shippers;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", price=" + price +
                ", isEnabled=" + isEnabled +
                ", category=" + category +
                ", createdAt=" + createdAt +
                ", productProperties=" + productProperties +
                ", warranty=" + warranty +
                ", shippers=" + shippers +
                '}';
    }

}
