<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--JSTL 라이브러리를 현재 JSP에서 사용하겠다고 하는 JSP지시자를 작성하기 --%>    


<%-- c = core(if, for문 등) --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--fn ==functions (길이, 자르기, 나누기) --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%--
	<%@ %> : 지시자 태그
	taglib : 태그 라이브러리를 지칭하는 말. 추가하겟다고
	prefix : 접두사. 태그명 앞에 작성되는 단어 <c:set> <c: remove> <c:if> <c:forEach>
	uri(uniform resource identifier, 통합 자원 식별자)
		   : 자원을 식별하는 고유 문자열 
		   (참고) url(uniform resource locator) 자원의 위치를 나타내는 문자열(경로)
 --%>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL(Jsp Standard Tag Library)</title>
</head>
<body>

	<h1>JSTL(Jsp Standard Tag Library, Jsp 표준 태그 라이브러리)</h1>
	<pre>
		JSP에서 자주 사용되거나 공통적으로 사용되는
		Java 코드(if, for, 변수선언, 형변환)을 스크립틀릿 말고
		html 태그 형식을 태그화하여 
		표준으로 제공하는 라이브러리
		(if, for문 간단히 쓰고 싶을 때 쓰는 법임)
	</pre>

	<h3>JSTL 라이브러리 사용 방법</h3>
	
	<ol>
		<li>
			/webapp/WEB-INF/lib 폴더에 jstl 라이브러리 파일(.jar) 추가하기
		</li>
		<li>
			JSTL 라이브러리를 사용하고자 하는 JSP 파일 상단에 
			taglib JSP 지시자 태그를 추가하기
		</li>
		
	</ol>
	
	
	
	<hr>
	
	
	<h1>1. 변수 선언 (c:set 태그)</h1>
	
	<pre>
		- 변수 선언을 위한 태그
		- c:set 태그에 작성 가능한 속성
		1) var : 변수명(속성의 key)
		2) value : 대입할 값
		3) scope : page, request,session,application 중 하나를 지정함(기본값 page)
	</pre>
	
	<%
		//스크립틀릿으로 page scope에 속성 세팅하는 법
		pageContext.setAttribute("num1", 10);
	%>
	
	<%--JSTL로 page scope에 속성 세팅하는 법 --%>
	<c:set var="num2" value="20" scope="page"/>
	
	num1 : ${num1}
	<br>
	num2 : ${num2}
	<br>
	
	
	<hr>
	
	<h1>2. 변수 제거 (c:remove)</h1>
	<pre>
		- 변수 제거 : 내장 객체에 세팅된 속성을 제거함
		(jsp 방법 : removeAttribute("num1"))
		
		- c:remove 속성
		1) var : 삭제할 변수명
		2) scope : 내장 객체 범위(기본값 : 모든 scope. 제대로 명시 안하면 같은 이름을 가진 모든 scope가 삭제될 수 있다는 의미)		
	</pre>
	
	<%
		pageContext.removeAttribute("num1");
	%>
	
	num1 제거 확인 : ${num1}
	
	<br>
	
	<c:remove var="num2"/>
	
	num2 제거 확인 : ${num2}
	
	<hr>
	
	<h1>3. 변수 출력(c:out 태그)</h1>
	<pre>
		\${key}  EL 구문과 비슷함
		-단, escapeXml = "true"(기본값) 설정 시
			html 태그가 해석 X
		-escapeXml = "false" : html 태그 해석 O		
	</pre>
	<c:set var="temp" value="<h1>배부르네요</h1>"/>
	html 태그 해석 X: <c:out value="${temp}"></c:out> <!-- temp의 내용이 해석 없이 문자열 값 자체로만 나온다(태그까지 노출됨) -->
	<br>
	html 태그 해석 O : <c:out value="${temp}" escapeXml="false"></c:out>
	
	
	<hr><hr><hr>
	
	<!-- 상대경로로 작성함 : 현재 위치(경로)가 중요함 
		 현재 경로 : http://localhost:8080/jstl/main
		 이동 경로 : http://localhost:8080/jstl/condition -> 슬래쉬 없이 적으니까 맨 마지막 위치와 대체돼서 적힘
	-->
	<a href="condition">JSTL을 이용한 조건문(if / choose, when, otherwise)</a>
	<!-- /jstl/condition이라는 요청주소를 controller를 만들어야 함  : JSTLConditionController-->
	
	
	<br>
	
	<!-- 상대경로
		현재 경로 : http://localhost:8080/jstl/main
		목표 경로 : http://localhost:8080/jstl/loop
	 -->
	<a href="loop">JSTL을 이용한 반복문</a>
	<%-- /jstl/loop라는 요청을 처리할 contoller : JSTLLoopController 만들기 --%>
	
	
	
	
	
	
	
</body>
</html>