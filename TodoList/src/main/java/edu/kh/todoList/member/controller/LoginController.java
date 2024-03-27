package edu.kh.todoList.member.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.todoList.member.model.dto.Member;
import edu.kh.todoList.member.model.service.MemberService;
import edu.kh.todoList.todo.model.dto.Todo;
import edu.kh.todoList.todo.model.service.TodoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//1. 입력 받은 값의 name키를 파라미터로 받아오기
			String inputId = req.getParameter("inputId");
			String inputPw = req.getParameter("inputPw");
			
			//2. service 객체 생성하기
			MemberService service=new MemberService();
			
			//3. 로그인 서비스 호출 후 결과 반환받기
			Member loginMember = service.login(inputId, inputPw);
			
			//4. 세션 객체 생성
			HttpSession session= req.getSession();
			
			
			if(loginMember != null) { //로그인 성공
				//5-1. Session에 로그인한 회원 정보 세팅하기
				session.setAttribute("loginMember", loginMember);
				//5-2 session 만료 시간 지정하기(초단위로)
				session.setMaxInactiveInterval(60*60); //세션 생성 후 1시간으로 변경
				
				
				//--------------------------------------
				//현재 로그인한 회원이 등록한 todolist 목록 조회하기
				TodoService todoService = new TodoService();
				
				List<Todo> todoList = todoService.selectAll(loginMember.getMemberNo());
				
				session.setAttribute("todoList", todoList);				
				
				//--------------------------------------
				
				
				//메인 페이지로 이동할 수 있도록 재요청하기("/")
				resp.sendRedirect("/");
				//응답을 해당 경로로 재요청할거임
				
				// forward : 서블릿이 요청을 처리한 후 자체적인 화면(jsp에게 요청 위임 받아서)이 존재해서,
				//           forward가 응답 해줌
				//			위임 시 request,  response 객체를 함께 위임
				
				
				
				//redirect : 요청 처리 후 자체적인 화면이 없어서
				//           화면이 있는 다른 요청을 다시 호출함(재요청)
				//			 위임하는 것이 아니기 때문에 request와 response가 폐기된다 -> 재요청 후 응답받은 페이지에서 사용 불가함
				
				
				
				
			}else { //실패
				//로그인 실패 메세지 띄우려고 함
				session.setAttribute("message", "아이디 또는 비밀번호 불일치");
				
				//request는 리다이렉트 시 폐기됨
				// ->리다이렉트 요청 후 응답페이지에서 request에 담긴 속성은 사용 불가
				// ->session에 속성 세팅 시 재요청 페이지에서도 사용 가능
				
				//이전 페이지로 redirect 하기(request, response 폐기되기 때문에 session으로 setAttribute함)
				String referer = req.getHeader("referer"); //referer : 각 페이지 방문 시 남는 흔적 req의 헤더에 저장된다
				//request.getHeader() : 파라미터로 referer 키 전달 시 이전 페이지 주소값을 반환한다
				//http://localhost:8080/
				
				resp.sendRedirect(referer);
				
			}
			
		}catch (Exception e) {
			System.out.println("[로그인 중 예외 발생]");
			e.printStackTrace();
		}
		
		
	}
	
	
}
