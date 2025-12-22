package com.example.demo.controller;

import com.example.demo.model.SeatInventoryRecord;
import com.example.demo.service.SeatInventoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
@Tag(name = "Seat Inventory Management")
public class SeatInventoryController {

    private final SeatInventoryService inventoryService;

    public SeatInventoryController(SeatInventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public SeatInventoryRecord createInventory(
            @RequestBody SeatInventoryRecord inventory) {
        return inventoryService.createInventory(inventory);
    }

    @PutMapping("/{eventId}/remaining")
    public SeatInventoryRecord updateRemainingSeats(
            @PathVariable Long eventId,
            @RequestParam Integer remainingSeats) {
        return inventoryService.updateRemainingSeats(eventId, remainingSeats);
    }

    @GetMapping("/event/{eventId}")
    public Optional<SeatInventoryRecord> getByEvent(
            @PathVariable Long eventId) {
        return inventoryService.getInventoryByEvent(eventId);
    }

    @GetMapping
    public List<SeatInventoryRecord> getAll() {
        return inventoryService.getAllInventories();
    }
}
