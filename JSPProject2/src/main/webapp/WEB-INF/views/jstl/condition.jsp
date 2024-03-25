<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 조건문</title>
</head>
<body>
		
	<h1>4. 조건문 - if (c:if 태그)</h1>
	
	<pre>
		- 단독 if문(c:else 없음)
		- 속성은 test만 존재함
		
		** 주의사항 **
		1) test의 속성 값은 무조건 EL구문으로 작성해야 한다
		2) test의 속성값은 true 또는 false가 나오는 조건식이어야 한다
		3) test의 속성값을 작성하는 "" 안에는 구문 밖의 앞뒤에 공백이 존재하면 안된다
	</pre>
	
	<c:if test="${money == 50000}">
		<h3 style="color : pink;">돈이 5만원 있습니다~</h3>
	</c:if>
	
	
	<h3>EL에서 모든 비교는 == 또는 eq / != 또는 ne</h3>
	<h3>EL에서 문자열은 ''(홑따옴표)로 표현한다</h3>
	
	<c:if test="${name eq '홍길동'}">
		<h3>이름이 일치합니다</h3>
	</c:if>
	
	<hr>
	
	<h1>5. 조건문 - choose, when,otherwise (if ~ elseif ~ else구문과 같음) </h1>
	
	<pre>
	choose : when, otherwise 태그를 감싸는 태그
			(이 안에 if ~ else if ~ else 를 쓰겠다 선언하는 것)
	
	when : if, else if(역할의 태그)
			속성은 test밖에 없음
			
	otherwise : else 역할, 속성 X
	
	<%--
		
		lt(little) : <  미만
		gt(greate) : <  초과 
		
		le (littel or equal) : <=  이하
		ge (greater or equal) : >=  이상
		
	 --%>
	</pre>
	
	<%-- JSP용 주석 --%>
	<!-- XML/HTML용 주석 -->
	
	<c:choose>
	
		<%-- 만약에 val이 100초과한다면 ~ 띄워줄 것이다 
			choose안에 주석 작성이 필요하다면 무조건 jsp용 주석 (지금 쓰는거) 써야함
			html 주석 사용시 500오류(내부 서버 오류) 난다--%>
		<c:when test="${param.val gt 100 }">
			100 초과
		</c:when> <!-- gt : greater(초과의 의미)  -->
		
		<c:when test="${param.val < 100}">
			100미만
		</c:when>
		
		<c:otherwise>
			100입니다~~
		</c:otherwise>
	</c:choose>
	
	
	
	
	
	
	
	
	
	
</body>
</html>