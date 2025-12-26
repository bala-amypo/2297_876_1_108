package com.example.demo.controller;

import com.example.demo.model.EventRecord;
import com.example.demo.service.EventRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventRecordService eventService;

    public EventController(EventRecordService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public EventRecord createEvent(@RequestBody EventRecord event) {
        return eventService.createEvent(event);
    }

    @GetMapping("/{id}")
    public EventRecord getEvent(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @GetMapping
    public List<EventRecord> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PutMapping("/{id}/status")
    public EventRecord updateStatus(
            @PathVariable Long id,
            @RequestParam Boolean active) {
        return eventService.updateEventStatus(id, active);
    }
}
