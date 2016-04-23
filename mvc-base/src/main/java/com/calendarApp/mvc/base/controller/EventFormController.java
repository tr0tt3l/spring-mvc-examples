package com.calendarApp.mvc.base.controller;

import com.calendarApp.mvc.base.model.CalendarMap;
import com.calendarApp.mvc.base.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tr0tt3l
 */
@Controller
public class EventFormController {


    @RequestMapping(value = "/event_add", method = RequestMethod.GET)
    public String displayEventAdd(Model model) {
        return "/event_add";
    }

    @ModelAttribute("Event")
    public Event createFormEvent() {
        return new Event();
    }

    @RequestMapping(value = "/event_add", method = RequestMethod.POST)
    public String eventAddForm(Event event,
                               Model model,
                               BindingResult result,
                               RedirectAttributes redirectAttrs,
                               HttpSession session) {


        String eventName = event.getName();
        Date eventStart = event.getStart();
        Date eventEnd = event.getEnd();

        ArrayList<String> status = new ArrayList<String>();
        status.add("privat");
        status.add("business");
        redirectAttrs.addAttribute("statusMap", status);



        redirectAttrs.addFlashAttribute("eventName", eventName);
        redirectAttrs.addFlashAttribute("eventStart", eventStart);
        redirectAttrs.addFlashAttribute("eventEnd", eventEnd);

        CalendarMap cal = (CalendarMap) session.getAttribute("CalendarMap");
        int errorCode = 1; // cal.validate(event);
        if (errorCode == 0) {
            //TODO: hier dann Objekt persistieren, sowas wie event.saveToDb o.ä.
            cal.addEventToList(event);
            session.setAttribute("CalendarMap", cal);
            return "/home";
        } else {
            redirectAttrs.addFlashAttribute("errorCode", errorCode);
            session.setAttribute("CalendarMap", cal);
            return "redirect:/event_add";
        }

    }

}




/**
 * Created by tr0tt3l
 */