package org.example.imgboard.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Alias(value = "to")
@Getter
@Setter
@ToString
public class ImageTO {
    private String seq;
    private String subject;
    private String writer;
    private String mail;
    private String password;
    private String content;
    private String imagename;
    private long imagesize;
    private String hit;
    private String wip;
    private String wdate;
    private int wgap;
}