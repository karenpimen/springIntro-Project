package facade;

import model.*;
import services.*;

import java.util.Date;
import java.util.List;

// Bean
public class BookingFacadeImpl implements BookingFacade{
    //Services should be injected into the facade using constructor based injection.
    private TicketServiceImpl ticketService;
    private EventServiceImpl eventService;
    private UserServiceImpl userService;

    public BookingFacadeImpl(TicketServiceImpl ticketServiceImpl, EventServiceImpl eventServiceImpl,
            UserServiceImpl userServiceImpl) {
            this.ticketService= ticketServiceImpl;
            this.eventService=eventServiceImpl;
            this.userService=userServiceImpl;
    }
    //The rest of injections should be done in a setter based way
    // Autowire

    @Override
    public Event getEventById(long eventId) { return eventService.getEventByIdS(eventId);}

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventService.getEventsByTitleS(title, pageSize, pageNum);
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventService.getEventsForDayS(day, pageSize, pageNum);
    }

    @Override
    public Event createEvent(Event event) {
       return eventService.createEventS(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventService.updateEventS(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return eventService.deleteEventS(eventId);
    }

    @Override
    public User getUserById(long userId) {
        return userService.getUserByIdS(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userService.getUsersByNameS(name, pageSize, pageNum);
    }

    @Override
    public User createUser(User user) {
        return userService.createUserS(user);
    }

    @Override
    public User updateUser(User user) {
        return userService.updateUserS(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return userService.deleteUserS(userId);
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) throws Exception {
        return ticketService.bookTicketS(userId, eventId, place, category);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketService.getBookedTicketsS(user, pageSize, pageNum);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketService.getBookedTicketsS(event, pageSize,pageNum);
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return ticketService.cancelTicketS(ticketId);
    }


}
