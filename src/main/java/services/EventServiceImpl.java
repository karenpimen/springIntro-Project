package services;

import dao.EventDAO;
import model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

// Bean
public class EventServiceImpl implements EventService{

    //DAO with storage bean should be inserted into services beans using auto wiring
    // Autowire

    private EventDAO eventDAO;

    public void setEventDAO( EventDAO eventDAO ){
        this.eventDAO = eventDAO;
    }
    public EventDAO getEventDAO() {
        return eventDAO;
    }
    @Override
    public Event getEventByIdS(long eventId) {
        /**
         * Gets event by its id.
         * @return Event.
         */
        return eventDAO.getEById(eventId);
    }

    @Override
    public List<Event> getEventsByTitleS(String title, int pageSize, int pageNum) {
        /**
         * Get list of events by matching title. Title is matched using 'contains' approach.
         * In case nothing was found, empty list is returned.
         * @param title Event title or it's part.
         * @param pageSize Pagination param. Number of events to return on a page.
         * @param pageNum Pagination param. Number of the page to return. Starts from 1.
         * @return List of events.
         */
        return eventDAO.getEsByTitle(title, pageSize, pageNum);
    }

    @Override
    public List<Event> getEventsForDayS(Date day, int pageSize, int pageNum) {
        /**
         * Get list of events for specified day.
         * In case nothing was found, empty list is returned.
         * @param day Date object from which day information is extracted.
         * @param pageSize Pagination param. Number of events to return on a page.
         * @param pageNum Pagination param. Number of the page to return. Starts from 1.
         * @return List of events.
         */
        return eventDAO.getEsForDay(day, pageSize,pageNum);
    }

    @Override
    public Event createEventS(Event event) {
        /**
         * Creates new event. Event id should be auto-generated.
         * @param event Event data.
         * @return Created Event object.
         */
        return eventDAO.createE(event);
    }

    @Override
    public Event updateEventS(Event event) {
        /**
         * Updates event using given data.
         * @param event Event data for update. Should have id set.
         * @return Updated Event object.
         */
        return eventDAO.updateE(event);
    }

    @Override
    public boolean deleteEventS(long eventId) {
        /**
         * Gets user by its id.
         * @return User.
         */
        return eventDAO.deleteE(eventId);
    }
}
