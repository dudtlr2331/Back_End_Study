package org.example.model2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("FormAction");
    }
}
