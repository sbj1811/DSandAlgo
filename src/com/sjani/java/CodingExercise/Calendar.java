package com.sjani.java.CodingExercise;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Calendar {

    TreeMap<Integer, List<Long>> eventsOfDay = new TreeMap<>();
    HashMap<Long, Event> eventMap = new HashMap<>();
    long id;

    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        calendar.book(10,11,26);
        calendar.book(11,12,26);
        calendar.book(12,13,26);
        List<Event> list = calendar.retrive(26);
        for (Event e:
             list) {
            System.out.println(e.start+" to "+e.end+" : "+e.date);
        }
        calendar.delete(1,26);
        List<Event> list2 = calendar.retrive(26);
        for (Event e:
                list2) {
            System.out.println(e.start+" to "+e.end+" : "+e.date);
        }
    }

    public void book(int start, int end, int date){
        Event event = new Event();
        event.start = start;
        event.end = end;
        event.id  = id++;
        event.date = date;
        eventMap.put(event.id,event);
        if(eventsOfDay.containsKey(date)){
            List<Long> list = eventsOfDay.get(date);
            list.add(event.id);
            eventsOfDay.put(date,list);
        } else {
            List<Long> list = new LinkedList<>();
            list.add(event.id);
            eventsOfDay.put(date, list);
        }
    }

    public void delete(int id, int date){
        eventMap.remove(id);
        List<Long> list = eventsOfDay.get(date);
        list.remove(id);
        eventsOfDay.put(date,list);
    }

    public List<Event> retrive (int date){
        List<Event> events = new LinkedList<>();
        if(eventsOfDay.containsKey(date)) {
            List<Long> list = eventsOfDay.get(date);
            for (Long id:
                 list) {
                events.add(eventMap.get(id));
            }
        }
        return events;
    }

    public class Event{
        int start;
        int end;
        long id;
        int date;
    }


}





