package com.pocketapi.expensetracker.controller;

import com.pocketapi.expensetracker.model.Message;
import com.pocketapi.expensetracker.model.Product;
import com.pocketapi.expensetracker.model.ProductException;
import com.pocketapi.expensetracker.service.ProductService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/product-api")
public class ProductController {
    @Autowired
    private ProductService productService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/products")
    public ResponseEntity getAllProducts() {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {

            return new ResponseEntity(new Message("No products found"), HttpStatus.OK);
        }
        return new ResponseEntity(products, HttpStatus.OK);
    }

    @PostMapping(value = "/add-product")
    public ResponseEntity addProduct(@Valid @RequestBody Product product) {
        productService.addProduct(product);
        logger.info("Add product");
        return new ResponseEntity(new Message("Product " + product.getProductName() + "  Added Successfully"), HttpStatus.CREATED);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getProductById(@PathVariable long id) {

       Optional <Product> product = productService.getProductById(id);
        System.out.println("Product "+product);
        if(product.isEmpty()){
            throw new ProductException("Product not found");
        }
        return new ResponseEntity(product, HttpStatus.OK);

    }
    @DeleteMapping(value = "{id}")
    public void deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
    }

}
