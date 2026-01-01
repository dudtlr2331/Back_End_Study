package org.example.upload.controller;

import jakarta.servlet.http.HttpServletRequest;
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

@Controller
public class UploadController {

    @RequestMapping( "/upload.do" )
    public String upload() {
        return "upload";
    }

    @RequestMapping( "/upload_ok.do" )
    public String upload_ok(MultipartFile upload, Model model) {

        String fullFileName = upload.getOriginalFilename();

        String saveFileName = null;

        if ( !upload.isEmpty() ) {

            // 중복 파일이름 변경 정책 설정
            String fileName = fullFileName.substring( 0, fullFileName.lastIndexOf("." ) );
            String fileExtension = fullFileName.substring( fullFileName.lastIndexOf(".") );

            //System.out.println( fileName );
            //System.out.println( fileExtension );

            saveFileName = fileName + "_" + System.nanoTime() + fileExtension;

            try {
                //upload.transferTo( new File( "C:/Java/upload", saveFileName ) );
                upload.transferTo( new File( "C:/git/Back_End_Study/SpringBootProjects/upload02/src/main/resources/static/upload", saveFileName ) );
            } catch (IOException e) {
                System.out.println( "[에러] : " + e.getMessage() );
            }
        }

        model.addAttribute("filename", saveFileName );

        //return "upload_ok";
        return "redirect:/view.do?filename=" + saveFileName;
    }

    @RequestMapping("/view.do")
    public String view(HttpServletRequest request, Model model) {
        model.addAttribute("filename", request.getParameter("filename" ) );
        return "view";
    }

    //
    @ResponseBody
    @GetMapping( "/image/{filename}" )
    public Resource showFile(@PathVariable String filename ) throws MalformedURLException {
        return new UrlResource( "file:" + "C:/git/Back_End_Study/SpringBootProjects/upload02/src/main/resources/static/upload" + filename );
    }
}
