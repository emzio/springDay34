package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MultiplyController {
    @RequestMapping("/multiply/{size}")
    public String multiply(Model model, @PathVariable int size){
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            list.add(i);
        }
        model.addAttribute("size", list);
        return "multiply";
    }

    @RequestMapping("/paramMultiply/{rows}/{cols}")
    public String multiply(Model model, @PathVariable int rows, @PathVariable int cols){
        model.addAttribute("rows", rows);
        model.addAttribute("cols",cols);
        return "multiplyCols";

    }

}
