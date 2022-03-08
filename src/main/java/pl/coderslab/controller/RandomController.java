package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController {


    @RequestMapping(path = "/show-random", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String RandomController(){
        Random r = new Random();
        int a = r.nextInt(101);
        return "Wylosowano liczbę: wylosowana_liczba " + String.valueOf(a);
}
@GetMapping("/random/{max}/{min}")
    @ResponseBody
    public String randowm(@PathVariable int max, @PathVariable int min){
        return "Użytkownik podał wartości " +  min +" i " + max + " . Wylosowano liczbę: wylosowana liczba " + (min + new Random().nextInt(Math.abs(max - min)+1));
}

}
