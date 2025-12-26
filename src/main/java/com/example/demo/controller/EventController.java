package com.example.demo.controller;

import com.example.demo.model.EventRecord;
import com.example.demo.service.EventRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@Tag(name = "Events", description = "Event management operations")
public class EventController {

    private final EventRecordService eventService;

    // ✅ Constructor Injection (BEST PRACTICE)
    public EventController(EventRecordService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    @Operation(summary = "Create new event")
    public EventRecord createEvent(@RequestBody EventRecord event) {
        return eventService.createEvent(event);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get event by ID")
    public EventRecord getEvent(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @GetMapping
    @Operation(summary = "Get all events")
    public List<EventRecord> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "Update event status")
    public EventRecord updateStatus(
            @PathVariable Long id,
            @RequestParam Boolean active) {
        return eventService.updateEventStatus(id, active);
    }
}
