package com.example.railway.controller;



import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/process")
public class ProcessPaymentController {

    @PostMapping
    public String processPayment(@RequestBody Map<String, Object> request) {
        double amount = (double) request.get("amount");
        return "Payment of $" + amount + " processed.";
    }
}
