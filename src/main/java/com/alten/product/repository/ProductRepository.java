package com.alten.product.repository;

import com.alten.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Integer> {

    Product findByName(String name);
}
