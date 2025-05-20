package org.example.restweb.controller;

import org.example.restweb.model.DeptDAO;
import org.example.restweb.model.DeptTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptDAO dao;

    @GetMapping(value = "/csv.do", produces = "text/plain;chatset=utf-8")
    public String csv(){
        System.out.println("csv() 호출");
        
        List<DeptTO> lists = dao.listDept();

        StringBuilder sbCsv = new StringBuilder();
        for (DeptTO to : lists) {
            sbCsv.append(to.getDeptno() + "," + to.getDname() + "," + to.getLoc() + System.lineSeparator());
        }

        return sbCsv.toString();
    }

    @GetMapping(value = "/xml.do", produces = "text/xml;chatset=utf-8")
    public String xml(){
        System.out.println("xml() 호출");

        List<DeptTO> lists = dao.listDept();

        StringBuilder sbXml = new StringBuilder();
        sbXml.append("<depts>");

        for (DeptTO to : lists) {
            sbXml.append("<dept>");
            sbXml.append("<deptno>" + to.getDeptno() + "</deptno>");
            sbXml.append("<dname>" + to.getDname() + "</dname>");
            sbXml.append("<loc>" + to.getLoc() + "</loc>");
            sbXml.append("</dept>");
        }
        sbXml.append("</depts>");

        return sbXml.toString();
    }

    @GetMapping(value = "/json.do", produces = "application/json;chatset=utf-8")
    public List<DeptTO> json(){
        System.out.println("json() 호출");

        List<DeptTO> lists = dao.listDept();

        return lists;
    }

}
