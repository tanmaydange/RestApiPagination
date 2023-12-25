package com.dange.tanmay.repository;

import com.dange.tanmay.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByProductPrice(double productPrice, Pageable pageable);

    Page<Product> findByProductIdGreaterThanOrderByProductId(Long productId, Pageable pageable);

    Page<Product> findByCreatedAtGreaterThanOrderByCreatedAt(Long createdAt, Pageable pageable);
}
