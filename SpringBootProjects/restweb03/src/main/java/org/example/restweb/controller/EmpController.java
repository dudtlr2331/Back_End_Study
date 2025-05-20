package org.example.restweb.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.restweb.model.EmpTO;
import org.example.restweb.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {

	@Autowired
	private EmpService empService;

	@GetMapping( value = "/xml.do", produces = "text/xml;charset=utf-8" )
	public String xml() {
		return empService.xmlEmp();
	}

	@GetMapping( value = "/json.do", produces = "application/json;charset=utf-8" )
	public List<EmpTO> json() {
		return empService.jsonEmp();
	}

	@GetMapping(value = "/ename.do", produces = "application/json;charset=utf-8")
	public String ename1(HttpServletRequest request) {
		String ename = request.getParameter("ename");
		return ename;
	}

	//REST API
	// ename.do?ename=scott
	// ename/scott

	@GetMapping(value = "/ename/{ename}", produces = "application/json;charset=utf-8")
	public List<EmpTO> ename2(@PathVariable String ename) {
		System.out.println("ename2() 호출");
		List<EmpTO> lists = empService.jsonEname(ename);

		return lists;
	}

}
