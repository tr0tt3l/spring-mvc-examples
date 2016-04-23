package com.calendarApp.mvc.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.calendarApp.mvc.base.model.CalendarMap;
import com.calendarApp.mvc.base.model.Event;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;


@Controller
public class ShowEventController {


    @RequestMapping(value = "/event_show", method=RequestMethod.GET)
    public String showName(     CalendarMap calMap,
                                HttpSession session,
                                Model model,
                                HttpServletRequest request) {

        session.toString();
        CalendarMap cal = (CalendarMap) session.getAttribute("CalendarMap");        // Auslesen des @ModelAttribute aus der Session
        Event e1 = new Event(123, "test", false, 3242432 , 23402340);               //zeigt, das man auch verschachtelte Klassen nutzen kann
        //cal.addEventToList(e1);
        //model.addAttribute("test_event", cal.eventListToHtml());                    //so werden die Attribute zur Verfügung gestellt, werden dann mit ${test_event} aufgerufen
        model.addAttribute("test_cal2", calMap.getCalendarDateAsString());

        return "/show";                                                             //Aufruf des View
    }
}
