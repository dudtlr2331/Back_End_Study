package org.example.web.model1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class View2Action {
    public void execute2(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("execute() 호출");
    }
}
