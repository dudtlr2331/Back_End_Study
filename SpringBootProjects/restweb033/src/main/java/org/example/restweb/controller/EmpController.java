package org.example.restweb.controller;

import org.example.restweb.model.EmpDAO;
import org.example.restweb.model.EmpTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private EmpDAO dao;

    @GetMapping(value = "/xml.do", produces = "text/xml;chatset=utf-8")
    public String xml() {
        System.out.println("xml() 호출");
        List<EmpTO> lists = dao.listEmp();

        StringBuilder sbXml = new StringBuilder();
        sbXml.append("<emps>");
        for (EmpTO to : lists) {
            sbXml.append("<emp>");
            sbXml.append("<empno>" + to.getEmpno() + "</empno>");
            sbXml.append("<ename>" + to.getEname() + "</ename>");
            sbXml.append("<job>" + to.getJob() + "</job>");
            sbXml.append("<mgr>" + to.getMgr() + "</mgr>");
            sbXml.append("<hiredate>" + to.getHiredate() + "</hiredate>");
            sbXml.append("<sal>" + to.getSal() + "</sal>");
            sbXml.append("<comm>" + to.getComm() + "</comm>");
            sbXml.append("<deptno>" + to.getDeptno() + "</deptno>");
            sbXml.append("</emp>");
        }
        sbXml.append("</emps>");

        return sbXml.toString();
    }

    @GetMapping(value = "/json.do", produces = "application/json;chatset=utf-8")
    public  List<EmpTO> json() {
        System.out.println("json() 호출");
        List<EmpTO> lists = dao.listEmp();

        return lists;
    }
}
