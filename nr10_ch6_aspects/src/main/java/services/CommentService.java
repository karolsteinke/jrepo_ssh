package services;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import model.Comment;

@Service
public class CommentService {
    
    //using Java Logging API instead of System.out
    //logger name will be class name
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public void publishComment(Comment c) {
        logger.info("Publishing comment: " + c.getText());
    }
}
