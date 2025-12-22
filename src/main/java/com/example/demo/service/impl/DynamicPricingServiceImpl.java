package com.example.demo.service.impl;

import com.example.demo.model.EventRecord;
import com.example.demo.repository.EventRecordRepository;
import com.example.demo.service.DynamicPricingEngineService;
import org.springframework.stereotype.Service;

@Service
public class DynamicPricingEngineServiceImpl implements DynamicPricingEngineService {

    private final EventRecordRepository eventRepo;

    public DynamicPricingEngineServiceImpl(EventRecordRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public double calculatePrice(Long eventId) {
        EventRecord event = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        return event.getBasePrice();
    }
}
