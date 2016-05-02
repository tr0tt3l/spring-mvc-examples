package com.calendarApp.mvc.service;

/**
 * Created by prans on 02.05.2016.
 */

import com.calendarApp.mvc.base.model.Event;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

public interface EventDAO {

        public void addEvent(Event p);
        public void updateEvent(Event p);
        public Event getEventById(int id);
        public void removeEvent(int id);
        public void setSessionFactory(SessionFactory sf);
}

