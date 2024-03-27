package edu.kh.todoList.member.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.todoList.member.model.dto.Member;
import edu.kh.todoList.todo.model.dto.Todo;
import edu.kh.todoList.todo.model.service.TodoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private TodoService service = new TodoService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//jsp를 forwar하기 + todoNo에 해당하는 게시글도 넘겨주기
		
		try {
			
			//이전 페이지에서 로그인 멤버와 todoNo을 알아내고 넘겨서 
			//수정하는 페이지에서 todo객체를 보여준다(화면에 수정할 기존 내용을 보여주기 위해)
			HttpSession session = req.getSession();
			Member member = (Member)session.getAttribute("loginMember");
			
			Todo todo = service.selectOne(req.getParameter("todoNo"), member.getMemberNo());
			
			req.setAttribute("todo", todo);
			
			req.getRequestDispatcher("WEB-INF/views/update.jsp").forward(req, resp);
			
			
		}catch (Exception e) {
			System.out.println("[수정할 Todo 조회 중 예외 발생]");
			e.printStackTrace();
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			Member member = (Member) session.getAttribute("loginMember");
			String title = req.getParameter("title");
			String memo = req.getParameter("memo");
			String todoNo = req.getParameter("todoNo");
			
			int result = service.update(title, memo, member.getMemberNo(), todoNo);

			if(result>0) {
				session.setAttribute("message", "수정되었습니다");
				//메인페이지로 재요청 할 것이기 때문에 session에 메세지 담은 것
				
				//todoList에 갱신된 값으로 재등록하기
				List<Todo> todoList = service.selectAll(member.getMemberNo()); //로그인 한 회원의 회원번호 넘기기
				session.setAttribute("todoList", todoList); //기존 todo리스트(방금 수정한것까지) 보내주기
				
				resp.sendRedirect("/");
				
			}else {
				session.setAttribute("message", "수정 실패");
				resp.sendRedirect(req.getHeader("referer"));
			}
			
			
		}catch (Exception e) {
			System.out.println("[Todo 수정 중 예외 발생]");
			e.printStackTrace();
		}
	}
}
