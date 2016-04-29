package com.calendarApp.mvc.base.controller;

import com.calendarApp.mvc.base.model.CalendarMap;
import com.calendarApp.mvc.base.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by tr0tt3l
 */
@Controller
public class EventFormController {

    @ModelAttribute("Event")
    public Event createFormEvent() {
        return new Event();
    }

    @RequestMapping(value = "/event_add", method = RequestMethod.GET)
    public String eventAddForm(@RequestParam("act") String action,
                               @RequestParam("id") String idString,
                               Model model,
                               HttpSession session,
                               HttpServletRequest request) {

        CalendarMap cal = (CalendarMap) session.getAttribute("CalendarMap");
        int id = Integer.valueOf(idString);
        Event event = cal.getEventByIndex(id);
        model.addAttribute("Event", event);
        String eventName = event.getName();
        Date eventStart = event.getStart();
        Date eventEnd = event.getEnd();

        Boolean eventPrivat = event.getPrivat();
        ArrayList<Boolean> status = new ArrayList<Boolean>();
        if(eventPrivat) { status.add(true); status.add(false);
        }else           { status.add(false); status.add(true);}

        model.addAttribute("eventStatus", status);
        model.addAttribute("eventName", eventName);
        model.addAttribute("eventStart", eventStart);
        model.addAttribute("eventEnd", eventEnd);

     /*         switch(action){
            case "del":{
                Event event = cal.getEventByIndex(id);
                String eventName = event.getName();
                Date eventStart = event.getStart();
                Date eventEnd = event.getEnd();

                redirectAttrs.addFlashAttribute("eventName", eventName);
                redirectAttrs.addFlashAttribute("eventStart", eventStart);
                redirectAttrs.addFlashAttribute("eventEnd", eventEnd);
            }

        }


 ;
        redirectAttrs.addAttribute("statusMap", status);





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
 */
        return "/event_add.jsp?act=del&id="+idString;
    }

}




/**
 * Created by tr0tt3l
 */