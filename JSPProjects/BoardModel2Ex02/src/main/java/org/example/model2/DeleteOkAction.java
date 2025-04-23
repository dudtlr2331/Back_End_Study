package org.example.model2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model1.BoardDAO;
import org.example.model1.BoardTO;

public class DeleteOkAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("DeleteOkAction");

        BoardTO to = new BoardTO();
        to.setSeq( req.getParameter( "seq" ) );
        to.setPassword( req.getParameter( "password" ) );

        BoardDAO dao = new BoardDAO();
        int flag = dao.boardDeleteOk( to );

        req.setAttribute("flag", flag);
    }
}
