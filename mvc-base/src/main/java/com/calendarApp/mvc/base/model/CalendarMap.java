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
        this.calendar.set(2016,3,15,20,15,0);
        this.eventList = new ArrayList<Event>();
    }

    public int addTimestampToList(Event event){
        if(this.eventList.add(event)) {
            return 1;
        }
        else return 0;
    }

    public String eventListToHtml(){

        return this.eventList.get(0).getStart();
    }

    public String getName() {return "calendar test";}

    public String getCalendar() {return String.valueOf(this.calendar.get(Calendar.YEAR));}
}
