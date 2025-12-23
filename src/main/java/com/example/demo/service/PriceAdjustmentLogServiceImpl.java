package com.example.demo.service;

public interface PriceAdjustmentLogService {
    void logPriceChange(Long eventId, Double oldPrice, Double newPrice);
}
