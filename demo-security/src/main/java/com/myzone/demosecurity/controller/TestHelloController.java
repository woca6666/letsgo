package com.myzone.demosecurity.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestHelloController {

    @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(){
        return "hello";
    }

    @RequestMapping(value = "/bye", method = RequestMethod.GET)
    @ResponseBody
    public String saybye(){
        return "bye";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
//    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String add(){
        return "add";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public String update(){
        return "update";
    }
}
