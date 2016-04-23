package com.calendarApp.mvc.base.model;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarMap {
    private Calendar calendar;
    private ArrayList<Event> eventList;

    public ArrayList<Event> geteventList(){
        return this.eventList;
    }

    public CalendarMap(){
        this.calendar = new GregorianCalendar();
        this.calendar.set(2015,0,365,20,15,0);
        this.eventList = new ArrayList<Event>();
    }

    public int addEventToList(Event event){
        if(this.eventList.add(event)) {
            return 1;
        }
        else return 0;
    }
    /*

     */
    public int validate(Event event){ //TODO:hier sollte dann geprüft werden, ob ein spezielles Event zulässig ist, und in die Liste aufgenommen werden kann --> eindeutige id, keine zeitkonflikte zu anderen Events, alle Attribute gesetzt
        return 0;
    }

    public String eventListToHtml(){

        return this.eventList.get(0).getStart().toString();
    }

    public Calendar getCalendar() {return this.calendar;}
    public void setCalendar(Calendar cal) {this.calendar = cal;}

    public String getCalendarDateAsString() {return String.valueOf(this.calendar.get(Calendar.DATE)) + " " + String.valueOf(this.calendar.get(Calendar.MONTH)) + " " + String.valueOf(this.calendar.get(Calendar.YEAR));}
}
