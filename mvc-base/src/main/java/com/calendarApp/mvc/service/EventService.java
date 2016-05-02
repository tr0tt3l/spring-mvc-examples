package com.calendarApp.mvc.service;

import com.calendarApp.mvc.base.model.Event;

/**
 * Created by prans on 02.05.2016.
 */
public interface EventService {

        public void addEvent(Event p);
        public void updateEvent(Event p);
        public Event getEventById(int id);
        public void removeEvent(int id);
        public void setEventDAO(EventDAO EventDAO);
    
}
