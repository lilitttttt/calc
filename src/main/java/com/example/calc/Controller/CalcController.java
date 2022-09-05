package com.example.calc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {

    @GetMapping("/")
    public String Main(){
        return "main";
    }

    @GetMapping("/getCalc")
    public String Get(){
        return "getCalc";
    }
    @GetMapping("/postCalc")
    public String Post(){
        return "postCalc";
    }

    @GetMapping("/get")
    public String GetController ( @RequestParam(value = "a", required = false) int a,
                                  @RequestParam(value = "b", required = false) int b,
                                  @RequestParam(value = "action", required = false) String action, Model model){
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("action", action);

        double result;
        switch (action) {
            case "summa":
                result = a + b;
                break;
            case "sub":
                result = a - b;
                break;
            case "multi":
                result = a * b;
                break;
            case "div":
                result = a / b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("result", result);
        return "getCalc";
    }

    @PostMapping("/post")
    public String PostController(@RequestParam int a, @RequestParam int b,
                                 @RequestParam String action, Model model) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("action", action);

        double result;

        switch (action) {
            case "summa":
                result = a + b;
                break;
            case "sub":
                result = a - b;
                break;
            case "multi":
                result = a * b;
                break;
            case "div":
                result = a / b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("result", result);

        return "postCalc";
    }

}
