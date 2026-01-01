package com.example.pds.controller;

import com.example.pds.model.BoardDAO;
import com.example.pds.model.BoardTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class PdsController {


	@Autowired private BoardDAO dao;

	@RequestMapping( "/list.do" )
	public ModelAndView list(HttpServletRequest request) {
		System.out.println( "list() 호출" );

		ArrayList<BoardTO> lists = dao.boardList();

		ModelAndView modelAndView = new ModelAndView("board_list1");
		modelAndView.addObject( "lists", lists );

		return modelAndView;
	}

	@RequestMapping( "/write.do" )
	public ModelAndView write(HttpServletRequest request) {
		System.out.println( "write() 호출" );

		ModelAndView modelAndView = new ModelAndView("board_write1");

		return modelAndView;
	}

	@RequestMapping( "/write_ok.do" )
	public ModelAndView write_ok(@RequestParam MultipartFile upload,  HttpServletRequest request) {
		System.out.println( "write_ok() 호출" );

		BoardTO to = new BoardTO();
		to.setSubject( request.getParameter( "subject" ) );
		to.setKind(request.getParameter( "kind" ) );
		to.setWriter( request.getParameter( "writer" ) );

		to.setMail( "" );
		if ( !request.getParameter( "mail1" ).equals( "" ) && !request.getParameter( "mail2" ).equals( "" ) ) {
			to.setMail( request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" ) );
		}

		to.setPassword( request.getParameter( "password" ) );
		to.setContent( request.getParameter( "content" ) );

		to.setWip( request.getRemoteAddr() );

		if ( !upload.isEmpty() ) {
			// 업로드 되면
			to.setFileName( upload.getOriginalFilename() );
			to.setFileSize( (int)upload.getSize() );

			try {
				upload.transferTo( new File( "c:/git/Back_End_Study/java/upload", upload.getOriginalFilename() ) );
			} catch (IOException e) {
				System.out.println( "[에러] " + e.getMessage() );
			}

		} else {
			// 업로드가 안되면
			to.setFileName( "" );
			to.setFileSize( 0 );
		}

		int flag = dao.boardWriteOk( to );

		ModelAndView modelAndView = new ModelAndView("board_write1_ok");
		modelAndView.addObject( "flag", flag );

		return modelAndView;
	}

	@RequestMapping( "/view.do" )
	public ModelAndView view(HttpServletRequest request) {
		System.out.println( "view() 호출" );

		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );

		to = dao.boardView( to );

		ModelAndView modelAndView = new ModelAndView( "board_view1" );
		modelAndView.addObject( "to", to );
		return modelAndView;
	}

	@RequestMapping( "/delete.do" )
	public ModelAndView delete(HttpServletRequest request) {
		System.out.println( "delete() 호출" );

		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );

		to = dao.boardDelete( to );

		ModelAndView modelAndView = new ModelAndView( "board_delete1" );
		modelAndView.addObject( "to", to );
		return modelAndView;
	}

	@RequestMapping( "/delete_ok.do" )
	public ModelAndView delete_ok(HttpServletRequest request) {
		System.out.println( "delete_ok() 호출" );

		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		to.setPassword( request.getParameter( "password" ) );

		int flag = dao.boardDeleteOk( to );

		ModelAndView modelAndView = new ModelAndView( "board_delete1_ok" );
		modelAndView.addObject( "flag", flag );
		return modelAndView;
	}

	@RequestMapping( "/modify.do" )
	public ModelAndView modify(HttpServletRequest request) {
		System.out.println( "modify() 호출" );

		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );

		to = dao.boardModify( to );

		ModelAndView modelAndView = new ModelAndView( "board_modify1" );
		modelAndView.addObject( "to", to );
		return modelAndView;
	}

	@RequestMapping( "/modify_ok.do" )
	public ModelAndView modify_ok(@RequestParam MultipartFile upload, HttpServletRequest request) {
		System.out.println( "modify_ok() 호출" );

		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		to.setKind(request.getParameter("kind" ) );
		to.setSubject( request.getParameter( "subject" ) );
		to.setMail( "" );
		if ( !request.getParameter( "mail1" ).equals( "" ) && !request.getParameter( "mail2" ).equals( "" ) ) {
			to.setMail( request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" ) );
		}
		to.setPassword( request.getParameter( "password" ) );
		to.setContent( request.getParameter( "content" ) );

		if ( !upload.isEmpty() ) {
			// 업로드 되면
			to.setFileName( upload.getOriginalFilename() );
			to.setFileSize( (int)upload.getSize() );

			try {
				upload.transferTo( new File( "c:/git/Back_End_Study/java/upload", upload.getOriginalFilename() ) );
			} catch (IOException e) {
				System.out.println( "[에러] " + e.getMessage() );
			}

		} else {
			// 업로드가 안되면
			to.setFileName( "" );
			to.setFileSize( 0 );
		}

		int flag = dao.boardModifyOk( to );

		ModelAndView modelAndView = new ModelAndView( "board_modify1_ok" );
		modelAndView.addObject( "seq", to.getSeq() );
		modelAndView.addObject( "flag", flag );
		return modelAndView;
	}
}
