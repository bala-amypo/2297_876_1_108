package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "price_adjustment_logs")
public class PriceAdjustmentLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long eventId;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private Double oldPrice;

    @Column(nullable = false)
    private Double newPrice;

    @Column(nullable = false)
    private LocalDateTime adjustmentTime;

    // Constructors
    public PriceAdjustmentLog() {
    }

    // Getters & Setters
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
