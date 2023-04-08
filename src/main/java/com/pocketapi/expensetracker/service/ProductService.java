package com.pocketapi.expensetracker.service;

import com.pocketapi.expensetracker.model.Product;
import com.pocketapi.expensetracker.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public void addProduct(Product product) {
        productRepository.save(product);

    }

    public Optional<Product> getProductById(long id) {
        return Optional.ofNullable(productRepository.findById(id));
    }

    public Product deleteProduct(long id) {
        Optional<Product> productOptional = Optional.ofNullable(productRepository.findById(id));
        if(productOptional.isPresent()) {
            productRepository.deleteById(id);
            return productOptional.get();
        }
        else {
            return null;
        }
    }

    public Product updateProduct(Product product,  long id) {
       Optional<Product> productOptional = Optional.ofNullable(productRepository.findById(id));

       if(productOptional.isPresent()) {
           Product productFromDB =  productOptional.get();
        productFromDB.setProductName(product.getProductName());
        productFromDB.setProductPrice(product.getProductPrice());
        productFromDB.setProductQuantity(product.getProductQuantity());
         return productRepository.save(productFromDB);
       }
       return null;
    }

}
