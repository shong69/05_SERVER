package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//서블릿 매핑할 때 주소 앞에 "/" 무조건 작성해야 함(if not...유효하지 않은 url pattern...메시지)
@WebServlet("/scope")
public class ScopeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/views/scope/scope.jsp");
		
		
		//1. Page scope -> 현재 페이지. JSP에서 확인(page scope는 JSP파일 내에서만 사용 가능)
		
		//2. request scope -> 요청받은 곳 + 위임받은 페이지까지
		//scope 페이지로 이동시켜달라고 요청하는것(컨트롤러 페이지), 위임받은 페이지는 (/scope)페이지
		req.setAttribute("reqValue", "1234");
		
		// 3. session scope -> 브라우저 당 1개
		//					-> 브라우저 종료 또는 Session 만료까지 유지됨

		//session 객체 얻어오는 방법
		HttpSession session = req.getSession();
		session.setAttribute("sessionValue", "9999"); //requst scope처럼 속성 부여가 가능함

		
		// 4. application scope -> 서버가 켜져있는 동안 유지됨
		
		//application 객체 얻어오는 방법
		// -> request, session 객체에서 얻어오기 가능함
		ServletContext application = req.getServletContext(); //application을 반환해주는 메서드
		//ServletContext application1 =session.getServletContext();
		application.setAttribute("appValue", 1000000); //application에 속성 부여하기
		
		
		// ** 모든 scope는 속성을 세팅하고 얻어오는 방법이 동일하다!! **
		
		//***********************************************************
		// scope의 우선순위 & 생명주기 확인하기
		
		//모든 범위에 같은 key로 속성 세팅하기
		
		req.setAttribute("str", "request 범위에 세팅된 문자열");
		
		session.setAttribute("str", "sessiont 범위에 세팅된 문자열");
		
		application.setAttribute("str", "application 범위에 세팅된 문자열");
		
		
		
		
		dis.forward(req, resp);
		

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
