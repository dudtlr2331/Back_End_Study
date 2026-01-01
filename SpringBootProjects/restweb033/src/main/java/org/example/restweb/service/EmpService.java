package org.example.restweb.service;

import org.example.restweb.model.EmpDAO;
import org.example.restweb.model.EmpTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

	@Autowired
	private EmpDAO dao;

	public String xmlEmp() {
		List<EmpTO> lists = dao.listEmp();

		StringBuilder sbXml = new StringBuilder();
		sbXml.append( "<emps>" );
		for ( EmpTO to : lists ) {
			sbXml.append( "<emp>" );
			sbXml.append( "<empno>" + to.getEmpno() + "</empno>" );
			sbXml.append( "<ename>" + to.getEname() + "</ename>" );
			sbXml.append( "<job>" + to.getJob() + "</job>" );
			sbXml.append( "<mgr>" + to.getMgr() + "</mgr>" );
			sbXml.append( "<hiredate>" + to.getHiredate() + "</hiredate>" );
			sbXml.append( "<sal>" + to.getSal() + "</sal>" );
			sbXml.append( "<comm>" + to.getComm() + "</comm>" );
			sbXml.append( "<deptno>" + to.getDeptno() + "</deptno>" );
			sbXml.append( "</emp>" );
		}
		sbXml.append( "</emps>" );

		return sbXml.toString();
	}

	public List<EmpTO> jsonEmp() {
		List<EmpTO> lists = dao.listEmp();
		return lists;
	}
}
