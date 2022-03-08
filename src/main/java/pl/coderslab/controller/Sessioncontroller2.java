package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@SessionAttributes({"loginValue"})
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
}

