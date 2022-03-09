package com.lee.bean;

public class Hello {
    String name;
    String statement;
    Integer age;

    public Hello(String name, String statement, Integer age) {
        this.name = name;
        this.statement = statement;
        this.age = age;
    }

    public void say() {
        System.out.println(name + " " + statement + age);
    }

}
