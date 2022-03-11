package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;


@Controller
@SessionAttributes({"count", "max"})
public class SessionLMS {
    @RequestMapping("/lms")
//    @ResponseBody
    public String index(Model model) {
        model.addAttribute("max", 12);
        model.addAttribute("count", 99);
        model.addAttribute("onlyJspAtr", "JSP Only");
        return "index";
    }

    @RequestMapping("/lmsGet")
    @ResponseBody
    public String session2(HttpSession ses) {
        int sesMax = (int)ses.getAttribute("max");
        System.out.println("sesMax: >>>>>>>>>>>>>>>>>" + sesMax);
        int sesCount = (int)ses.getAttribute("count");
        System.out.println("sesCount: >>>>>>>>>>>>>>" + sesCount);
        String onlyJspAtr = (String) ses.getAttribute("onlyJspAtr");
        System.out.println("onlyJspAtr: >>>>>>>>>>>>>>" + onlyJspAtr);
        return "session";
    }
}

