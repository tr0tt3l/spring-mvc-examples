package com.calendarApp.mvc.base.model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Event {
    private String name;
    private Boolean privat;
    private Timestamp start;
    private Timestamp end;

    public Event(String name, Boolean privat, long start, long end){
        this.name = name;
        this.privat = privat;
        this.start = new Timestamp(start);
        this.end = new Timestamp(end);
    }

    public String getName(){
        return this.name;
    }
    public String getStart() { return this.start.toString();}
    public String getEnd() {return this.end.toString();}

}
