package com.pocketapi.expensetracker.repository;

import com.pocketapi.expensetracker.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
