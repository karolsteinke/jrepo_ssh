package services;

import proxies.CommentNotificationProxy;
import repositories.CommentRepository;
import org.springframework.stereotype.Component;
import model.Comment;

@Component
public class CommentService {
    
    //CommentService uses interfaces, which can be implemented in different ways
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    //with only one constructor, no need for @Autowired adnotation
    public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment (Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}