<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%-- js, css파일 연결할 때  webapp폴더 기준으로 경로 작성 --%>
	<link rel="stylesheet" href="/resources/css/main.css">
	
	<title>To do List</title>
</head>
<body>
	
	<main>
	
		<c:choose>
			<%-- 로그인을 하지 않았다면 :로그인/회원가입 입력 폼 출력 --%>
			<c:when test="${empty sessionScope.loginMember}"> 
				
				<h1>투 두 리스트 로그인</h1>
				
				<form action="/login" method="post" class="login-form">
					<div>
						<p>아이디</p>
						<input type="text" name="inputId">
					</div>
					<div>
						<p>패스워드</p>
						<input type="password" name="inputPw">
					</div>
					
					<button>로그인</button>
					
					<a href="/signup" class = "signup">회원가입</a>
				</form>
			</c:when>
			<%-- 로그인을 했다면 : 현재 로그인한 사람의 투두리스트 출력 --%>
			<c:otherwise>
				<h1>${sessionScope.loginMember.memberNickname}의 TO DO LIST</h1>
				
				
				<c:choose>
				
				<%-- 투두 리스트가 없다면 --%>
				<c:when test="${empty todoList}">
					<h2>할 일이 하나도 없네요!</h2>
				</c:when>
				
				<%--투두리스트가 있다면 --%>
				<c:otherwise>
					<table>
						<c:forEach var="todo" items="${todoList}">
							<tr>
								<td>${todo.todoTitle}</td> <%--dto에 적힌 값으로 가지고 와야 한다 --%>
								<td>(${todo.todoMemo})</td>
								<td>${todo.todoDate}</td>
								<td><a href="/update?todoNo=${todo.todoNo}" 
								class="update-btn">수정</a></td>
								<td><a href="/delete?todoNo=${todo.todoNo}" 
									onclick="return confirm('정말 삭제하시겠습니까?');"
								class="delete-btn">삭제</a></td> 
								<%-- href에 쿼리스트링 사용->key value 형태로 보내기(파라미터값이 넘어가는거임) --%>
								<%-- onclick에서 true를 받아야 /delete?...로 페이지 넘어갈 수 있음 --%>
							</tr>
						
						</c:forEach>
					</table>
				</c:otherwise>
				</c:choose>
				<div class = "button-div">
					<a href="/insert" class="insert-btn">등록하기</a>
					<a href="/logout" class="logout-btn">로그아웃</a>
				</div>
			</c:otherwise>		
		</c:choose>
	
	</main>
	
	<%-- session에 message가 존재할 경우 값 띄워주기 --%>
	<%-- not empty : 비어있지 않을 경우 true --%>
	<c:if test="${not empty sessionScope.message}">
		<script>
			//EL/JSTL 구문이 자바스크립트보다 먼저 해석되는데
			//문자열이 들어가있는 데이터의 경우
			// 따옴표가 없는 상태라서 붙여줘야 한다
			alert('${message}');
		</script>
		
		<%--
			session에 message를 추가하면
			브라우저 종료 또는 만료 전까지 계속 메세지가 출력된다.
			1회 출력 후 세션에서 message 삭제해줌
		 --%>
		 
		 <c:remove var="message" scope="session"/>
		 
		 
	</c:if>
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>