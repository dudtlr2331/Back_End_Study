package org.example.model2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Action {
    void execute(HttpServletRequest req, HttpServletResponse resp);
}
