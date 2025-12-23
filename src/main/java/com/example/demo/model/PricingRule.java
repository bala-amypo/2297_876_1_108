package com.example.demo.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PricingRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ruleCode;

    @Column(length = 500)
    private String description;

    private Integer minRemainingSeats;
    private Integer maxRemainingSeats;

    private Integer daysBeforeEvent;

    @Column(nullable = false)
    private Double priceMultiplier;

    @Column(nullable = false)
    private Boolean active = true;

}
