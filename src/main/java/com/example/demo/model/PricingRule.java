package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class PricingRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleCode;
    private String description;
    private Integer minRemainingSeats;
    private Integer maxRemainingSeats;
    private Integer daysBeforeEvent;
    private Double priceMultiplier;
    private Boolean active;

    // 🔹 Getters
    public Long getId() { return id; }
    public String getRuleCode() { return ruleCode; }
    public String getDescription() { return description; }
    public Integer getMinRemainingSeats() { return minRemainingSeats; }
    public Integer getMaxRemainingSeats() { return maxRemainingSeats; }
    public Integer getDaysBeforeEvent() { return daysBeforeEvent; }
    public Double getPriceMultiplier() { return priceMultiplier; }
    public Boolean getActive() { return active; }

    // 🔹 Setters
    public void setId(Long id) { this.id = id; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }
    public void setDescription(String description) { this.description = description; }
    public void setMinRemainingSeats(Integer minRemainingSeats) { this.minRemainingSeats = minRemainingSeats; }
    public void setMaxRemainingSeats(Integer maxRemainingSeats) { this.maxRemainingSeats = maxRemainingSeats; }
    public void setDaysBeforeEvent(Integer daysBeforeEvent) { this.daysBeforeEvent = daysBeforeEvent; }
    public void setPriceMultiplier(Double priceMultiplier) { this.priceMultiplier = priceMultiplier; }
    public void setActive(Boolean active) { this.active = active; }
}
