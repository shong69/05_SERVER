<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>El</title>
</head>
<body>
	
	<h1>EL(Expression Language : 표현 언어)</h1>
	
	<pre>
		- JSP의 표현식(<%-- <%= %> --%>)을 조금 더 간단하게 작성할 수 있도록 고안된 언어
		(JSP에 내장돼 있음)
		
		- 화면(HTML)에 출력하고자 하는 자바 코드를 
		<!-- \$로 작성하면 화면에 잘 출력된다 -->
		  \${ key } 형식으로 작성하면, 해당 위치에 알맞은 key의 value가 출력된다.
	</pre>
	
	<h3>EL의 특징 1번 : get이라는 단어를 사용하지 않는다</h3>
	
	<pre>
		El은 자바코드를 얻어와 출력하는 언어이다(출력 전용 언어)
		출력만 가능하기 때문에 set을 할 수 없다.
		-> get만 사용할 수 있으니까 생략하고 사용한다.
	</pre>
	
	테스트1(JSP 표현식) : <%= request.getParameter("test") %>
	<br>
	테스트2(EL) : ${ param.test}
	
	<hr>
	<h3>EL의 특징 2번 : null, NullPointException을 빈칸으로 처리</h3>
	
	테스트1(JSP 표현식) : <%= request.getParameter("num") %>
	<br>
	테스트2(EL) : ${param.num}
	
	
	<hr>
	
	<form action="/elTest" method ="post">
		이름 : <input name = "inputName">
		<br>
		나이 : <input type="number" name ="inputAge">
		
		a<input type="checkbox" name = "opt" value="a">
		b<input type="checkbox" name = "opt" value="b">
		v<input type="checkbox" name = "opt" value="c">
		
		<button>제출</button>
	</form>
	
	
	
</body>
</html>