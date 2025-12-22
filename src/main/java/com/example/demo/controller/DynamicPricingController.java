@RestController
@RequestMapping("/api/dynamic-pricing")
@Tag(name = "Dynamic Pricing")
public class DynamicPricingController {

    private final DynamicPricingEngineService service;

    public DynamicPricingController(DynamicPricingEngineService service) {
        this.service = service;
    }

    @PostMapping("/compute/{eventId}")
    public DynamicPriceRecord compute(@PathVariable Long eventId) {
        return service.computeDynamicPrice(eventId);
    }

    @GetMapping("/latest/{eventId}")
    public Optional<DynamicPriceRecord> latest(@PathVariable Long eventId) {
        return service.getLatestPrice(eventId);
    }
}
