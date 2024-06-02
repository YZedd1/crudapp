package com.example.testapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Создать продукт
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Удалить продукт по ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Редактировать продукт
    public Product updateProduct(Long id, Product productDetails) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(productDetails.getName());
            existingProduct.setArticle(productDetails.getArticle());
            existingProduct.setDescription(productDetails.getDescription());
            existingProduct.setCategory(productDetails.getCategory());
            existingProduct.setPrice(productDetails.getPrice());
            existingProduct.setQuantity(productDetails.getQuantity());
            existingProduct.setLastQuantityUpdate(productDetails.getLastQuantityUpdate());
            return productRepository.save(existingProduct);
        } else {
            throw new RuntimeException("Product not found with id: " + id);
        }
    }

    // Получить продукт по ID
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    // Получить список всех продуктов
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
}

