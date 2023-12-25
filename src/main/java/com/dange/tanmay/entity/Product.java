package com.dange.tanmay.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name= "product_name")
    private String productName;

    @Column(name="product_price")
    private Double productPrice;

    @Column(name="created_at")
    private Long createdAt; // Assuming a unique, ordered key for pagination
}
