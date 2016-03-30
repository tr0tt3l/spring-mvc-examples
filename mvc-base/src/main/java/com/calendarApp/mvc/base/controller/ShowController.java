package com.calendarApp.mvc.base.controller;

import javax.validation.Valid;

import com.calendarApp.mvc.base.model.Calendar;
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
public class ShowController {

    @ModelAttribute
    public Calendar createFormBean() {
        return new Calendar();
    }

    @RequestMapping(value = "/show", method=RequestMethod.GET)
    public String showName(@Valid Calendar cal, BindingResult result,
                                SessionStatus sessionStatus,
                                RedirectAttributes redirectAttrs) {

        if (false) {
            return "/home";
        }
        String message = cal.getName();
        sessionStatus.setComplete();
        redirectAttrs.addFlashAttribute("message", message);

        return "redirect:/show";
    }
}
