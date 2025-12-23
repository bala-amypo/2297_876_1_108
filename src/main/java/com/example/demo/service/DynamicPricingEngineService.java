package com.example.demo.service;

import java.util.List;

public interface DynamicPricingEngineService {

    Double computeDynamicPrice(Long eventId);

    Double getLatestPrice(Long eventId);

    List<Double> getPriceHistory(Long eventId);

    List<Double> getAllComputedPrices();
}
