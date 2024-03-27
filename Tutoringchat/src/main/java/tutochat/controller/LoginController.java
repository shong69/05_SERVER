package tutochat.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tutochat.member.model.dto.Member;
import tutochat.model.service.TutochatService;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("inputId");
			String pw = req.getParameter("inputPw");
			
			TutochatService service = new TutochatService();
			Member loginMember = service.login(id, pw);
			
			HttpSession session = req.getSession();
			if(loginMember != null) {
				//로그인 성공
				session.setAttribute("loginMember", loginMember);
				
				session.setMaxInactiveInterval(60*60); //session continues 1 hour
				if(loginMember.getIsTeacher_YN().equals("Y")) {
					//선생님인 경우 해당 페이지로 이동
					
					resp.sendRedirect("teacher-main.jsp");
				}else {
					resp.sendRedirect("student-main.jsp");
				}
				
			}else {
				//로그인 실패- 이전 페이지로 이동
				session.setAttribute("message", "아이디 또는 비밀번호 불일치");
				String referer = req.getHeader("referer");
				resp.sendRedirect(referer);
			}
		}catch (Exception e) {
			System.out.println("***로그인 중 오류 발생***");
			e.printStackTrace();
		}
	}
	
}
