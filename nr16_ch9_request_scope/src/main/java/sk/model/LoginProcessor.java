package sk.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    
    private String username;
    private String password;

    public LoginProcessor() {
        System.out.println("bean LoginProcessor was created!");
    }

    public boolean login() {
        String username = this.username;
        String password = this.password;

        //check if credentials are correct
        return "natalie".equals(username) && "abc123".equals(password);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
