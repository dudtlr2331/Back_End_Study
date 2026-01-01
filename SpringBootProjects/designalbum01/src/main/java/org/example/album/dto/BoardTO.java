package org.example.album.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Alias(value = "to")
@Getter
@Setter
public class BoardTO {
    private String seq;
    private String subject;
    private String writer;
    private String mail;
    private String password;
    private String content;
    private String imagename;
    private long imagesize;
    private String latitude;
    private String longitude;
    private int cmtcnt;
    private String hit;
    private String wip;
    private String wdate;
    private int wgap;
}
