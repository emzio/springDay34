package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Parameter;
import java.time.LocalDate;

@Controller
@RequestMapping("/first")
public class GetPost {

    @GetMapping("/form")
    public String form() {
        return "form.jsp";
    }

    @PostMapping("/form")
    @ResponseBody
    public String form(@RequestParam String  paramName, @RequestParam String paramDate){
        LocalDate date = LocalDate.parse(paramDate);
        return "param name: " + paramName + "<br>" + "date: " + date;
    }


}
