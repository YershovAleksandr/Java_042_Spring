package com.nam.spring_42;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2 {
    @GetMapping("/x")
    public String index(){
        return "<h3>Hello</h3><br /><h2>World</h2>";
    }
    @RequestMapping("/x2")
    public String index2(@RequestParam(value="id", defaultValue = "42") String id){
        return String.format("<b>Id = </b><i>%s</i>", id);
    }
}
