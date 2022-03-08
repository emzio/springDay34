package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class FreeTimeController {

    @RequestMapping(path = "/free-time", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String freeTimeController(){
        LocalDate now = LocalDate.now();
//        LocalDate now = LocalDate.of(2022, 02, 28);
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        if (dayOfWeek== DayOfWeek.SATURDAY || dayOfWeek== DayOfWeek.SUNDAY){
            return "Wolne";
        } else {
            LocalTime time9 = LocalTime.of(9, 0, 0);
            LocalTime time17 = LocalTime.of(17, 0 ,0);
            if (LocalTime.now().isAfter(time9) && LocalTime.now().isBefore(time17)){
                return "Pracuje, nie dzwoń.";
            } else {
                return "Po Pracy";
            }
        }
    }
}
