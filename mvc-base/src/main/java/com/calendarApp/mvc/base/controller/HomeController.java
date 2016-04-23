package com.calendarApp.mvc.base.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.calendarApp.mvc.base.model.CalendarMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.calendarApp.mvc.base.model.FormDTO;

import java.util.GregorianCalendar;

@Controller
@SessionAttributes("CalendarMap")                                       //bestimmt, dass alle benutzten @ModelAttribute in die Session geschrieben werden
public class HomeController {

	@ModelAttribute("CalendarMap")                                      //macht ein neues Objekt CalendarMap für die gemappte Methode verfügbar
	public CalendarMap createCalendarMap() {
		CalendarMap cal = new CalendarMap();
		GregorianCalendar greCal = new GregorianCalendar();
		greCal.set(2003,0,1,0,0,0);
		cal.setCalendar(greCal);
		return cal;
	}
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String submitMessage(CalendarMap cal, BindingResult result,
								HttpSession session,
								RedirectAttributes redirectAttrs) {


		return "/home";
	}
}
