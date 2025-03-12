package com.example.railway.controller;



import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/workflow")
public class StepFunctionController {

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping
    public Map<String, String> orchestrateWorkflow(@RequestBody Map<String, Object> request) {
        // Step 1: Validate Order
        Map<String, Object> validateRequest = new HashMap<>();
        validateRequest.put("orderId", request.get("orderId"));
        String validateResponse = restTemplate.postForObject("https://your-railway-url/validate", validateRequest, String.class);

        // Step 2: Process Payment
        Map<String, Object> paymentRequest = new HashMap<>();
        paymentRequest.put("amount", request.get("amount"));
        String paymentResponse = restTemplate.postForObject("https://your-railway-url/process", paymentRequest, String.class);

        // Return results
        Map<String, String> response = new HashMap<>();
        response.put("validate", validateResponse);
        response.put("payment", paymentResponse);
        return response;
    }
}

