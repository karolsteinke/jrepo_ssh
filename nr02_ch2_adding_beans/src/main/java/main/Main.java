package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ProjectConfig;

public class Main {
    public static void main(String[] args) {
        
        //creating Spring context
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        
        //getting beans which were created in config file (these are in the context)
        Parrot pa = context.getBean("parrot1", Parrot.class);
        Parrot pe = context.getBean("miki", Parrot.class);
        String s = context.getBean(String.class);
        Integer n = context.getBean(Integer.class);

        System.out.println(pa.getName());
        System.out.println(pe.getName());
        System.out.println(s);
        System.out.println(n);
    }
}