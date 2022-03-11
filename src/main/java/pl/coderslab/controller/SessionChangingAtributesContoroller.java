package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"counter"})
public class SessionChangingAtributesContoroller {

//    Ver1:
//    @ResponseBody
//    @RequestMapping("/sessAtr")
//    public String setCounter(Model model, @SessionAttribute(value = "counter", required = false) String counter) {
//
//        Integer varToSet = 1;
//        if (counter == null) {
//            model.addAttribute("counter", String.valueOf(varToSet));
//            System.out.println("varToSet if counter nnull: <<<<<<<<<<<<<<<<<" + varToSet);
//        } else {
//            varToSet = Integer.parseInt(counter) + 1;
//            System.out.println("varToSet: >>>>>>>>>>>>>>>>>>" + varToSet);
//            model.addAttribute("counter", String.valueOf(varToSet));
//        }
//        return counter;
////        return varToSet.toString();
//    }

//    Ver2:
//    @ResponseBody
//    @RequestMapping("/sessAtr")
//    public String setCounter(Model model, @SessionAttribute(value = "counter", required = false) Integer counter) {
//
//        Integer varToSet = 1;
//        if (counter == null) {
//            counter = varToSet;
//            model.addAttribute("counter", varToSet);
//            System.out.println("varToSet if counter null: <<<<<<<<<<<<<<<<<" + varToSet);
//        } else {
//            varToSet = (counter) + 1;
//            System.out.println("varToSet: >>>>>>>>>>>>>>>>>>" + varToSet);
//            model.addAttribute("counter", varToSet);
//        }
//        return String.valueOf(counter);
////        return varToSet.toString();
//    }

////    Ver3:
//    @RequestMapping("/sessAtr")
//    public String setCounter(Model model, @SessionAttribute(value = "counter", required = false) String counter) {
//
//        Integer varToSet = 1;
//        if (counter == null) {
//            model.addAttribute("counter", String.valueOf(varToSet));
//            System.out.println("varToSet if counter null: <<<<<<<<<<<<<<<<<" + varToSet);
//        } else {
//            varToSet = Integer.parseInt(counter) + 1;
//            System.out.println("varToSet: >>>>>>>>>>>>>>>>>>" + varToSet);
//            model.addAttribute("counter", String.valueOf(varToSet));
//        }
//        return "counter";
//    }

    //    Ver4:
    @RequestMapping("/sessAtr")
    public String setCounter(Model model, @SessionAttribute(value = "counter", required = false) Integer counter) {

        Integer varToSet = 1;
        if (counter != null) {
            counter = counter+10;
            varToSet = counter + 1;
        }
        model.addAttribute("counter", varToSet);
        return "counter";
    }

    @RequestMapping("/sessAtr2")
    @ResponseBody
    public String session2(HttpSession ses) {
        int tmp = 1;
        if (ses.getAttribute("counter2")!= null){
            tmp = (int) ses.getAttribute("counter2")+1;
        }
        ses.setAttribute("counter2", tmp);
        return String.valueOf(tmp);
    }
}