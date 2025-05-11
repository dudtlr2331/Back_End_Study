package org.example.board.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.board.model.BoardDAO1;
import org.example.board.model.BoardDAO2;
import org.example.board.model.BoardListTO;
import org.example.board.model.BoardTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class BoardController {

    @Autowired
    private BoardDAO1 dao;
//    private BoardDAO2 dao;

    @RequestMapping( "/list.do" )
    public ModelAndView list(HttpServletRequest request) {
        System.out.println( "list() 호출" );

        BoardListTO listTO = new BoardListTO();
        listTO.setCpage( request.getParameter( "cpage" ) == null ? 1 : Integer.parseInt( request.getParameter( "cpage" ) ) );

        listTO = dao.boardList( listTO );

        ModelAndView modelAndView = new ModelAndView("board_list1");
        modelAndView.addObject( "listto", listTO );

        return modelAndView;
    }

    @RequestMapping("/write.do")
    public ModelAndView write(HttpServletRequest req) {
        System.out.println("write() 호출");

        int cpage = 1;
        if (req.getParameter("cpage") != null && !req.getParameter("cpage").equals("")) {
            cpage = Integer.parseInt(req.getParameter("cpage"));
        }

        ModelAndView modelAndView = new ModelAndView("board_write1");
        modelAndView.addObject("cpage", cpage);

        return modelAndView;
    }

    @RequestMapping("/write_ok.do")
    public ModelAndView write_ok(HttpServletRequest req) {
        System.out.println("write_ok() 호출");

        BoardTO to = new BoardTO();
        to.setSubject( req.getParameter( "subject" ) );
        to.setWriter( req.getParameter( "writer" ) );

        to.setMail( "" );
        if ( !req.getParameter( "mail1" ).equals( "" ) && !req.getParameter( "mail2" ).equals( "" ) ) {
            to.setMail( req.getParameter( "mail1" ) + "@" + req.getParameter( "mail2" ) );
        }

        to.setPassword( req.getParameter( "password" ) );
        to.setContent( req.getParameter( "content" ) );

        to.setWip( req.getRemoteAddr() );

        int flag = dao.boardWriteOk(to);

        ModelAndView modelAndView = new ModelAndView("board_write1_ok");
        modelAndView.addObject("flag", flag);

        return modelAndView;
    }

    @RequestMapping("/view.do")
    public ModelAndView view(HttpServletRequest req) {
        System.out.println("view() 호출");

        String seq = req.getParameter("seq");
        String cpage = req.getParameter("cpage");

        BoardTO to = new BoardTO();
        to.setSeq(seq);
        to = dao.boardView(to);

        ModelAndView modelAndView = new ModelAndView("board_view1");
        modelAndView.addObject("to", to);
        modelAndView.addObject("cpage", cpage);

        return modelAndView;
    }

    @RequestMapping("/modify.do")
    public ModelAndView modify(HttpServletRequest req) {
        System.out.println("modify() 호출");

        String cpage = req.getParameter("cpage");

        BoardTO to = new BoardTO();
        to.setSeq( req.getParameter( "seq" ) );
        to = dao.boardModify( to );

        ModelAndView modelAndView = new ModelAndView("board_modify1");
        modelAndView.addObject("to", to);
        modelAndView.addObject("cpage", cpage);

        return modelAndView;
    }

    @RequestMapping("/modify_ok.do")
    public ModelAndView modify_ok(HttpServletRequest req) {
        System.out.println("modify_ok() 호출");

        String cpage = req.getParameter("cpage");

        BoardTO to = new BoardTO();
        to.setSeq( req.getParameter( "seq" ) );
        to.setSubject( req.getParameter( "subject" ) );
        to.setMail( "" );
        if ( !req.getParameter( "mail1" ).equals( "" ) && !req.getParameter( "mail2" ).equals( "" ) ) {
            to.setMail( req.getParameter( "mail1" ) + "@" + req.getParameter( "mail2" ) );
        }
        to.setPassword( req.getParameter( "password" ) );
        to.setContent( req.getParameter( "content" ) );

        int flag = dao.boardModifyOk( to );

        ModelAndView modelAndView = new ModelAndView("board_modify1_ok");
        modelAndView.addObject("seq", to.getSeq());
        modelAndView.addObject("flag", flag);
        modelAndView.addObject("cpage", cpage);

        return modelAndView;
    }

    @RequestMapping("/delete.do")
    public ModelAndView delete(HttpServletRequest req) {
        System.out.println("delete() 호출");

        String cpage = req.getParameter("cpage");

        BoardTO to = new BoardTO();
        to.setSeq( req.getParameter( "seq" ) );

        to = dao.boardDelete( to );

        ModelAndView modelAndView = new ModelAndView("board_delete1");
        modelAndView.addObject("to", to);
        modelAndView.addObject("cpage", cpage);

        return modelAndView;
    }

    @RequestMapping("/delete_ok.do")
    public ModelAndView delete_ok(HttpServletRequest req) {
        System.out.println("delete_ok() 호출");

        BoardTO to = new BoardTO();
        to.setSeq( req.getParameter( "seq" ) );
        to.setPassword( req.getParameter( "password" ) );
        System.out.println( to.getSeq() );
        System.out.println( to.getPassword() );

        int flag = dao.boardDeleteOk( to );

        ModelAndView modelAndView = new ModelAndView("board_delete1_ok");
        modelAndView.addObject("flag", flag);

        return modelAndView;
    }
}
