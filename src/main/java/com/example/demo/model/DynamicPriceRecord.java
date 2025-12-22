package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "dynamic_price_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DynamicPriceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Reference to EventRecord
    private Long eventId;

    private Double computedPrice;

    // Comma-separated applied rule codes
    private String appliedRuleCodes;

    private LocalDateTime computedAt;

    @PrePersist
    public void onCreate() {
        this.computedAt = LocalDateTime.now();
    }
}
