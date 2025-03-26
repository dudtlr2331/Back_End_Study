package com.data;

public class Student {
    private String hakbun;
    private String name;

    public Student() {
        System.out.println("Hello Student");
    }

    public Student(String hakbun, String name) {
        this.hakbun = hakbun;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHakbun() {
        return hakbun;
    }

    public void setHakbun(String hakbun) {
        this.hakbun = hakbun;
    }
}
