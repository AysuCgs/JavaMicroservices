package com.aysu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:9090/fallback
@RestController
@RequestMapping("/fallback")
public class FallBackController {

    @GetMapping("/auth")
    public ResponseEntity<String> fallbackAuth(){
        return ResponseEntity.ok("Auth Service: Şu anda geçici olarak hizmet verememekteyiz.");
    }

    @GetMapping("/product")
    public ResponseEntity<String> fallbackProduct(){
        return ResponseEntity.ok("Product Service: Şu anda geçici olarak hizmet verememekteyiz.");
    }

    @GetMapping("/sale")
    public ResponseEntity<String> fallbackSale(){
        return ResponseEntity.ok("Sale Service: Şu anda geçici olarak hizmet verememekteyiz.");
    }

    @GetMapping("/user")
    public ResponseEntity<String> fallbackUser(){
        return ResponseEntity.ok("User Service: Şu anda geçici olarak hizmet verememekteyiz.");
    }
}
