package com.calendarApp.mvc.base.model;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;

public class Event {
    @NotEmpty
    private long id;
    private String name;
    private Boolean privat;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date start;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date end;

    public Event(long id, String name, Boolean privat, long start, long end){
        this.id = id;
        this.name = name;
        this.privat = privat;
        this.start = new Date();                                                //// Constructor legt hilfsweise Datum von heute an
        this.end = new Date();
    }
    public Event(){}


    public String getName(){return this.name;}
    public Date getStart() { return this.start;}
    public Date getEnd() {return this.end;}
    public String getPrivat() {return this.privat.toString();}


    public void generateId(){
        //TODO: per DB-Abfrage die niedrigste verfügbare (oder so) Id ermitteln und ausgeben
    }
    public void setId(long id){
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
