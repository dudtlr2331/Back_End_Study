package org.example.web.model1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.web.model2.Action;

public class View1Action{
    public void execute1(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("execute() 호출");
    }
}
