package org.example.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardTO {
    private String seq;
    private int grp;
    private int grps;
    private int grpl;
    private String subject;
    private String writer;
    private String mail;
    private String password;
    private String content;
    private String hit;
    private String wip;
    private String wdate;
    private int wgap;
}
