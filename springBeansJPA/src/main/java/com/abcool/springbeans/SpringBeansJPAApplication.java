package com.abcool.springbeans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringBeansJPAApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBeansJPAApplication.class, args);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MyBeans.class);
        ctx.refresh();
        Person obj = ctx.getBean(Person.class);
        obj.setId(1);
        obj.setName("rohini");
        obj.setAge(29);
        obj.setAddress("pluto");
        System.out.println(obj);
    }
}
