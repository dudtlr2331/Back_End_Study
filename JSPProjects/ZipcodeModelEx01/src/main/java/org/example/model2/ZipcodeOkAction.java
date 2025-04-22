package org.example.model2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model1.ZipcodeDAO;
import org.example.model1.ZipcodeTO;

import java.util.ArrayList;

public class ZipcodeOkAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println( "ZipcodeOkAction" );

		String strDong = req.getParameter( "dong" );

		ZipcodeDAO dao = new ZipcodeDAO();
		ArrayList<ZipcodeTO> lists = dao.zipcodeList( strDong );

		req.setAttribute( "lists", lists );

	}
}
