<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>To do 수정하기</title>
	<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
	<main>
		<h1>To do 수정하기</h1>
		
		<form action ="/update" method="post"> 
		<!-- post요청에서 쿼리스트링 사용함 -> 쿼리스트링이 주소창에 노출되는데 우짜스까-->
		<!-- 기능이 돌아가긴 하지만 규칙을 어긴 것. input을 name = "todoNo" type="hidden", value="${todo.todoNo}"로 직접 넘기는 방법을 쓰는것도 추천 -->
			<p>제목</p>
			<input type="text" name="title" value ="${todo.todoTitle}" required><!-- 기존에 써뒀던 value 보여준다 -->
			
			<p>메모</p>
			<textarea name="memo" style="resize:none; font-size:18px;" cols="20" rows="5" >${todo.todoMemo}</textarea>
			<%--textarea는 value가 없음->태그 사이에 쓰기--%>
			
			
			<input name="todoNo" type="hidden" value="${todo.todoNo}" type = "hidden">
			
			
			<br>
			<button class="insert-btn">등록하기</button>
		</form>
	</main>
</body>
</html>