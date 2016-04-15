package com.calendarApp.mvc.base.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.calendarApp.mvc.base.model.FormDTO;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayHome(Model model) {
		return "/home";
	}
	
	@ModelAttribute
	public FormDTO createFormBean() {
		return new FormDTO();
	}
	
	@RequestMapping(value = "/", method=RequestMethod.POST)
	public String submitMessage(@Valid FormDTO formDTO, BindingResult result,
								SessionStatus sessionStatus,
								RedirectAttributes redirectAttrs) {
		
		if (result.hasErrors()) {
			return "/home";
		}
		String message = formDTO.toString();
		sessionStatus.setComplete();
		redirectAttrs.addFlashAttribute("message", message);					// die FlashAttribute sind speziell für den Redirect konzipiert
																				// damit kann man sich unter Nutzung der mitgebrachten Funktionen die Nutzung von JS
		return "redirect:/";													// zB zur Validierung sparen
	}
}
