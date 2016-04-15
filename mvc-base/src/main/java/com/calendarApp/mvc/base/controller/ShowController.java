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

import java.util.Map;


@Controller
@SessionAttributes("CalendarMap")                                       //bestimmt, dass alle benutzten @ModelAttribute in die Session geschrieben werden
public class ShowController {

    @ModelAttribute("CalendarMap")                                      //macht ein neues Objekt CalendarMap für die gemappte Methode verfügbar
    public CalendarMap createCalendarMap() {
        return new CalendarMap();
    }

    @RequestMapping(value = "/show", method=RequestMethod.GET)
    public String showName(@Valid CalendarMap cal,
                                HttpSession session,
                                Model model,
                                HttpServletRequest request) {

        Event e1 = new Event("test", false, 100000, 23400000);          //zeigt, das man auch verschachtelte Klassen nutzen kann
        cal.addTimestampToList(e1);
        model.addAttribute("test_event", cal.eventListToHtml());        //so werden die Attribute zur Verfügung gestellt, werden dann mit ${test_event} aufgerufen
        model.addAttribute("test_cal", cal.getName());
        model.addAttribute("test_cal2", cal.getCalendar());

        return "/show";                                                 //Aufruf des View
    }
}
