package com.example.demo.service.impl;

import com.example.demo.model.PricingRule;
import com.example.demo.service.PricingRuleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PricingRuleServiceImpl implements PricingRuleService {

    private final List<PricingRule> rules = new ArrayList<>();

    @Override
    public PricingRule addRule(PricingRule rule) {
        rules.add(rule);
        return rule;
    }

    @Override
    public List<PricingRule> getAllRules() {
        return new ArrayList<>(rules);
    }
}
