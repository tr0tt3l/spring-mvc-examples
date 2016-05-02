package com.calendarApp.mvc.service;

import com.calendarApp.mvc.base.model.Event;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


@Repository
public class EventDAOImpl implements EventDAO {

    private SessionFactory sessionFactory;

    @Override
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addEvent(Event p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
    }

    @Override
    public void updateEvent(Event p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
    }


    @Override
    public Event getEventById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Event p = (Event) session.load(Event.class, new Integer(id));
        return p;
    }

    @Override
    public void removeEvent(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Event p = (Event) session.load(Event.class, new Integer(id));
        if(null != p){
            session.delete(p);
        }
    }
}
