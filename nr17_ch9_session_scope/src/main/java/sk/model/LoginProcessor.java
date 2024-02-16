package sk.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import sk.services.LoggedUserManagementService;

@Component
@RequestScope
//it has request scope - stays active for a one login request
public class LoginProcessor {
    
    private final LoggedUserManagementService loggedUserManagementService;
    private String username;
    private String password;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService) {
        //autowire management service to take care of the authentication logic
        //it has session scope - stays active for session time for each client
        this.loggedUserManagementService = loggedUserManagementService;
        
        System.out.println("bean LoginProcessor was created!");
    }

    public boolean login() {
        
        boolean loginResult = false;

        //check if credentials are correct
        if (
            "natalie".equals(this.username) &&
            "abc123".equals(this.password)
        ) {
            loginResult = true;
            loggedUserManagementService.setUsername(username);
        }
        
        return loginResult;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
