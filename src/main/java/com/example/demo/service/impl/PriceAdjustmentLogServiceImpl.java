package com.example.demo.service.impl;

import com.example.demo.service.PriceAdjustmentLogService;
import org.springframework.stereotype.Service;

@Service
public class PriceAdjustmentLogServiceImpl implements PriceAdjustmentLogService {

    @Override
    public void logPriceChange(Long eventId, Double oldPrice, Double newPrice) {
        // Implementation here (e.g., log to DB or console)
        System.out.println("Price changed for event " + eventId + " from " + oldPrice + " to " + newPrice);
    }
}
