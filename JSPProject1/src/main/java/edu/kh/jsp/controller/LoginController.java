package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		String message = null;
		
		if(id.equals("user01")&&pw.equals("pass01")) {
			message = "로그인 성공";
		} else {
			message = "아이디 또는 비밀번호가 일치하지 않습니다";
		}
		
		//Servlet으로 클라이언트에게 응답할 화면을 만들어야 함.
		// -> 작성하기 힘드니까 JSP로 위임
		
		//Request : 요청
		//Dispatcher : 발송자, 필요한 정보를 제공하는 자, 역할을 넘긴다
		
		//RequesetDispatcher : 요펑 정보, (응답)역할을 넘기는 객체
		
		//**JSP 경로 작성방법 **
		// ->webapp 폴더 기준으로 경로를 작성
		RequestDispatcher dispatcher
			= req.getRequestDispatcher("/WEB-INF/views/loginResult.jsp");
		
		//message 값을 속성(attribute)로 추가
		// -> Map 형식으로 작성 (K:V)
		req.setAttribute("message", message);
		
		// ***********
		// forward
		// 전송하다, 전달하다, 보내다
		
		//forward를 하면 주소창이 요청 주소로 바뀌고, 그 요청에 맞는 화면으로 변한다
		// 그 요청에 맞는 응답을 했기 때문에
		
		// ->Servlet이 가지고 있던 req, resp 객체를 JSP에게 전달해 요청을 위임한다.
		
		
		
		
		dispatcher.forward(req, resp);
	}
	

	
}
