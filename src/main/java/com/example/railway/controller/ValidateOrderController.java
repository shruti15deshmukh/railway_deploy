package com.example.railway.controller;



import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/validate")
public class ValidateOrderController {

    @PostMapping
    public String validateOrder(@RequestBody Map<String, Object> request) {
        String orderId = (String) request.get("orderId");
        return "Order " + orderId + " validated.";
    }
}
