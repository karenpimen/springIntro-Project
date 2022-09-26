package services;

import dao.EventDAO;
import model.Event;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;
import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "/test.xml")
public class EventServiceImplTest {

    @Test
    void createEventSTest() {
        Event e= new Event("Nuevo Evento ", new Date(2022, 9,24));
        EventDAO eventDaoMock= mock(EventDAO.class);
        when(eventDaoMock.createE(e)).thenReturn(e);

        EventServiceImpl eventService = new EventServiceImpl();
        eventService.setEventDAO(eventDaoMock);

        Event newEvent=eventService.createEventS(e);
        assertEquals(newEvent,e);
    }
}