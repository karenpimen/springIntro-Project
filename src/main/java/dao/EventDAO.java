package dao;


import data.DataSource;
import model.Event;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.Paths;
import java.util.*;

// Bean
public class EventDAO {

    // DataSource dataSource

    private DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public DataSource getDataSource() {
        return dataSource;
    }

    public Event getEById(long eventId) {
        Event e =dataSource.eventMap.get("event: "+eventId);
        return e;
    }

    public List<Event> getEsByTitle(String title, int pageSize, int pageNum){
        List <Event> events = new ArrayList<Event>();
        for(Map.Entry<String,Event> entry : dataSource.eventMap.entrySet()){
            if(entry.getValue().getTitle().contains(title))
                events.add(entry.getValue());
        }
        return events;
    }

    public List<Event> getEsForDay(Date day, int pageSize, int pageNum) {
        List <Event> events = new ArrayList<Event>();
        for(Map.Entry<String,Event> entry : dataSource.eventMap.entrySet()){
            if(entry.getValue().getDate().equals(day))
                events.add(entry.getValue());
        }
        return events;
    }
    public Event createE (Event event){
        dataSource.eventMap.put("event: "+event.getEventId(), event);
        return event;
    }
    public Event updateE(Event event) {
        return dataSource.eventMap.replace("event: "+event.getEventId(),event);
    }
    public boolean deleteE(long eventId) {
        return dataSource.eventMap.remove("event: "+eventId)!=null;
    }



}
