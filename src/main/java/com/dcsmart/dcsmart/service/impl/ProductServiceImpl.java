package com.dcsmart.dcsmart.service.impl;

import com.dcsmart.dcsmart.controller.dto.request.ProductRequest;
import com.dcsmart.dcsmart.controller.dto.response.ProductResponse;
import com.dcsmart.dcsmart.exception.CategoryNotFoundException;
import com.dcsmart.dcsmart.exception.ProductNotFoundException;
import com.dcsmart.dcsmart.model.Category;
import com.dcsmart.dcsmart.model.Product;
import com.dcsmart.dcsmart.repository.CategoryRepository;
import com.dcsmart.dcsmart.repository.ProductRepository;
import com.dcsmart.dcsmart.service.ProductService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(
            ProductRepository productRepository,
            CategoryRepository categoryRepository
    ) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(ProductRequest productRequest) {

        Category categoryRegistered = this.categoryRepository.findById(productRequest.getCategory_id())
                .orElseThrow(() -> new CategoryNotFoundException(
                        String.format("Categoria com id %d não foi encontrada",productRequest.getCategory_id())
                ));


        Product product = new Product();
        product.setProduct_name(productRequest.getProduct_name());
        product.setProduct_description(productRequest.getProduct_description());
        product.setBarcode(productRequest.getBarcode());
        product.setCategory(categoryRegistered);
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());
        product.setDiscount(productRequest.getDiscount());
        product.setIsActive(true);
        product.setCreateAt(LocalDateTime.now(ZoneOffset.UTC));
        product.setUpdateAt(LocalDateTime.now(ZoneOffset.UTC));

        this.productRepository.save(product);
    }

    @Override
    public List<ProductResponse> findAll() {
        return this.productRepository.findAll()
                .stream()
                .map(ProductResponse::converter)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse findById(Long id) {

        Product product = this.productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(
                        String.format("O Produto com id: %d não foi encontrado",id)
                ));

        return ProductResponse.converter(product);
    }

    @Override
    public ProductResponse findByName(String name) {

        Product product = this.productRepository.findByName(name)
                .orElseThrow(() -> new ProductNotFoundException(
                        String.format("O produto %s não foi encontrado",name)
                ));

        return ProductResponse.converter(product);
    }

    @Override
    public ProductResponse update(Long id, ProductRequest productRequest) {

        Product product = this.productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(
                        String.format("O Produto com id: %d não foi encontrado",id)
                ));

        Category CategoryRegistered = this.categoryRepository.findById(productRequest.getCategory_id())
                .orElseThrow(() -> new CategoryNotFoundException(
                        String.format("Categoria com id %d não foi encontrada",productRequest.getCategory_id())
                ));

        product.setProduct_name(productRequest.getProduct_name());
        product.setProduct_description(productRequest.getProduct_description());
        product.setBarcode(productRequest.getBarcode());
        product.setCategory(CategoryRegistered);
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());
        product.setDiscount(productRequest.getDiscount());
        product.setUpdateAt(LocalDateTime.now(ZoneOffset.UTC));

        this.productRepository.save(product);

        return this.findById(id);
    }

    @Override
    public void delete(Long id) {

        Product product = this.productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(
                        String.format("O Produto com id: %d não foi encontrado",id)
                ));

        product.setIsActive(false);
        product.setUpdateAt(LocalDateTime.now(ZoneOffset.UTC));

        this.productRepository.save(product);

    }
}
