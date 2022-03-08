package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloName {
    @RequestMapping("/hello/{firstName}/{lastName}")
    @ResponseBody
    public String helloName(@PathVariable String firstName, @PathVariable String lastName){
        return "Witaj " + firstName + " " +lastName;
    }
}
