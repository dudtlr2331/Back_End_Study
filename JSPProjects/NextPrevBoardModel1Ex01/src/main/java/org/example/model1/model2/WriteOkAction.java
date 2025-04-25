package org.example.model1.model2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model1.BoardDAO;
import org.example.model1.BoardTO;

public class WriteOkAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("WriteOkAction");

        BoardTO to = new BoardTO();

        to.setSubject(req.getParameter("subject"));
        to.setKind(req.getParameter("kind"));
        to.setWriter(req.getParameter("writer"));
        to.setMail("");
        if(!req.getParameter("mail1").equals("") && !req.getParameter("mail2").equals("")){
            to.setMail(req.getParameter("mail1") + "@" + req.getParameter("mail2"));
        }
        to.setPassword(req.getParameter("password"));
        to.setContent(req.getParameter("content"));

        to.setWip(req.getRemoteAddr());

        BoardDAO dao = new BoardDAO();
        int flag = dao.boardWriteOk(to);

        req.setAttribute( "flag", flag );
    }
}
