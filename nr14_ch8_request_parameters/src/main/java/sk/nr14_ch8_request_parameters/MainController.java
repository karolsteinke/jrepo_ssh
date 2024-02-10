package sk.nr14_ch8_request_parameters;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    
    @RequestMapping("/home")
    //parameters 'name' and 'color' will be received via the URI
    //Controller send them to the view via the Model
    public String home(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String color,
            Model page) {
        page.addAttribute("username", name);
        page.addAttribute("color", color);
        return "home.html";
    }
}
