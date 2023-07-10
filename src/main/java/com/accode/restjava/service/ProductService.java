package com.accode.restjava.service;

import com.accode.restjava.model.Product;
import com.accode.restjava.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(long productId) {
        return productRepository.findById(productId).orElseThrow(()-> new IllegalArgumentException("Product not found"));
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(long productId, Product newProduct) {
        Product product = productRepository.findById(productId).orElseThrow(()-> new IllegalArgumentException("Product not found"));
        product.setProductName(newProduct.getProductName());
        product.setColor(newProduct.getColor());
        product.setPrice(newProduct.getPrice());
        productRepository.save(product);
        return product;
    }

    public Product deleteProduct(long productId) {
        Product product = productRepository.findById(productId).orElseThrow(()-> new IllegalArgumentException("Product not found"));
        productRepository.deleteById(productId);
        return product;
    }

    public List<Product> getProductsByName(String productName) {
        return productRepository.getProductsByName(productName);
    }
}
