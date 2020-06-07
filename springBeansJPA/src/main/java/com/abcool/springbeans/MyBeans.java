package com.abcool.springbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeans {

    @Bean
    public Person getPerson(){
        return new Person();
    }

}
