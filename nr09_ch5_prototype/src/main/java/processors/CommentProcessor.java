package processors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

import model.Comment;
import repositories.CommentRepository;

//it's prototype, because it needs to be mutable class (comment field will be modified)
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentProcessor {
    
    @Autowired
    private CommentRepository commentRepository;
    private Comment comment;

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Comment getComment() {
        return this.comment;
    }

    public void processComment() {
        //changing the comment atribute
    }
}
