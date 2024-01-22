package aspects;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import model.Comment;

//aspect class
@Aspect
public class LoggingAspect {
    
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    //method to apply aspect logic
    @Around("execution(* services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint)  throws Throwable {
        
        String methodName = joinPoint.getSignature().getName();
        Object [] args = joinPoint.getArgs();

        logger.info("Method " + methodName + " with parameters " + Arrays.asList(args) + " will execute");
        
        //example where we alter method parameters and even returned result
        Comment comment = new Comment();
        comment.setText("Some other text");
        Object [] newArgs = {comment};
        Object returnedByMethod = joinPoint.proceed(newArgs);
        
        logger.info("Method executed and returned " + returnedByMethod);

        return "FAILED";
    }
}
