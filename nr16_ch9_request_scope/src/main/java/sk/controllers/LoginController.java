package sk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sk.model.LoginProcessor;

import org.springframework.ui.Model;

@Controller
public class LoginController {

    private final LoginProcessor loginProcessor;

    //and no ProjectConfig file whatsoever?
    //also: it seems like it gets reference to a bean only once but in fact it directs to a proper bean every time when new bean is being created after http request
    //Anwser: What Spring does is to keep a reference of a proxy of the LoginProcessor inside the LoginController singleton. The proxy manages the LoginProcessor instances which will be mapped per request.
    //por. nr09_ch5 where we also get new bean reference with every call (using prototype scope)
    public LoginController(LoginProcessor loginProcessor) {
        //auto-wire
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(
        @RequestParam String username,
        @RequestParam String password,
        Model model
    ) {
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean isLogged = loginProcessor.login();

        if (isLogged) {
            model.addAttribute("message", "You are now logged in");
        } 
        else {
            model.addAttribute("message", "Login failed!");
        }

        return "login.html";
    }
}
