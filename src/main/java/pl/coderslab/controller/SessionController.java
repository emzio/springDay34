package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDateTime;

@Controller
@SessionAttributes("loginStart")
public class SessionController {
    private static final Logger logger
            = LoggerFactory.getLogger(SampleLoggerController.class);

    @GetMapping("/loginStart")
    @ResponseBody
    public String loginStart(Model model, @SessionAttribute(value = "loginStart", required = false) String loginStart){
        logger.debug("<<<< loginStart is null? : " + String.valueOf(loginStart==null));
        if(loginStart == null ){
            String logStr = LocalDateTime.now().toString();
//            loginStart = LocalDateTime.now().toString();
            logger.debug("<<<< loginStart : " + loginStart);
            model.addAttribute("loginStart", logStr);
//            model.addAttribute("loginStart", loginStart);
        }
        return loginStart;
    }
}


//@Controller
//@SessionAttributes("loginStart")
//public class SessionController {
//
//    @GetMapping("/loginStart")
//    @ResponseBody
//    public String loginStart(Model model, @SessionAttribute(value = "loginStart", required = false) String loginStart) {
//        if (loginStart == null) {
//            model.addAttribute("loginStart", LocalDateTime.now().toString());
//        }
//        return loginStart;
//  }
//}
