package org.example.di.model4;

public class BoardTO {
   private int seq;
   private String subject;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        System.out.println("setSeq() 호출");
        this.seq = seq;
    }

    public String getSubject() {
        System.out.println("getSubject() 호출");
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
