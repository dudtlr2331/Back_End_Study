package org.example.model2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormOkAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("FormOkAction");

        String data1 = request.getParameter("data1");
        System.out.println("data1: " + data1);


        //DAO 연결

        //jsp 페이지로 데이터 연결
        request.setAttribute("data1", data1);
    }
}
