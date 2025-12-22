package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.service.DynamicPricingService;
import org.springframework.stereotype.Service;

@Service
public class DynamicPricingServiceImpl implements DynamicPricingService {

    private final EventRecordRepository eventRepo;

    public DynamicPricingServiceImpl(EventRecordRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public double calculatePrice(Long eventId) {
        EventRecord event = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        return event.getBasePrice();
    }
}
