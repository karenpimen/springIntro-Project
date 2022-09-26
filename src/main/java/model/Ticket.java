package model;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by maksym_govorischev.
 */
@Data
public class Ticket {
    public enum Category {STANDARD, PREMIUM, BAR}
    private static final AtomicInteger countT = new AtomicInteger(4);

    /**
     * Ticket Id. UNIQUE.
     * @return Ticket Id.
     */
    final long ticketId;
    long userId;
    long eventId;
    Category category;
    int place;

    public Ticket(long userId, long eventId, Category category, int place) {
        this.ticketId = countT.incrementAndGet();
        this.userId = userId;
        this.eventId = eventId;
        this.category = category;
        this.place = place;
    }



}
