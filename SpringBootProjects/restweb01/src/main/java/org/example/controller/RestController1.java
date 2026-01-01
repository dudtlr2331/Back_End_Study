package org.example.controller;

import org.example.restweb.model.DeptTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RestController1 {

    @GetMapping(value = "/rest11", produces = "text/plain;charset=utf-8")
    public String rest11() {
        return "rest11";
    }

    @GetMapping(value = "/rest21", produces = "text/plain;charset=utf-8")
    public String rest21() {
        return "<html><body><h1>rest21</h1></body></html>";
    }

    @GetMapping(value = "/rest22", produces = "text/html;charset=utf-8")
    public String rest22() {
        return "<html><body><h1>rest22</h1></body></html>";
    }

    @GetMapping(value = "/xml1", produces = "text/plain;charset=utf-8")
    public String xml1() {
        return "<person><name>홍길동</name></person>";
    }

    @GetMapping(value = "/xml2", produces = "text/xml;charset=utf-8")
    public String xml2() {
//        return "<person><name>홍길동</name></person>";

        StringBuilder sbXml = new StringBuilder();
        sbXml.append("<person>");
        sbXml.append("<name>홍길동</name>");
        sbXml.append("<age>20</age>");
        sbXml.append("</person>");

        return sbXml.toString();
    }

    @GetMapping( value = "/json1", produces = "text/plain;charset=utf-8" )
    public String json1() {
        return "{ \"name\":\"홍길동\", \"age\":\"20\" }" ;
    }

    @GetMapping( value = "/json2", produces = "application/json;charset=utf-8" )
    public DeptTO json2() {
        DeptTO to = new DeptTO("10", "개발부", "서울");
        return to;
    }

    @GetMapping( value = "/json3", produces = "application/json;charset=utf-8" )
    public ArrayList<DeptTO> json3() {
        ArrayList<DeptTO> lists = new ArrayList<>();
        DeptTO to1 = new DeptTO("10", "개발부", "서울");
        DeptTO to2 = new DeptTO("20", "연구부", "부산");

        lists.add(to1);
        lists.add(to2);

        return lists;
    }
}
