package com.pocketapi.expensetracker.service;

import com.pocketapi.expensetracker.model.Product;
import com.pocketapi.expensetracker.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public Product getProductById(long id) {
        Product product = productRepository.findById(id);
        return product;
    }

}
