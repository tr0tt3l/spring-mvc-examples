package com.calendarApp.mvc.base.controller;

import com.calendarApp.mvc.base.model.CalendarMap;
import com.calendarApp.mvc.base.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;


@Controller
public class ShowEventController {


    @RequestMapping(value = "/event_show", method=RequestMethod.GET)
    public String showName(     HttpSession session,
                                Model model,
                                HttpServletRequest request) {

        CalendarMap cal = (CalendarMap) session.getAttribute("CalendarMap");       // Auslesen des Attributes aus der Session
        Event e1 = new Event(0, "test", false, 2003, 12, 25, 20, 15);               //zeigt, das man auch verschachtelte Klassen nutzen kann
        if(cal.addEventToList(e1) != 1) return "/home";
        Event e2 = new Event(1, "test2", true, 2005, 12, 5, 20, 15);              //so werden die Attribute zur Verfügung gestellt, werden dann mit ${test_event} aufgerufen
        cal.addEventToList(e2);
        model.addAttribute("params", new ArrayList<String>());
        model.addAttribute("list", cal.eventListToHtml());
        model.addAttribute("eventList", cal.getEventList());

        session.setAttribute("CalendarMap", cal);

        return "/show";                                                             //Aufruf des View
    }
}
