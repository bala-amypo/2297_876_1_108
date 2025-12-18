import java.time.LocalDate;
import java.time.LocalDateTime;

public class EventRecord {

    private Long id;
    private String eventCode;      
    private String eventName;
    private String venue;
    private LocalDate eventDate;
    private Double basePrice;      
    private LocalDateTime createdAt;
    private Boolean active;         

    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}

