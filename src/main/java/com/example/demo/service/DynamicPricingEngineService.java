@Service
public class DynamicPricingEngineServiceImpl
        implements DynamicPricingEngineService {

    private final EventRecordRepository eventRepo;
    private final SeatInventoryRecordRepository inventoryRepo;
    private final PricingRuleRepository ruleRepo;
    private final DynamicPriceRecordRepository priceRepo;
    private final PriceAdjustmentLogRepository logRepo;

    public DynamicPricingEngineServiceImpl(
            EventRecordRepository eventRepo,
            SeatInventoryRecordRepository inventoryRepo,
            PricingRuleRepository ruleRepo,
            DynamicPriceRecordRepository priceRepo,
            PriceAdjustmentLogRepository logRepo) {

        this.eventRepo = eventRepo;
        this.inventoryRepo = inventoryRepo;
        this.ruleRepo = ruleRepo;
        this.priceRepo = priceRepo;
        this.logRepo = logRepo;
    }

    @Override
    public DynamicPriceRecord computeDynamicPrice(Long eventId) {

        EventRecord event = eventRepo.findById(eventId)
                .orElseThrow(() -> new BadRequestException("Event not found"));

        if (!event.getActive())
            throw new BadRequestException("Event is not active");

        SeatInventoryRecord inventory = inventoryRepo.findByEventId(eventId)
                .orElseThrow(() -> new BadRequestException("Seat inventory not found"));

        double finalPrice = event.getBasePrice();
        StringBuilder appliedRules = new StringBuilder();

        for (PricingRule rule : ruleRepo.findByActiveTrue()) {
            if (inventory.getRemainingSeats() >= rule.getMinRemainingSeats()
                    && inventory.getRemainingSeats() <= rule.getMaxRemainingSeats()) {
                finalPrice *= rule.getPriceMultiplier();
                appliedRules.append(rule.getRuleCode()).append(",");
            }
        }

        DynamicPriceRecord record = new DynamicPriceRecord();
        record.setEventId(eventId);
        record.setComputedPrice(finalPrice);
        record.setAppliedRuleCodes(appliedRules.toString());

        DynamicPriceRecord saved = priceRepo.save(record);

        priceRepo.findFirstByEventIdOrderByComputedAtDesc(eventId)
                .ifPresent(prev -> {
                    if (!prev.getComputedPrice().equals(finalPrice)) {
                        logRepo.save(new PriceAdjustmentLog(
                                null, eventId,
                                prev.getComputedPrice(),
                                finalPrice,
                                "Rule-based adjustment",
                                null
                        ));
                    }
                });

        return saved;
    }
}
