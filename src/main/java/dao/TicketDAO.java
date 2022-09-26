package dao;

import data.DataSource;
import model.Event;
import model.Ticket;
import model.User;

import java.util.*;

public class TicketDAO {
    private DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    Exception e = new IllegalStateException("That place is taken");
    public Ticket bookT(long userId, long eventId, int place, Ticket.Category category) throws Exception {
         // @throws java.lang.IllegalStateException if this place has already been booked.
        for(Map.Entry<String,Ticket> entry: dataSource.ticketMap.entrySet()){
            if(entry.getValue().getEventId()== eventId && entry.getValue().getPlace()==place)
                throw e;
        }
        Ticket t = new Ticket(userId, eventId,category,place);
        Ticket t1 = dataSource.ticketMap.put("ticket: "+t.getTicketId(), t);
        //dataSource.passDataTicket((HashMap<String,Ticket>) dataSource.ticketMap);
        return t1;
    }

    public List<Ticket> getBookedTs(User user, int pageSize, int pageNum) {
        List<Ticket> tickets = new ArrayList<Ticket>();
        for(Map.Entry<String,Ticket> entry : dataSource.ticketMap.entrySet()){
            if(entry.getValue().getUserId()==(user.getUserId())){
                tickets.add(entry.getValue());
            }
        }
        return tickets;
    }

    public List<Ticket> getBookedTs(Event event, int pageSize, int pageNum) {
        List<Ticket> tickets = new ArrayList<Ticket>();
        for(Map.Entry<String,Ticket> entry : dataSource.ticketMap.entrySet()){
            if(entry.getValue().getEventId()==(event.getEventId())){
                tickets.add(entry.getValue());
            }
        }
        return tickets;
    }

    public boolean cancelT(long ticketId) {
        return dataSource.ticketMap.remove("ticket: "+ticketId)!=null;
    }

}
