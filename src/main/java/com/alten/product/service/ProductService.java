package com.alten.product.service;

import com.alten.product.entity.Product;
import com.alten.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepository productRepository;

    public List<Product> getProducts(){
        return this.productRepository.findAll();
    }

    public Product searchByName(String name){
        if(Strings.isNotEmpty(name)){
            return this.productRepository.findByName(name);
        }
        return null;
    }

    public Product readProduct(int id){
        Optional<Product> productInBdd = this.productRepository.findById(id);
        return productInBdd.orElse(null);
    }

    public void create(Product product) {
        this.productRepository.save(product);
    }

    public void update(int id, Product product) {

        Product productInBdd = this.readProduct(id);
        // set Element in BDD
        productInBdd.setName(product.getName());
        productInBdd.setDescription(product.getDescription());
        productInBdd.setPrice(product.getPrice());

    }

    public void delete(int id) {
        this.productRepository.deleteById(id);
    }
}
