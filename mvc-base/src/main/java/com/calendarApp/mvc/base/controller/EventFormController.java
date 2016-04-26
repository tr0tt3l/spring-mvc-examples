package com.calendarApp.mvc.base.controller;

import com.calendarApp.mvc.base.model.CalendarMap;
import com.calendarApp.mvc.base.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
                               @RequestParam("id") int id,
                               Model model,
                               RedirectAttributes redirectAttrs,
                               HttpSession session,
                               HttpServletRequest request) {

        CalendarMap cal = (CalendarMap) session.getAttribute("CalendarMap");

        Event event = cal.getEventByIndex(id);
        model.addAttribute("Event", event);
        String eventName = event.getName();
        Date eventStart = event.getStart();
        Date eventEnd = event.getEnd();

        redirectAttrs.addFlashAttribute("eventName", eventName);
        redirectAttrs.addFlashAttribute("eventStart", eventStart);
        redirectAttrs.addFlashAttribute("eventEnd", eventEnd);

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


  ArrayList<String> status = new ArrayList<String>();
        status.add("privat");
        status.add("business");
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
        return "redirect:/event_add?act=del&id="+id;
    }

}




/**
 * Created by tr0tt3l
 */