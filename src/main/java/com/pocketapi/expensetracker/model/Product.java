package com.pocketapi.expensetracker.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tbl_products",
        schema = "ecommerce",
        uniqueConstraints = {
         @UniqueConstraint(
                 name = "product_name_unique",
                 columnNames = "productName"
         )
        }
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    @Column(nullable = false)
    private String productName;
   @Column(nullable = false)
    private BigDecimal productPrice;
    @Column(nullable = false)
    private Integer productQuantity;

    public Product() {
    }


    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
}
