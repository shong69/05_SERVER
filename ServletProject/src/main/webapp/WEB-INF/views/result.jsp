<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%--JSP 주석
		<%@ %> : 지시자 태그 (JSP 페이지의 전반적 속성을 설정하는데 사용하는 태그)
		
		<% %> : 스크립틀릿 -> 자바코드 작성함
		
		<%= %> : 표현식 -> 자바와 서버에서 받아온 값을 표현(출력)할 때 사용
		
		JSP(Java Server Page) : 자바 코드가 들어가있는 HTML코드
		
		
	 --%>
	 
	 
	 <h3 style="color : hotpink;"><%= request.getParameter("inputName") %>님의 가입을 환영합니다.</h3>

	<ul>
		<li>id : <%=request.getParameter("inputId") %></li>
		<li>pw : <%=request.getParameter("inputPW") %></li>
	</ul>
	
	<%--만약 "intro"에 적은 내용이 비어있지 않다면 아래의 내용 수행 --%>
	<%if(!request.getParameter("intro").equals("")) {%>
	<h4>자기소개</h4>
	<p><%= request.getParameter("intro") %></p>
	 <%} %>
</body>
</html>