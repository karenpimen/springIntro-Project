package services;

import model.Event;

import java.util.Date;
import java.util.List;

public interface EventService {
    Event getEventByIdS(long eventId);

    List<Event> getEventsByTitleS(String title, int pageSize, int pageNum);

    List<Event> getEventsForDayS(Date day, int pageSize, int pageNum);

    Event createEventS(Event event);

    Event updateEventS(Event event);

    boolean deleteEventS(long eventId);
}
