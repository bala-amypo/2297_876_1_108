@Entity
@Table(name = "dynamic_price_records")
public class DynamicPriceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;
    private Double computedPrice;
    private String appliedRuleCodes;

    private LocalDateTime computedAt;

    @PrePersist
    public void onCreate() {
        computedAt = LocalDateTime.now();
    }
}
