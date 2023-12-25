package com.dange.tanmay.service;

import com.dange.tanmay.entity.Product;
import com.dange.tanmay.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //Offset Pagniation
    public Page<Product> getAllProducts(Pageable request){
       return productRepository.findAll(request);
    }

    //Cursor Pagination
    public Page<Product> getProducts(Long afterId, Integer pageSize) {
        Pageable pageable = PageRequest.of(0, pageSize); // Since we're using cursor, page number is always 0
        if (afterId != null) {
            pageable = PageRequest.of(0, pageSize, Sort.by("productId").ascending());
        }
        return productRepository.findByProductIdGreaterThanOrderByProductId(afterId, pageable);
    }


    public Page<Product> getKeySetProducts(Long afterKey, Integer pageSize) {
        Pageable pageable = PageRequest.of(0, pageSize); // Since we're using keyset, page number is always 0
        if (afterKey != null) {
            pageable = PageRequest.of(0, pageSize, Sort.by("createdAt").ascending());
        }
        return productRepository.findByCreatedAtGreaterThanOrderByCreatedAt(afterKey, pageable);
    }
}
