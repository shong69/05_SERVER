<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/resources/css/login.css">
	<meta charset="UTF-8">
	<title>가나대학교 로그인</title>
</head>
<body>

	<header>
		<a href="/"><img id = "home-logo" src = "resources/images/huf_uni_logo.png"></a> <%--학교 로고 --%>
		<p id = "title">가나대학교 온라인 도서관</p>
		<div>
			<a id ="sign" class ="logsign" href="/signup">회원가입</a>
			<a class ="logsign" href="/login">로그인</a>
		</div>
	</header>
	
	<main>
		<div id = "input-box" >
			<img src = "/resources/images/university.png">
			<input id = "search-input" type = "text" placeholder="======= 자료 검색 =======" >
		</div>
		<form id = "form" action ="/" method="post">
			<fieldset>
				<legend>가나 대학교 도서관 로그인</legend>
				<p>아이디</p>
				<input type="text" name = "inputId">
				
				<p>비밀번호</p>
				<input type="password" name ="inputPw">
				<button>로그인</button><button>회원가입</button>
				<div id = "login-div">
					<h4>가나대학교 학번/사번을 가지고 있는 교내 이용자</h4>
					<div class ="login-notice">
						| 아이디 : 종합정보 시스템에 등록된 학번 또는 사번<br>
						| 비밀번호 : 종합정보 시스템에 등록된 비밀번호<br>
						| 아이디, 비밀번호를 모르는 경우에는 종합정보시스템에서 확인하시기 바랍니다.<br>
					</div>
					<h4>가나대학교 학번/사번이 없는 이용자(사이버가나대학교 포함)</h4>
					<div class ="login-notice">
						| 회원가입 후 이용해주시기 바랍니다.<br>
					</div>
				</div>
			</fieldset>
		</form>
	</main>
	<footer>
		<div>
			<a><img></a> <%--학교 로고 --%>
			<a></a> <%-- 인스타 --%>
			<a></a> <%-- 페이스북 --%>
		</div>

		<select id="college-sites"> 
			<option value="">--교내 관련 사이트--</option>
			<option></option>
		</select>
	</footer>



</body>
</html>