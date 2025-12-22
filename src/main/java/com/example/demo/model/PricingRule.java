package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pricing_rules")
public class PricingRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String ruleCode;

    private String description;

    private Integer minRemainingSeats;
    private Integer maxRemainingSeats;

    private Integer daysBeforeEvent;

    private Double priceMultiplier;

    private Boolean active = true;

    // getters and setters
}
