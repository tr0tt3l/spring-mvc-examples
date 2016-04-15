package com.calendarApp.mvc.base.controller;


import com.calendarApp.mvc.base.model.CalendarMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RequestTestController{

    @RequestMapping(value = "/test1", method= RequestMethod.GET)        //@RequestParam liest den Eintrag mit dem fraglichen Namen aus dem Get-Request
    public String testRequestGet(@RequestParam("arg1") String arg1,     //und stellt es als Variable zur Verfügung
                        HttpSession session,
                        Model model,
                        HttpServletRequest request) {

        model.addAttribute("arg1",arg1);

        return "/test1";
    }

    @RequestMapping(value = "/test2", method= RequestMethod.POST)
    public String testRequestPost(@RequestParam("arg1") String arg1,        //Spring unterstützt den Transport über POST nicht mit eigenen Methoden
                              HttpSession session,                          //ist nur vorgesehen für das auslesen von Formularen
                              Model model,
                              HttpServletRequest request) {

        model.addAttribute("arg1",arg1);

        return "/test1";
    }
}
