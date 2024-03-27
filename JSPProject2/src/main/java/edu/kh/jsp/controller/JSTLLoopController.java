package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp.model.dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jstl/loop")
public class JSTLLoopController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		List<Book> bookList = new ArrayList<>();
		
		bookList.add(new Book("자바의 정석", "남궁성", 30000));
		bookList.add(new Book("개미", "베르나르 베르베르", 18000));
		bookList.add(new Book("별 헤는 밤", "윤동주", 6000));
		bookList.add(new Book("호모데우스", "유발 하라리", 20000));
		
		req.setAttribute("bookList", bookList);
		req.getRequestDispatcher("/WEB-INF/views/jstl/loop.jsp").forward(req, resp);
		
		
	}
}
