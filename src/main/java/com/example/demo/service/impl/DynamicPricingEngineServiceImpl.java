package com.example.demo.service.impl;

import com.example.demo.service.DynamicPricingEngineService;
import org.springframework.stereotype.Service;

@Service
public class DynamicPricingEngineServiceImpl
        implements DynamicPricingEngineService {

    @Override
    public Double computeDynamicPrice(Long eventId) {
        return 900.0;
    }
}
