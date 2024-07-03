package com.alten.product.controller;

import com.alten.product.entity.Product;
import com.alten.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping
public class ProductController {
    private ProductService productService;

    @GetMapping(value = "products")
    public List<Product> getAllProduct(){
        return this.productService.getProducts();
    }

    @GetMapping(value = "products")
    public Product search(@RequestParam(required = true)  String name){
        return this.productService.searchByName(name);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "/admin/products")
    public void createProduct(@RequestBody Product product){
        this.productService.create(product);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PutMapping(path = {"id"}, value = "/admin/products")
    public void updateProduct(@PathVariable int id,@RequestBody Product product){
        this.productService.update(id, product);
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path = {"id"}, value = "/admin/products")
    public void deleteProduct(@PathVariable int id){
        this.productService.delete(id);
    }
}
