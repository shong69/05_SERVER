package edu.kh.todoList.member.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//HttpSession을 얻어옴
		HttpSession session = req.getSession(); 
		//Session 무효화
		session.invalidate();
		//메인페이지를 재요청(redirect)하기
		resp.sendRedirect("/");
	}
}
