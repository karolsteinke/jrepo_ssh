package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import model.Comment;
import processors.CommentProcessor;

@Service
public class CommentService {
    
    //we need context ref here, as we need to call 'getBean' to get new instance every time
    @Autowired
    private ApplicationContext context;

    public void publishComment(Comment c) {
        //get new CommentProcessor (prototype bean) every time when method is called
        CommentProcessor p = context.getBean(CommentProcessor.class);

        p.setComment(c);
        p.processComment();
        System.out.println("Comment is now: " + p.getComment().getText());
    }
}
