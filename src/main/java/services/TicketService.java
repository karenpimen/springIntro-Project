package services;

import model.Event;
import model.Ticket;
import model.User;

import java.util.List;

public interface TicketService {
    Ticket bookTicketS(long userId, long eventId, int place, Ticket.Category category) throws Exception;

    List<Ticket> getBookedTicketsS(User user, int pageSize, int pageNum);

    List<Ticket> getBookedTicketsS(Event event, int pageSize, int pageNum);

    boolean cancelTicketS(long ticketId);
}
