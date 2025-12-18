import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_records", uniqueConstraints = {
        @UniqueConstraint(columnNames = "eventCode")
})
public class EventRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String eventCode;

    @NotBlank
    @Column(nullable = false)
    private String eventName;

    @NotBlank
    @Column(nullable = false)
    private String venue;

    @NotNull
    private LocalDate eventDate;

    @NotNull
    @Positive
    private Double basePrice;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private Boolean active = true;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}