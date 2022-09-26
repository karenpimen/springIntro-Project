

import facade.*;
import model.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Date;



public class Application {
    public static void main(String[] args) {
        //Logging
        Logger log = LogManager.getLogger(Application.class.getName());

        // Get context instance
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        log.info("Loading beans configuration");
        BookingFacadeImpl bookingFacade = (BookingFacadeImpl) context.getBean("bookingFacadeImpl");
        log.info("Creating booking facade bean");

        //Event
        System.out.println("EVENTS");
        Event event = new Event("After Hours Tour", new Date(2022,6,11));
        Event returnedEvent= bookingFacade.createEvent(event);
        System.out.println(bookingFacade.getEventById(1).getTitle());
        System.out.println(bookingFacade.getEventsByTitle("After", 5, 1));
        System.out.println(bookingFacade.getEventsForDay(new Date(2022, 6, 11), 5,1));
        System.out.println(bookingFacade.updateEvent(new Event(1,"After Hours Tour1", new Date(2022,6,11))));
        System.out.println(bookingFacade.deleteEvent(1));

//        //User

        User k = new User("Karen Pimentel", "karen@gmail.com");
        bookingFacade.createUser(k);
        System.out.println(bookingFacade.getUserById(1));
        System.out.println(bookingFacade.getUserByEmail("karen@gmail.com"));
        System.out.println(bookingFacade.getUsersByName("Karen",5,1));
        System.out.println(bookingFacade.updateUser(new User("Belen Hermosillo","Belen@gmail.com",2)));
        System.out.println(bookingFacade.deleteUser(1));

//        //Ticket
        try {
            bookingFacade.bookTicket(2, 1, 10, Ticket.Category.BAR);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        bookingFacade.getBookedTickets(k,5,1);
        bookingFacade.getBookedTickets(event,5,1);
        bookingFacade.cancelTicket(1);

        log.info("Closing the project");
    }
}
