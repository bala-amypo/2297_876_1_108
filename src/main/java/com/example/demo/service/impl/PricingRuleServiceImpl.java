package com.example.demo.service.impl;

import com.example.demo.model.PricingRule;
import com.example.demo.repository.PricingRuleRepository;
import com.example.demo.service.PricingRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingRuleServiceImpl implements PricingRuleService {

    private final PricingRuleRepository pricingRuleRepository;

    public PricingRuleServiceImpl(PricingRuleRepository pricingRuleRepository) {
        this.pricingRuleRepository = pricingRuleRepository;
    }

    @Override
    public PricingRule createRule(PricingRule rule) {
        // if (pricingRuleRepository.existsByRuleCode(rule.getRuleCode())) {
        //     throw new RuntimeException("Pricing rule already exists");
        // }
        return pricingRuleRepository.save(rule);
    }

    @Override
    public PricingRule updateRule(Long id, PricingRule updatedRule) {
        PricingRule existing = pricingRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pricing rule not found"));

        existing.setRuleCode(updatedRule.getRuleCode());
        existing.setDescription(updatedRule.getDescription());
        existing.setMinRemainingSeats(updatedRule.getMinRemainingSeats());
        existing.setMaxRemainingSeats(updatedRule.getMaxRemainingSeats());
        existing.setDaysBeforeEvent(updatedRule.getDaysBeforeEvent());
        existing.setPriceMultiplier(updatedRule.getPriceMultiplier());
        existing.setActive(updatedRule.getActive());

        return pricingRuleRepository.save(existing);
    }

    @Override
    public PricingRule getRuleById(Long id) {
        return pricingRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pricing rule not found"));
    }

    @Override
    public List<PricingRule> getActiveRules() {
        return pricingRuleRepository.findByActiveTrue();
    }

    @Override
    public List<PricingRule> getAllRules() {
        return pricingRuleRepository.findAll();
    }
}
