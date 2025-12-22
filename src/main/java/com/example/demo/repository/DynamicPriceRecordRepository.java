public interface DynamicPriceRecordRepository
        extends JpaRepository<DynamicPriceRecord, Long> {
    Optional<DynamicPriceRecord> findFirstByEventIdOrderByComputedAtDesc(Long eventId);
}
