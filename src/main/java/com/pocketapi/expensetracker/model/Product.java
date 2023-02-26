package com.pocketapi.expensetracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Date;

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

    @Size( min = 2,message = " Product Name Size should be greater than 2")
    private String productName;
   @Column(nullable = false)
   @Min(value = 0,message = "Price should be greater than 0")

   private BigDecimal productPrice;
    @Column(nullable = false)
    @Min(value = 0,message = "Quantity should be greater than 0 ")
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

    @Override
    public String toString() {
        return "[ Product ID"+this.productId +
                " Product Name "+this.productName +
                " Product Price "+this.productPrice +
                " Product Quantity "+this.productQuantity +
        "]";
    }
}
