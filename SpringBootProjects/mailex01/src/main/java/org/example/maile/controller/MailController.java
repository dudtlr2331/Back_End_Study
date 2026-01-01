package org.example.maile.controller;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;

@Controller
public class MailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping("/mail.do")
    public String mail(){

//        System.out.println("JavaMailSender :" + javaMailSender);

        return "mail";
    }

    @RequestMapping("/mail_ok.do")
    public String mail_ok(){

        // 보낼 메일에 대한 정보
        String toEmail = "dudtlr2332@gmail.com";
        String toName = "테스트 이름";
        String subject = "테스트 제목";
        String content = "태스트 내용<img src=/>";

        this.sendSimpleMail(toEmail, toName, subject, content);
//        this.sendMimeMessage(toEmail, toName, subject, content);

        return "mail_ok";
    }

    public void sendSimpleMail(String toEmail, String toName, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(content);
        message.setSentDate(new java.util.Date());
        
        javaMailSender.send(message);

        System.out.println("메일 전송 완료");
    }

    public void sendMimeMessage(String toEmail, String toName, String subject, String content) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail, toName, "utf-8"));
            message.setSubject(subject, "utf-8");
            message.setText(content, "utf-8", "html");
            message.setSentDate(new java.util.Date());

            javaMailSender.send(message);

            System.out.println(" 메일 전송 완료");
        } catch (MessagingException e) {
            System.out.println("[에러] " + e.getMessage());
        } catch (UnsupportedEncodingException e) {
            System.out.println("[에러] " + e.getMessage());
        }
    }
}
