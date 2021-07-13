package com.company.controller;

import com.company.service.DemoService;
import com.company.service.DemoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    // == fields ==
    private final DemoService demoservice;

    // == constructors ==
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoservice = demoService;
    }

    // == request methods ==

    // http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

    // http://localhost:8080/todo-list/welcome
    // http://localhost:8080/todo-list/welcome?user=Long&age=21
    @GetMapping("welcome")
    public String welcome(@RequestParam String user,@RequestParam int age, Model model){

        //        model.addAttribute("user","Tim");
        model.addAttribute("helloMessage",demoservice.getHelloMessage(user));
        model.addAttribute("age",age);
        log.info("model = {}",model);
        // prefix + name + suffix
        // /WEB-INF/view/welcome.jsp
        return "welcome";
    }

    // == model attributes ==
    @ModelAttribute("welcomeMessage")
    public String WelcomeMessage69(){
        log.info("welcomeMessage() called");
        return demoservice.getWelcomeMessage();
    }


}
