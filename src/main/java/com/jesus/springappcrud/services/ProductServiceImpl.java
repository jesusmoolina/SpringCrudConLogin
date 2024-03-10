package com.jesus.springappcrud.services;

import com.jesus.springappcrud.entities.Product;
import com.jesus.springappcrud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    @Transactional
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> update(Product product, Long id) {

        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            Product productDB = productOptional.orElseThrow();
            productDB.setSku(product.getSku());
            productDB.setName(product.getName());
            productDB.setPrice(product.getPrice());
            productDB.setDescription(product.getDescription());

            return Optional.of(productRepository.save(productDB));
        }

        return productOptional;
    }

    @Transactional
    @Override
    public Optional<Product> delete(Long id) {

        Optional<Product> productDB = productRepository.findById(id);
        productDB.ifPresent(product -> productRepository.delete(product));

        return productDB;

    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsBySku(String sku) {
        return productRepository.existsBySku(sku);
    }
}
