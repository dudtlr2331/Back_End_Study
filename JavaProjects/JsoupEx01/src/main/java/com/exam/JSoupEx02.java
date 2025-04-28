package com.exam;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupEx02 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> Hello World </title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<p id='i1' class='c1'> Hello Jsoup Document1 </p>");
        sb.append("<p id='i2' class='c2'> Hello Jsoup Document2 </p>");
        sb.append("<div>");
        sb.append("<p id='i3' class='c1'> Hello Jsoup Document3 </p>");
        sb.append("<p id='i4' class='c2'> Hello Jsoup Document4 </p>");
        sb.append("</div>");
        sb.append("</body>");
        sb.append("</html>");

        Document doc = Jsoup.parse(sb.toString());

        Element pTag = doc.getElementById("i1");
        System.out.println(pTag);
        System.out.println(pTag.text());

        Elements pTags = doc.getElementsByClass("c1");
        System.out.println(pTags);

    }
}
