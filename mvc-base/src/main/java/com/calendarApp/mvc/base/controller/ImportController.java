package com.calendarApp.mvc.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ImportController {

    @RequestMapping(value = "/import", method= RequestMethod.GET)
    public String showName(     HttpSession session,
                                Model model,
                                HttpServletRequest request) {



        return "/import";
    }
}

