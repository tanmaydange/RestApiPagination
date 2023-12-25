package com.dange.tanmay.controller;

import com.dange.tanmay.entity.Product;
import com.dange.tanmay.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestControlller {

    public static final String DEFAULT_PAGE_SIZE = "5";
    public  static Integer MAX_PAGE_LIMIT = 10;

    @Autowired
    private ProductService service;


    @GetMapping(path = "/example/offset/products")
    public Page<Product> getProducts(@RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer limit, @RequestParam(defaultValue = "0") Integer page){

        Integer checkLimit =  (limit <= MAX_PAGE_LIMIT) ? limit : MAX_PAGE_LIMIT;
        Pageable pageable = PageRequest.of(page, checkLimit);
        return  service.getAllProducts(pageable);
    }


    @GetMapping(path = "/example/cursor/products")
    public Page<Product> getProductsByCursor(@RequestParam(required = false) Long afterId,
                                     @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize) {
        Integer checkPageSize =  (pageSize <= MAX_PAGE_LIMIT) ? pageSize : MAX_PAGE_LIMIT;
        return service.getProducts(afterId, checkPageSize);
    }


    @GetMapping(path = "/example/keyset/products")
    public Page<Product> getProducts(@RequestParam(required = false) Long afterKey,
                                     @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize) {
        Integer checkPageSize =  (pageSize <= MAX_PAGE_LIMIT) ? pageSize : MAX_PAGE_LIMIT;
        return service.getKeySetProducts(afterKey, checkPageSize);
    }
}
