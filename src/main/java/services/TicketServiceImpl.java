package services;

import dao.TicketDAO;
import dao.UserDAO;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class TicketServiceImpl implements TicketService{
    //DAO with storage bean should be inserted into services beans using auto wiring
    // Autowire
    TicketDAO ticketDAO;

    public void setTicketDAO(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public TicketDAO getTicketDAO(){
        return ticketDAO;
    }
    EventServiceImpl es;
    UserServiceImpl us;
    TicketServiceImpl(UserServiceImpl us, EventServiceImpl es){
        this.us=us;
        this.es=es;
    }

    TicketServiceImpl(){}
    @Override
    public Ticket bookTicketS(long userId, long eventId, int place, Ticket.Category category) throws Exception {
        /**
         * Book ticket for a specified event on behalf of specified user.
         * @param userId User Id.
         * @param eventId Event Id.
         * @param place Place number.
         * @param category Service category.
         * @return Booked ticket object.
         * @throws java.lang.IllegalStateException if this place has already been booked.
         */
        return ticketDAO.bookT(userId, eventId,place,category);
    }

    @Override
    public List<Ticket> getBookedTicketsS(User user, int pageSize, int pageNum) {
        /**
         * Get all booked tickets for specified user. Tickets should be sorted by event date in descending order.
         * @param user User
         * @param pageSize Pagination param. Number of tickets to return on a page.
         * @param pageNum Pagination param. Number of the page to return. Starts from 1.
         * @return List of Ticket objects.
         */

        return ticketDAO.getBookedTs(user, pageSize, pageNum);
    }

    @Override
    public List<Ticket> getBookedTicketsS(Event event, int pageSize, int pageNum) {
        /**
         * Get all booked tickets for specified event. Tickets should be sorted in by user email in ascending order.
         * @param event Event
         * @param pageSize Pagination param. Number of tickets to return on a page.
         * @param pageNum Pagination param. Number of the page to return. Starts from 1.
         * @return List of Ticket objects.
         */

        return ticketDAO.getBookedTs(event, 5,1);
    }

    @Override
    public boolean cancelTicketS(long ticketId) {
        /**
         * Cancel ticket with a specified id.
         * @param ticketId Ticket id.
         * @return Flag whether anything has been canceled.
         */
        return ticketDAO.cancelT(ticketId);
    }
}
