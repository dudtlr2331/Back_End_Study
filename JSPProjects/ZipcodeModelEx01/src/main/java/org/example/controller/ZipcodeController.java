package org.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model2.Action;
import org.example.model2.ZipcodeAction;
import org.example.model2.ZipcodeOkAction;

import java.io.IOException;

@WebServlet( urlPatterns = "/controller")
public class ZipcodeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) {

		try {
			String path = req.getParameter( "path" );

			String url = "";
			Action action = null;

			if ( path == null || path.equals("") || path.equals( "zipcode" ) ) {
				action = new ZipcodeAction();
				action.execute(req, resp);

				url = "/WEB-INF/views/zipcode.jsp";
			} else if ( path.equals( "zipcode_ok" ) ) {
				action = new ZipcodeOkAction();
				action.execute(req, resp);

				url = "/WEB-INF/views/zipcode_ok.jsp";
			}

			RequestDispatcher dispatcher = req.getRequestDispatcher( url );
			dispatcher.forward( req, resp );
		} catch (ServletException e) {
			System.out.println( "[에러] " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "[에러] " + e.getMessage() );
		}


	}
}
