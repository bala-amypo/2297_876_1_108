package com.example.demo.controller;

import com.example.demo.model.PriceAdjustmentLog;
import com.example.demo.service.PriceAdjustmentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/price-adjustments")
public class PriceAdjustmentLogController {

    @Autowired
    private PriceAdjustmentLogService logService;

    // Log a new adjustment
    @PostMapping("/log")
    public ResponseEntity<Void> logAdjustment(@RequestBody PriceAdjustmentLog log) {
        logService.logAdjustment(log);  // Service returns void
        return ResponseEntity.ok().build();  // Return 200 OK
    }

    // Get adjustments for a specific event
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<PriceAdjustmentLog>> getAdjustmentsByEvent(@PathVariable Long eventId) {
        List<PriceAdjustmentLog> logs = logService.getAdjustmentsByEvent(eventId);
        return ResponseEntity.ok(logs);
    }

    // Get all adjustments
    @GetMapping("/all")
    public ResponseEntity<List<PriceAdjustmentLog>> getAllAdjustments() {
        List<PriceAdjustmentLog> logs = logService.getAllAdjustments();
        return ResponseEntity.ok(logs);
    }
}
