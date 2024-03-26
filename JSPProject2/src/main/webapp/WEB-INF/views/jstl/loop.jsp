<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--JSTL 라이브러리를 현재 JSP에서 사용하겠다고 하는 JSP지시자 --%>  
<%-- c = core(if, for문 등) --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSTL 반복문</title>
</head>
<body>
	<h1> 6. 반복문 - for (c:forEach 태그)</h1>
	
	<pre>
		- 일반 for + 추가 기능
		- 속성
		1) var : 현재 반복 횟수에 해당하는 변수 (int i)
		2) begin : 반복 시 var 시작값
		3) end : 반복이 종료된 var 값
		4) step : 반복 할 때마다 증가하는 var의 값(기본값 1)
		
		5) items : 반복 접근할 객체 (배열, 컬렉션 객체)
		6) varStatus : 현재 반복 상태와 관련된 정보를 제공하는 변수 선언
		
		   varStatus = "변수명"
		-> c:forEach 구문 내에서 "변수명"을 통해 원하는 값을 얻을 수 있다.
		
		* varStatus에서 제공되는 값
		
		- current : 현재 반복 횟수(현재 var의 값) 또는
				현재 반복 접근중인 객체(컬렉션이나 배열 요소)
				-> vs.current : 현재 반복중인 객체를 얻을 수 있음
		- index : 현재 index 값을 반환(0 부터 시작)
		- count : 현재 몇바퀴째인지 반복 횟수 반환(1부터 시작)
		- first : 첫번째 반복이면 true, 아니면 false 반환
		- last : 마지막 반복이면 true, 아니면 false

	</pre>
	
	<hr>
	<h3>일반 for문 형식으로 사용하기</h3>
	
	<c:forEach var="i" begin="1" end="6" step="1">
		<h${i}>현재 i 값 : ${i} </h${i}>
	</c:forEach>

	<hr>
	
	<h3>향상된 for문 형식으로 사용하기</h3>
	
	<c:forEach items="${bookList}" varStatus="vs"> 
		<p>
			index : ${vs.index}<br>
			count : ${vs.count}<br>
			current : ${vs.current}<br>
			
			<c:if test ="${vs.first }">
				첫번째 요소입니다.<br>
			</c:if>
			
			<c:if test ="${vs.last}" >
				마지막 요소입니다.
			</c:if>
		</p>
		<hr>
	</c:forEach>
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>