package com.abcool.springbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Person {
    private int id,age;
    private String name,address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "id =" + this.id + "name =" + this.name + "age =" + this.age + "age =" + this.age;
    }
}
