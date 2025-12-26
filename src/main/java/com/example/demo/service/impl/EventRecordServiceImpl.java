package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.service.EventRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // 🔥 THIS IS CRITICAL
public class EventRecordServiceImpl implements EventRecordService {

    private final EventRecordRepository eventRecordRepository;

    public EventRecordServiceImpl(EventRecordRepository eventRecordRepository) {
        this.eventRecordRepository = eventRecordRepository;
    }

    @Override
    public EventRecord createEvent(EventRecord event) {
        return eventRecordRepository.save(event);
    }

    @Override
    public EventRecord getEventById(Long id) {
        return eventRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    public List<EventRecord> getAllEvents() {
        return eventRecordRepository.findAll();
    }

    @Override
    public EventRecord updateEventStatus(Long id, Boolean active) {
        EventRecord event = getEventById(id);
        event.setActive(active);
        return eventRecordRepository.save(event);
    }
}
