package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
//Servlet 관련 코드를 작성하기 위해서는 HttpServlet을 반드시 상속받아야 함
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/* @Override
 *  어노테이션 : 컴파일러가 읽는 주석
 *  
 *  @WebServlet : 해당 클래스를 Servlet으로 등록하고 매핑할 주소를 연결하고
 *  			  지시하는 어노테이션
 * -> 서버 실행 시 자동으로 web.xml에
 * <servlet> <servlet-mapping>을 작성하는 효과 
 * */

@WebServlet("/signUp")
public class ExampleController2 extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		//원래 tomcat9 버전째는 전달받은 값을 얻어와서 확인 -> 한글이 깨지는 문제가 발생했었음
		//해결 방법 : 전달받은 데이터의 문자 인코딩을 서버에 맞게 변경
		//req.setCharacterEncoding("UTF-8"0;
		// -> tomcat10 버전 이상부터 자동으로 인코딩 처리를 해주기 때문에 \
		String inputId = req.getParameter("inputId");
		String inputPw = req.getParameter("inputPw");
		String inputName = req.getParameter("inputName");
		String intro = req.getParameter("intro");

		System.out.println(inputId);
		System.out.println(inputPw);
		System.out.println(inputName);
		System.out.println(intro);
		
		//응답화면 만들기
		// -> Java 에서 작성하기 너무 귀찮고 힘들다
		// 누가 대신 만들어줬으면
		// ->JSP가 대신 화면을 만들어 달라고 Servlet이 JSP에게 요청을 위임함
		
		//JSP가 대신 화면을 만들어주기 위해선
		//Servlet이 어떤 요청을 받았는지 알아야 한다
		
		//client가 요청한 화면을 servlet에서 dispatcher에게 화면을 만들도록 함(req, resp을 전달해줌)
		//
		 RequestDispatcher dispatcher= req.getRequestDispatcher("WEB-INF/views.result.jsp"); //이 jsp파일로 위임하겠다
								//webapp폴더 기준 주소로 적음/ 해당 경로에 파일 만들어줘야함 / result.jsp는 요청대로 만든 파일 이름임
		 
		 dispatcher.forward(req, resp);
		 
		 
		 
		 
		 
	}
	
	
	
	
	
	
	
}
