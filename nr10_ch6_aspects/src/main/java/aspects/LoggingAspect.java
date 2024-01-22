package aspects;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

//aspect class
@Aspect
public class LoggingAspect {
    
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    //method to apply aspect logic
    //we specify join point (method to intercept) with AspectJ pointcut language
    @Around("execution(* services.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint)  throws Throwable {
        
        logger.info("Method will be execute");
        
        //delegate the call to the actual method
        joinPoint.proceed();
        
        logger.info("Method executed");
    }
}
