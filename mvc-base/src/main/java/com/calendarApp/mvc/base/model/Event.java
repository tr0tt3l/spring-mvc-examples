package com.calendarApp.mvc.base.model;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.GregorianCalendar;

public class Event {
    @NotEmpty
    private int id;
    private String name;
    private Boolean privat;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date start;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date end;

    public Event(int id, String name, Boolean privat, int year, int month, int day, int hour, int min){
        this.id = id;
        this.name = name;
        this.privat = privat;
        this.start = new GregorianCalendar(year, month, day, hour, min , 0).getTime();
        this.end = new Date();                                                                                          //// Constructor legt hilfsweise Datum von heute an
    }
    public Event(){}


    public String getName(){return this.name;}
    public Date getStart() { return this.start;}
    public Date getEnd() {return this.end;}
    public Boolean getPrivat() {return this.privat;}
    public int getId() {return this.id;}


    public void generateId(){
        //TODO: per DB-Abfrage die niedrigste verfügbare (oder so) Id ermitteln und ausgeben
    }
    public void setId(int id){
        this.id = id;
    }

    public void setPrivat(Boolean privat) {
        this.privat = privat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }


}
