package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp.model.dto.Pizza;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/pizzaOrder")
public class PizzaOrderController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Pizza> pizzaList = new ArrayList<>();
		
		pizzaList.add(new Pizza("치즈 피자", 8000));
		pizzaList.add(new Pizza("콤비네이션 피자", 9000));
		pizzaList.add(new Pizza("핫치킨 피자", 10000));
		
		
		String pizza = req.getParameter("pizza"); //option의 value가 1, 2, 3 중 하나
		String size = req.getParameter("size"); //R,L 중 하나
		String amount = req.getParameter("amount"); // 수량(0 이상)
		
		
		// L 사이즈는 현재 가격에서 2천원 추가할 거임
		//- 피자 종류 : 핫치킨 피자(L)
		//수량 : 2
		//총 가격 : 24000원
		
		
		//피자 종류 파악
		// -> pizza는 "1"처럼 문자열(html에서 넘어온 값이라)임 -> 정수 형변환하기
		Pizza p = pizzaList.get( Integer.parseInt(pizza) -1 );
		
		String pizzaName = p.getName();
		int price = p.getPrice();
		
		//L사이즈면 2000원 추가함
		if(size.equals("L")) price += 2000;
		
		// price에 amount 곱하기
		
		price *= Integer.parseInt(amount);
		
		
		//req에 pizzaName, price를 속성으로 추가해주기
		
		req.setAttribute("pizzaName", pizzaName);
		req.setAttribute("price", price);
		
		//JSP로 요청 위임
		//JSP 경로 작성 기준 폴더 : webapp
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/pizzaResult.jsp");
		
		dispatcher.forward(req,resp);

		
	}
}
