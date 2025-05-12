package org.example.upload.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping( "/form.do" )
    public String form() {
        return "form";
    }

    @RequestMapping( "/form_ok1.do" )
    public String form_ok(@RequestParam MultipartFile upload, HttpServletRequest request) {
        if ( !upload.isEmpty() ) {
            System.out.println( "성공" );

            // 데이터 정보
            System.out.println( "data " + request.getParameter( "data" ) );

            // 파일 정보
            System.out.println( upload.getSize() );
            System.out.println( upload.getName() );
            System.out.println( upload.getOriginalFilename() );
            System.out.println( upload.getContentType() );

            try {
                // 원하는 저장위치 변경해서 저장
                //upload.transferTo( new File( "c:/java/upload", upload.getOriginalFilename() ) );

                // 중복파일명 업로드시 .. 중복 제거
                String fileName = upload.getOriginalFilename().substring( 0, upload.getOriginalFilename().indexOf( "." ) );
                String fileExtension = upload.getOriginalFilename().substring( upload.getOriginalFilename().indexOf( "." ) );

                upload.transferTo( new File( "C:/git/Back_End_Study/java/upload", fileName + "_" + System.currentTimeMillis() + "." + fileExtension ) );
            } catch (IOException e) {
                System.out.println( "[에러] " + e.getMessage() );
            }

        } else {
            System.out.println( "실패" );
        }
        return "form_ok";
    }

    @RequestMapping( "/form_ok2.do" )
    public String form_ok(@RequestParam MultipartFile upload1, @RequestParam MultipartFile upload2) {
        if (!upload1.isEmpty() && !upload2.isEmpty()) {

            try {
                upload1.transferTo(new File("C:/git/Back_End_Study/java/upload", upload1.getOriginalFilename()));
                upload2.transferTo(new File("C:/git/Back_End_Study/java/upload", upload2.getOriginalFilename()));
            } catch (IOException e) {
                System.out.println( "[에러] " + e.getMessage() );
            }
        }
        return "form_ok";
    }
}