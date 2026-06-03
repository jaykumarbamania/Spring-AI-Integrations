package com.learnig.ai_spring_api.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping("/{customerId}")
    public Map<String, Object> getCustomer(
            @PathVariable String customerId) {

        return Map.of(
                "customerId", customerId,
                "name", "Jay Bamania",
                "email", "jay@test.com",
                "city", "Pune"
        );
    }
}
