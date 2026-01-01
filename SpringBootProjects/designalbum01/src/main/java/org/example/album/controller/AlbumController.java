package org.example.album.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.album.dao.AlbumCommentDAO;
import org.example.album.dao.BoardDAO;
import org.example.album.dto.AlbumCommentTO;
import org.example.album.dto.BoardTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@Controller
public class AlbumController {

	@Autowired
	private BoardDAO dao;

	@Autowired
	private AlbumCommentDAO albumCommentDAO;

	@ResponseBody
	@GetMapping( "/image/{imagename}" )
	public Resource showImage(@PathVariable String imagename ) throws MalformedURLException {
		return new UrlResource( "file:" + "C:/git/Back_End_Study/SpringBootProjects/designalbum01/src/main/resources/static/upload" + imagename );
	}

	@RequestMapping( "/" )
	public String index(HttpServletRequest request, Model model) {
		return "redirect:/list.do";
	}

	@RequestMapping( "/list.do" )
	public String list(HttpServletRequest request, Model model) {
		List<BoardTO> lists = dao.boardList();
		model.addAttribute("lists", lists);
		return "board_list1";
	}

	@RequestMapping( "/view.do" )
	public String view(String seq, Model model) {
		BoardTO bto = new BoardTO();
		bto.setSeq(seq);

		bto = dao.boardView( bto );

		AlbumCommentTO cto = new AlbumCommentTO();
		cto.setPseq(seq);

		model.addAttribute("to", bto);
		model.addAttribute("lists", albumCommentDAO.list(cto));
		return "board_view1";
	}

	@RequestMapping( "/write.do" )
	public String write(HttpServletRequest request, Model model) {
		return "board_write1";
	}

	@RequestMapping( "/write_ok.do" )
	public String write_ok(HttpServletRequest request, Model model, MultipartFile upload) {
		BoardTO to = new BoardTO();
		to.setSeq(request.getParameter("seq"));
		to.setSubject(request.getParameter("subject"));
		to.setWriter(request.getParameter("writer"));
		to.setPassword(request.getParameter("password"));
		to.setContent(request.getParameter("content"));
		to.setLatitude(request.getParameter("latitude"));
		to.setLongitude(request.getParameter("longitude"));
		to.setMail(request.getParameter("mail1") + "@" + request.getParameter("mail2"));
		to.setWip( request.getRemoteAddr() );

		//Image DAO // MultipartFile upload
		String fullImageName = upload.getOriginalFilename();
		String imageName = fullImageName.substring( 0, fullImageName.lastIndexOf("." ) );
		String imageExtension = fullImageName.substring( fullImageName.lastIndexOf(".") );
		String saveImageName = imageName + "_" + System.nanoTime() + imageExtension;

		try {
			upload.transferTo( new File( "C:/git/Back_End_Study/SpringBootProjects/designalbum01/src/main/resources/static/upload", saveImageName ) );
			to.setImagename(saveImageName);
			to.setImagesize(upload.getSize());
		} catch (IOException e) {
			System.out.println( "[에러] : " + e.getMessage() );
		}


		model.addAttribute("flag", dao.boardWriteOk(to));
		return "board_write1_ok";
	}

	@RequestMapping( "/modify.do" )
	public String modify(HttpServletRequest request, Model model) {
		BoardTO to = new BoardTO();
		to.setSeq(request.getParameter("seq"));

		model.addAttribute("to", dao.boardModify(to));
		return "board_modify1";
	}

	@RequestMapping( "/modify_ok.do" )
	public String modify_ok(HttpServletRequest request, Model model) {
		BoardTO to = new BoardTO();
		to.setSeq(request.getParameter("seq"));
		to.setSubject(request.getParameter("subject"));
		to.setMail(request.getParameter("mail1") + "@" + request.getParameter("mail2"));
		to.setContent(request.getParameter("content"));
		to.setPassword(request.getParameter("password"));

		model.addAttribute("seq", request.getParameter( "seq" ) );
		model.addAttribute("flag", dao.boardModifyOk(to));
		return "board_modify1_ok";
	}

	@RequestMapping( "/delete.do" )
	public String delete(HttpServletRequest request, Model model) {
		BoardTO to = new BoardTO();
		to.setSeq(request.getParameter("seq"));

		model.addAttribute("to", dao.boardDelete(to));
		return "board_delete1";
	}

	@RequestMapping( "/delete_ok.do" )
	public String delete_ok(HttpServletRequest request, Model model) {
		BoardTO to = new BoardTO();
		to.setSeq(request.getParameter("seq"));
		to.setSubject(request.getParameter("subject"));
		to.setWriter(request.getParameter("writer"));
		to.setPassword(request.getParameter("password"));

		model.addAttribute("flag", dao.boardDeleteOk(to));
		return "board_delete1_ok";
	}


	@RequestMapping("/comment_write_ok")
	public String comment_write_ok(HttpServletRequest request, Model model) {
		AlbumCommentTO to = new AlbumCommentTO();
		to.setPseq(request.getParameter("pseq"));
		to.setWriter(request.getParameter("cwriter"));
		to.setPassword(request.getParameter("cpassword"));
		to.setContent(request.getParameter("ccontent"));

		model.addAttribute("flag", albumCommentDAO.albumCommentWriteOK(to));
//		return "redirect:/view.do?seq=" + request.getParameter("pseq");
		model.addAttribute("pseq", request.getParameter( "pseq" ) );
		return "comment_write_ok";
	}
}
