package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ProjectConfig;

public class Main {
    public static void main(String[] args) {
        var contex = new AnnotationConfigApplicationContext(ProjectConfig.class);

        //Parrot parrot = contex.getBean(Parrot.class);
        Person person = contex.getBean(Person.class);
        
        //System.out.println("Parrot's name: " + parrot.getName());
        System.out.println("Person's name: " + person.getName());
        System.out.println("Person's parrot: " + person.getParrot());
    }
}