package librarySystem.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import librarySystem.member.model.service.MemberService;
import librarySystem.model.dto.Member;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String inputId=req.getParameter("inputId");
			String inputPw=req.getParameter("inputPw");
			
			MemberService  service = new MemberService();
			
			Member loginMember = service.login(inputId, inputPw);
			
			HttpSession session = req.getSession();
			
			if(loginMember != null){
				session.setAttribute("loginMember", loginMember);
				session.setMaxInactiveInterval(60*60);
				
				resp.sendRedirect("/");
				
				//연체비가 있으면 message
				if(loginMember.getLateFee()>0) {
					session.setAttribute("message", "연체비 "+loginMember.getLateFee()+"원이 미납 상태입니다.");
				}
			}else {//로그인 실패
				session.setAttribute("message", "아이디 혹은 비밀번호가 불일치합니다.");
				String referer = req.getHeader("referer"); //이전 페이지로 이동
				resp.sendRedirect(referer);
				
			}
		}catch (Exception e) {
			System.out.println("[로그인 중 예외가 발생했습니다.]");
		}

	}
}
