package com.learnig.ai_spring_api.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/{orderId}")
    public Map<String, Object> getOrder(
            @PathVariable String orderId) {

        return Map.of(
                "orderId", orderId,
                "customerName", "Jay",
                "status", "DELIVERED",
                "amount", 4999
        );
    }
}