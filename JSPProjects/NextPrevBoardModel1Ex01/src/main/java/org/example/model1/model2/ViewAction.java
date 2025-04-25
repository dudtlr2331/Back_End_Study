package org.example.model1.model2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model1.BoardDAO;
import org.example.model1.BoardTO;

public class ViewAction implements Action {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("ViewAction");

        BoardTO to = new BoardTO();
        to.setSeq(req.getParameter("seq"));

        BoardDAO dao = new BoardDAO();
        to = dao.boardView(to);

        req.setAttribute("to", to);
    }
}
