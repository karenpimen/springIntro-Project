package data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.*;

import java.lang.reflect.Type;
import java.util.*;
import java.io.*;

// Bean
public class DataSource {

    public Map<String, Event> eventMap = new HashMap<>();
    public Map<String, User> userMap = new HashMap<>();
    public Map<String, Ticket> ticketMap = new HashMap<>();

    public Event muestra(Event e){
        return eventMap.put("event "+e.getEventId(), e);
    }
    public void initData() {
        Gson gsonE = new Gson();
        try (Reader reader = new FileReader("StorageEvent.json")) {
            // Convert JSON File to Java Object
            Type eventMapType = new TypeToken<Map<String, Event>>() {}.getType();
            eventMap = gsonE.fromJson(reader, eventMapType);
            // print
            System.out.println(eventMap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gsonU = new Gson();
        try (Reader reader = new FileReader("StorageUser.json")) {
            // Convert JSON File to Java Object
            Type userMapType = new TypeToken<Map<String, User>>() {}.getType();
            this.userMap = gsonU.fromJson(reader, userMapType);
            // print staff
            System.out.println(userMap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gsonT = new Gson();
        try (Reader reader = new FileReader("StorageTicket.json")) {
            // Convert JSON File to Java Object
            Type ticketMapType = new TypeToken<Map<String, Ticket>>() {}.getType();
            ticketMap = gsonT.fromJson(reader, ticketMapType);
            // print
            System.out.println(ticketMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}