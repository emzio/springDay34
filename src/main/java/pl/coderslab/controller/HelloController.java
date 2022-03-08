package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalTime;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("helloView")
    public String helloView(Model model){
        LocalTime localTime = LocalTime.now();
        String background = "black";
        String color = "white";
        if(localTime.getHour()>=8 && localTime.getHour()<=20){
            background = "red";
            color = "green";
        }
        model.addAttribute("background", background);
        model.addAttribute("color", color);
        return "home";
    }


}
