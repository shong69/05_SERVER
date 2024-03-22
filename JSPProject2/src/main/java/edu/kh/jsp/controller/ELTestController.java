package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp.model.dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/elTest")
public class ELTestController extends HttpServlet{

	//index.html의 a태그 요청(get방식)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//jsp 경로는 webapp기준으로 작성한다.
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/el/elTest.jsp");
		
		dispatcher.forward(req, resp);
	
	}
	
	
	//elTest.jsp에서 요청 온 form 태그 요청(Post 방식)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//post하는 경우에는 여기로 받아서 진행한다.
		
		//새로운 값을 req에 세팅
		req.setAttribute("address", "서울시 중구 남대문로 120"); //속성 추가하기
		req.setAttribute("score", 100);
		
		List<String> strList = new ArrayList<>();
		strList.add("가가가");
		strList.add("나나나");
		strList.add("다다다");
		
		req.setAttribute("strList", strList); //strList를 속성에 추가해보겠음
		
		//Book 객체 Attribute 세팅
		Book book = new Book("어린왕자", "생택쥐페리", 4000);
		
		req.setAttribute("book", book);
		
		
		//null과 비어있다 를 비교하기
		List<String> list1 = null; //null -> 주소값이 없음
		List<String> list2 = new ArrayList<String>(); //비어있음 -> //heap영역에서 ArrayList를 참조하고 있고, 주소값이 있음. 단지 비어있을 뿐
		
		req.setAttribute("List1", list1);
		req.setAttribute("List2", list2);
		

		
		//요청 위임
		RequestDispatcher dis = 
				req.getRequestDispatcher("/WEB-INF/views/el/elResult.jsp");
		
		dis.forward(req, resp);
		
		
		
	}
	
	
	
	
	
	
}
