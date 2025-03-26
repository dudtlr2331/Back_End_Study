package com.exam;

import com.data.Student;

public class MainEx03 {
    public static void main(String[] args) {
        Student student = new Student("1001", "홍길동");

        System.out.println(student.getHakbun());
        System.out.println(student.getName());
    }
}
