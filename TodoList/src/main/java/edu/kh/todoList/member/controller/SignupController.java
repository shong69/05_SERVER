package edu.kh.todoList.member.controller;

import java.io.IOException;

import edu.kh.todoList.member.model.dto.Member;
import edu.kh.todoList.member.model.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signup")
public class SignupController extends HttpServlet {

	//회원가입 화면으로 이동 요청
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//회원가입 폼이 있는 페이지 생성
		req.getRequestDispatcher("WEB-INF/views/signup.jsp").forward(req, resp);
		
		
	}
	//회원가입 폼 입력 후 가입 기능을 할 수 있도록 요청
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String inputId = req.getParameter("inputId");
			String inputPw = req.getParameter("inputPw");
			String inputName = req.getParameter("inputName");
			
			//member 객체 생성 후 setter로 값 넣어주기
			Member member = new Member();
			member.setMemberId(inputId);
			member.setMemberPw(inputPw);
			member.setMemberNickname(inputName);
			
			MemberService service = new MemberService();
			
			int result = service.signup(member);
			
			HttpSession session = req.getSession();
			
			if(result>0) { //회원가입 성공 시 메인페이지로 redirect + 성공 메시지 ->session사용해야함
				
				session.setAttribute("message", "회원가입 완료!");
				
				resp.sendRedirect("/");
			}else {
				session.setAttribute("message", "회원가입 오류...");
				resp.sendRedirect(req.getHeader("referer")); //헤어에 남아있던 이전 요청으로 보내줌
			}
			
			
		}catch (Exception e) {
			System.out.println("[회원가입 중 예외 발생]");
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
}
