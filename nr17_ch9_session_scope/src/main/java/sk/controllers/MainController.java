package sk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sk.services.LoggedUserManagementService;


@Controller
public class MainController {
    
    private final LoggedUserManagementService loggedUserManagementService;

    public MainController(LoggedUserManagementService loggedUserManagementService) {
        //autowired to find out if the user already logged in
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String home(
        //we get the logout request parameter if present
        @RequestParam(required = false) String logout,
        Model model
    ) {
        //if the logout parameter is present, we erase the username from the LoggedUserManagementService bean
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }
        
        //username is not null when someone logged in
        String username = loggedUserManagementService.getUsername();

        //redirect to login page
        if (username == null) {
            return "redirect:/";
        }

        //we send the username to the view
        model.addAttribute("username", username);
        return "main.html";
    }
}
