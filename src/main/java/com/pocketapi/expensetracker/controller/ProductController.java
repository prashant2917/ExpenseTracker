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
             Message message = new Message();
             message.setMessage("No products found");
            return new ResponseEntity(message, HttpStatus.OK);
        }
        return new ResponseEntity(products, HttpStatus.OK);
    }

    @PostMapping(value = "/add-product")
    public ResponseEntity addProduct(@Valid @RequestBody Product product) {
        productService.addProduct(product);
        logger.info("Add product");
        Message message = new Message();
        message.setMessage("Product " + product.getProductName() + "  Added Successfully");
        message.setProduct(product);
        return new ResponseEntity(message, HttpStatus.CREATED);
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

    @PutMapping(value = "/update-product/{id}")
    public ResponseEntity  updateProduct(@Valid @RequestBody Product product,@PathVariable long id) {
      Product productFromDB = productService.updateProduct(product,id);
      logger.info("product from Db "+productFromDB);
        Message message = new Message();
      if(productFromDB==null) {
          message.setMessage("Product Not found");
          message.setProduct(product);
          return new ResponseEntity(message,HttpStatus.NOT_FOUND);
      }
      else {
          message.setMessage("Product Updated Successfully");
          message.setProduct(productFromDB);

      }
        return new ResponseEntity(message,HttpStatus.OK);
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        Message message = new Message();
        message.setMessage("Product Deleted Successfully");
        return new ResponseEntity(message,HttpStatus.OK);
    }

}
