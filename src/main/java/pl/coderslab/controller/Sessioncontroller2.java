package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@SessionAttributes({"loginValue", "loginStart"})
public class Sessioncontroller2 {

    @ResponseBody
    @RequestMapping("/loginStart2")
    public String loginStart(Model model, @SessionAttribute(value = "loginValue", required = false) String loginValue){
        if(loginValue==null){
//            ver1
            model.addAttribute("loginValue", LocalDateTime.now().toString());
//            ver2
//            loginValue=LocalDateTime.now().toString();
//            String temp = new String("");
////            String temp = "";
//            temp = loginValue;
//            System.out.println(temp + "<<<<<<<<<<<<<<<<<<<<<<>>>>>>temp");
//            model.addAttribute("loginValue", temp);
////            ver3
//            String temp = LocalDateTime.now().toString();
//            loginValue = temp;
//            System.out.println(loginValue + "<<<<<<<<<<<<<<<<<<<<<<>>>>>>loginValue");
//            model.addAttribute("loginValue", temp);
////            ver4
//            String temp = LocalDateTime.now().toString();
//            System.out.println(loginValue + "<<<<<<<<<<<<<<<<<<<<<<>>>>>>loginValue");
//            model.addAttribute("loginValue", temp);
//            loginValue = temp;
        }
    return loginValue;
    }


    @RequestMapping("/loginStart4")
    public String loginStart4(Model model, @SessionAttribute(value = "loginValue", required = false) String loginValue){
        if(loginValue==null){
            loginValue = LocalDateTime.now().toString();
            model.addAttribute("loginValue", loginValue);
        }
        return "loginValueJsp";
    }

    @ResponseBody
    @RequestMapping("/loginStart41")
    public String loginStart41(Model model, @SessionAttribute(value = "loginValue", required = false) String loginValue){
        if(loginValue==null){
            loginValue = LocalDateTime.now().toString();
            model.addAttribute("loginValue", loginValue);
        }
        return loginValue;
    }


    @ResponseBody
    @RequestMapping("/loginStart3")
    public String anotherSession(HttpSession session){
        String loginValue = (String) session.getAttribute("loginValue");
        if (loginValue== null){
            loginValue = "Session added atr: " + LocalDateTime.now().toString();
            session.setAttribute("loginValue", loginValue);
        }
        return loginValue;
    }

    @GetMapping("/loginStart5")
    @ResponseBody
    public String loginStart5(Model model,
                             @SessionAttribute(value = "loginStart", required = false) String loginStart) {
        String tmp = "";
        if (loginStart == null) {
            tmp =LocalDateTime.now().toString();
            model.addAttribute("loginStart", tmp);
        }
        tmp = loginStart;
        if (tmp!=null){
            tmp = String.valueOf(LocalDateTime.parse(tmp).plusDays(10));
        }
//        tmp= tmp + " updated";
        return tmp;
    }

    @ResponseBody
    @RequestMapping("/loginStart6")
    public String loginStart6(Model model, @SessionAttribute(value = "loginValue", required = false) String loginValue){
        if(loginValue==null){
            model.addAttribute("loginValue", LocalDateTime.now().toString());
        }
        return loginValue;
    }

    @ResponseBody
    @RequestMapping("/loginStart61")
    public String loginStart61(Model model, @SessionAttribute(value = "loginValue", required = false) String loginValue){
        if(loginValue==null){
            model.addAttribute("loginValue", LocalDateTime.now().toString());
        }
        return "ustawiłem atrybut sesji" + loginValue;
    }
}

