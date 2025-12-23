package com.example.demo.model;

import java.time.LocalDateTime;

public class PriceAdjustmentLog {

    private Long id;
    private Long eventId;
    private String description;
    private Double oldPrice;
    private Double newPrice;
    private LocalDateTime adjustmentTime;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Double newPrice) {
        this.newPrice = newPrice;
    }

    public LocalDateTime getAdjustmentTime() {
        return adjustmentTime;
    }

    public void setAdjustmentTime(LocalDateTime adjustmentTime) {
        this.adjustmentTime = adjustmentTime;
    }
}
