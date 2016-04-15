package com.calendarApp.mvc.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.calendarApp.mvc.base.model.CalendarMap;
import com.calendarApp.mvc.base.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class SessionTestController {

    @RequestMapping(value = "/test", method=RequestMethod.GET)
    public String showAttribute(HttpSession session,
                                Model model,
                                HttpServletRequest request) {

        CalendarMap cal = (CalendarMap) session.getAttribute("CalendarMap");        // Auslesen des @ModelAttribute aus der Session
        model.addAttribute("test_cal2", cal.getCalendar());

        return "/test";
    }
}
