package com.calendarApp.mvc.base.controller;

import com.calendarApp.mvc.base.model.CalendarMap;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("CalendarMap")                                       //bestimmt, dass alle benutzten @ModelAttribute in die Session geschrieben werden
public class HomeController {

	@ModelAttribute("CalendarMap")                                      //macht ein neues Objekt CalendarMap für die gemappte Methode verfügbar
	public CalendarMap createCalendarMap() {
		CalendarMap cal = new CalendarMap();
		return cal;
	}
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String submitMessage(@ModelAttribute("CalendarMap") CalendarMap cal, BindingResult result,
								HttpSession session,
								RedirectAttributes redirectAttrs) {

		session.setAttribute("CalendarMap",cal);

		return "/home";
	}
}
