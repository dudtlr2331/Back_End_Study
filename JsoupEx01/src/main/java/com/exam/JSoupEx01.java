package com.exam;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupEx01 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> Hello World </title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<p> Hello Jsoup Document1 </p>");
        sb.append("<p> Hello Jsoup Document2 </p>");
        sb.append("<div>");
        sb.append("<p> Hello Jsoup Document3 </p>");
        sb.append("<p> Hello Jsoup Document4 </p>");
        sb.append("</div>");
        sb.append("</body>");
        sb.append("</html>");

        Document doc = Jsoup.parse(sb.toString());

//        System.out.println(doc);
//        System.out.println(doc.head());
//        System.out.println(doc.body());
//        System.out.println(doc.title());

//        Elements title = doc.getElementsByTag("title");
//        System.out.println(title); //<title> Hello World </title>
//        System.out.println(title.text()); //Hello World

        Elements pTags = doc.getElementsByTag("p");
        System.out.println(pTags);
        System.out.println(pTags.size());

        for (int i = 0; i < pTags.size(); i++) {
            Element pTag = pTags.get(i);
            System.out.println(pTag.text());
        }

    }
}
