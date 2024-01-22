package services;

import proxies.CommentNotificationProxy;
import repositories.CommentRepository;
import model.Comment;

public class CommentService {
    
    //CommentService uses interfaces, which can be implemented in different ways
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    //constructor
    public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment (Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}