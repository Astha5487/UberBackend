package com.codingshuttle.project.uber.uberApp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/secure-route")
    public ResponseEntity<String> secureRoute() {
        return ResponseEntity.ok("✅ Access granted to secure route!");
    }

    @GetMapping("/public-route")
    public ResponseEntity<String> publicRoute() {
        return ResponseEntity.ok("🌐 This is a public route, no auth needed.");
    }
}
