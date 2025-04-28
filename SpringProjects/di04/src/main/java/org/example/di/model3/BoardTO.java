package org.example.di.model3;

public class BoardTO {
	private String seq;
	private String subject;

	public BoardTO(String seq, String subject) {
		this.seq = seq;
		this.subject = subject;
	}

	public String getSeq() {
		return seq;
	}

	public String getSubject() {
		return subject;
	}
}
