package com.nam.spring_42;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String index(){
        return "<h1>Hello World!</h1>";
    }

    @RequestMapping("/42")
    public String index42(@RequestParam(value="name", defaultValue = "xxx") String name){
        return String.format("<h1>Hello!!</h1><br /><h2>%s</h2>", name);
    }
}
