package sk.nr12_ch7_first_web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    
    //controller contains methods which are often called actions
    //actions are methods associated with specific HTTP requests
    //accesing the path (/home) is associated with RequestMapping request
    @RequestMapping("/home")
    public String home() {
        return "home.html";
    }
}
