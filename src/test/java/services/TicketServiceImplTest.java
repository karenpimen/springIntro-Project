package services;

import dao.EventDAO;
import dao.TicketDAO;
import model.Ticket;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "/test.xml")
class TicketServiceImplTest {

    @Test
    void bookTicketSTest() throws Exception {
        Ticket t= new Ticket(1,2, Ticket.Category.STANDARD,2);

        TicketDAO ticketDaoMock= mock(TicketDAO.class);
        when(ticketDaoMock.bookT(1,2,2,Ticket.Category.STANDARD)).thenReturn(t);

        TicketServiceImpl ticketServiceImpl = new TicketServiceImpl();
        ticketServiceImpl.setTicketDAO(ticketDaoMock);

        Ticket newTicket = ticketServiceImpl.bookTicketS(1,2,2,Ticket.Category.STANDARD);
        assertEquals(t,newTicket);
    }
}