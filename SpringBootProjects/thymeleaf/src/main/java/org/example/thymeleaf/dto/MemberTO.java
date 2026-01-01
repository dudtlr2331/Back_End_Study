package org.example.thymeleaf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberTO {
    private int id;
    private String name;
    private int age;

    public int getId(){
        System.out.println("getId() 호출");
        return id;
    }

    public String getName(){
        System.out.println("getName() 호출");
        return name;
    }

    public int getAge(){
        System.out.println("getAge() 호출");
        return age;
    }

}
