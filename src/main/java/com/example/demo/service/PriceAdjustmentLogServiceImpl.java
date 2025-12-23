package com.example.demo.service;

import com.example.demo.model.PriceAdjustmentLog;

import java.util.List;

public interface PriceAdjustmentLogServiceImpl {

    PriceAdjustmentLog logAdjustment(PriceAdjustmentLog log);

    List<PriceAdjustmentLog> getAdjustmentsByEvent(Long eventId);

    List<PriceAdjustmentLog> getAllAdjustments();
}
package com.example.demo.service.impl;

import com.example.demo.service.PriceAdjustmentLogService;
import org.springframework.stereotype.Service;

@Service
public class PriceAdjustmentLogServiceImpl
        implements PriceAdjustmentLogService {

    @Override
    public void logPriceChange(Long eventId, Double oldPrice, Double newPrice) {
        System.out.println("Price updated");
    }
}
