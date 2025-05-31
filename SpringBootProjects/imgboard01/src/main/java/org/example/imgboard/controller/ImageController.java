package org.example.imgboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.imgboard.dao.ImageDAO;
import org.example.imgboard.dto.ImageTO;
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
import java.net.MalformedURLException;
import java.util.List;


@Controller
public class ImageController {

    @Autowired
    private ImageDAO imageDao;

    @ResponseBody
    @GetMapping( "/image/{imagename}" )
    public Resource showImage(@PathVariable String imagename ) throws MalformedURLException {
        return new UrlResource( "file:" + "C:/git/Back_End_Study/SpringBootProjects/imgboard01/src/main/resources/static/upload" + imagename );
    }

    @RequestMapping("/list.do")
    public String list(HttpServletRequest request, Model model) {
        List<ImageTO> lists = imageDao.boardList();

        model.addAttribute("lists", lists);
        return "board_list1";
    }

    @RequestMapping("/view.do")
    public String view(HttpServletRequest request, Model model) {
        ImageTO to = new ImageTO();
        to.setSeq(request.getParameter("seq"));

        model.addAttribute("to", imageDao.boardView(to));
        return "board_view1";
    }

    @RequestMapping("/write.do")
    public String write(HttpServletRequest request, Model model) {
        return "board_write1";
    }

    @RequestMapping("/write_ok.do")
    public String write_ok(MultipartFile upload, HttpServletRequest request, Model model) {
        ImageTO to = new ImageTO();
        to.setSubject( request.getParameter( "subject" ) );
        to.setWriter( request.getParameter( "writer" ) );
        to.setMail( request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" ) );
        to.setPassword( request.getParameter( "password" ) );
        to.setContent( request.getParameter( "content" ) );
        to.setWip( request.getRemoteAddr() );

        String fullFileName = upload.getOriginalFilename();
        String fileName = fullFileName.substring(0, fullFileName.lastIndexOf("."));
        String fileExtension = fullFileName.substring(fullFileName.lastIndexOf("."));

        String saveFileName = fileName + "_" + System.nanoTime() + fileExtension;

        try {
            upload.transferTo( new File("C:/git/Back_End_Study/SpringBootProjects/imgboard01/src/main/resources/static/upload", saveFileName) );
            to.setImagename( saveFileName );
            to.setImagesize(upload.getSize());
        } catch (Exception e) {
            System.out.println("[에러] " + e.getMessage());
        }

        model.addAttribute( "flag", imageDao.imageWriteOk( to ));
        return "board_write1_ok";
    }

    @RequestMapping("/delete.do")
    public String delete(HttpServletRequest request, Model model) {
        ImageTO to = new ImageTO();
        to.setSeq(request.getParameter("seq"));

        model.addAttribute("to", imageDao.boardDelete(to));
        return "board_delete1";
    }

    @RequestMapping("/delete_ok.do")
    public String delete_ok(HttpServletRequest request, Model model) {
        ImageTO to = new ImageTO();
        to.setSeq(request.getParameter("seq"));
        to.setPassword(request.getParameter("password"));

        model.addAttribute("flag", imageDao.boardDeleteOk(to));
        return "board_delete1_ok";
    }

    @RequestMapping("/modify.do")
    public String modify(HttpServletRequest request, Model model) {
        ImageTO to = new ImageTO();
        to.setSeq(request.getParameter("seq"));

        model.addAttribute("to", imageDao.boardModify(to));
        return "board_modify1";
    }

    @RequestMapping("/modify_ok.do")
    public String modify_ok(HttpServletRequest request, Model model) {
        ImageTO to = new ImageTO();
        to.setSubject(request.getParameter("subject"));
        to.setMail(request.getParameter("mail1") + "@" + request.getParameter("mail2"));
        to.setContent(request.getParameter("content"));
        to.setSeq(request.getParameter("seq"));
        to.setPassword(request.getParameter("password"));

        model.addAttribute("flag", imageDao.boardModifyOk(to));
        model.addAttribute("seq", to.getSeq());
        return "board_modify1_ok";
    }

}
