package org.example.board.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.board.dao.BoardDAO;
import org.example.board.dto.BoardTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardDAO boardDAO;

    @RequestMapping( "/" )
    public String index(HttpServletRequest request, Model model) {
        return "redirect:/list.do";
    }

    @RequestMapping( "/list.do" )
    public String list(HttpServletRequest request, Model model) {
        List<BoardTO> lists = boardDAO.boardList();
        model.addAttribute("lists", lists);
        return "board_list1";
    }

    @RequestMapping( "/view.do" )
    public String view(HttpServletRequest request, Model model) {
        BoardTO to = new BoardTO();
        to.setSeq( request.getParameter( "seq" ) );

        model.addAttribute("to", boardDAO.boardView( to ) );

        return "board_view1";
    }

    @RequestMapping( "/write.do" )
    public String write(HttpServletRequest request, Model model) {
        return "board_write1";
    }

    @RequestMapping( "/write_ok.do" )
    public String write_ok(HttpServletRequest request, Model model) {
        BoardTO to = new BoardTO();
        to.setSubject( request.getParameter( "subject" ) );
        to.setWriter( request.getParameter( "writer" ) );
        to.setMail( request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" ) );
        to.setPassword( request.getParameter( "password" ) );
        to.setContent( request.getParameter( "content" ) );
        to.setWip( request.getRemoteAddr() );

        int flag = boardDAO.boardWriteOk( to );
        model.addAttribute( "flag", flag );

        return "board_write1_ok";
    }

    @RequestMapping("/modify.do")
    public String modify(HttpServletRequest request, Model model) {
        BoardTO to = new BoardTO();
        to.setSeq( request.getParameter( "seq" ) );

        model.addAttribute("to", boardDAO.boardModify( to ) );
        return "board_modify1";
    }

    @RequestMapping("/modify_ok.do")
    public String modify_ok(HttpServletRequest request, Model model) {
        BoardTO to = new BoardTO();
        to.setSubject( request.getParameter( "subject" ) );
        to.setMail( request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" ) );
        to.setContent( request.getParameter( "content" ) );
        to.setSeq( request.getParameter( "seq" ) );
        to.setPassword( request.getParameter( "password" ) );

        model.addAttribute("seq", request.getParameter( "seq" ) );
        model.addAttribute( "flag", boardDAO.boardModifyOk( to ) );
        return "board_modify1_ok";
    }

    @RequestMapping("/delete.do")
    public String delete(HttpServletRequest request, Model model) {
        BoardTO to = new BoardTO();
        to.setSeq( request.getParameter( "seq" ) );

        model.addAttribute("to", boardDAO.boardDelete(to));
        return "board_delete1";
    }

    @RequestMapping("/delete_ok.do")
    public String delete_ok(HttpServletRequest request, Model model) {
        BoardTO to = new BoardTO();
        to.setSeq( request.getParameter( "seq" ) );
        to.setPassword( request.getParameter( "password" ) );

        model.addAttribute( "flag", boardDAO.boardDeleteOk( to ));
        return "board_delete1_ok";
    }
}
