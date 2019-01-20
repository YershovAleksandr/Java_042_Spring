package com.nam.spring_42;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class HomeController {

    //private static User usr = new User();
    private static List<User> users = new ArrayList<>();

    /*static {
        users.add(new User());

    }*/

    @GetMapping("/home")
    public String home(Locale locale, Model model){

        model.addAttribute("serverTime", String.format("Time is: %s", new Date().toString()));


        users.add(new User());

        model.addAttribute("usr", new User());
        //model.addAttribute("users", users);

        return "home";
    }
}
