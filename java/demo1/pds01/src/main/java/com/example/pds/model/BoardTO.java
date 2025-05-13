package com.example.pds.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardTO {
	private String seq;
	private String subject;
	private String writer;
	private String mail;
	private String password;
	private String Content;
	private String fileName;
	private int fileSize;
	private String hit;
	private String wip;
	private String wdate;
	private int wgap;
}
