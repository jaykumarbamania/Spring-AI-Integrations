package com.learnig.ai_spring_api.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{productId}")
    public Map<String, Object> getProduct(
            @PathVariable String productId) {

        return Map.of(
                "productId", productId,
                "name", "iPhone 16",
                "price", 85000,
                "stock", 25
        );
    }
}