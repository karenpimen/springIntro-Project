package model;

import lombok.Data;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by maksym_govorischev.
 */
@Data
public class Event {
    /**
     * Event id. UNIQUE.
     * @return Event Id
     */
    private static final AtomicInteger count = new AtomicInteger(3);
    final long eventId;
    String title;
    Date date;

    public Event (){
        this.eventId=count.incrementAndGet();
    }
    public Event( String title, Date date) {
        this.title = title;
        this.date = date;
        this.eventId = count.incrementAndGet();
    }

    public Event(long eventId,String title, Date date){
        this.eventId=eventId;
        this.title = title;
        this.date = date;
    }
}
