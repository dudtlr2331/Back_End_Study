package org.example.web.model2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class View2Action implements Action{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("View2Action execute()");
    }
}
