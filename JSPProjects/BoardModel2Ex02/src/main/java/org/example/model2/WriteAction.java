package org.example.model2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WriteAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("WriteAction");
    }
}
