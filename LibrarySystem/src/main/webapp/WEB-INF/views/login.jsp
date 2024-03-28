<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>가나대학교 로그인</title>
</head>
<body>

	<form action ="/" method="post">
		<fieldset>
			
			<p>아이디</p>
			<input type="text" name = "inputId">
			
			<p>비밀번호</p>
			<input type="password" name ="inputPw">
			<button>로그인</button><button>회원가입</button>
			<div>
			<span>
				가나대학교 학번/사번을 가지고 있는 교내 이용자
				| 아이디 : 종합정보 시스템에 등록된 학번 또는 사번
				| 비밀번호 : 종합정보 시스템에 등록된 비밀번호
				| 아이디, 비밀번호를 모르는 경우에는 종합정보시스템에서 확인하시기 바랍니다.
			</span>
			<span>
				가나대학교 학번/사번이 없는 이용자(사이버가나대학교 포함)
				| 회원가입 후 이용해주시기 바랍니다.
			</span>
			</div>
		</fieldset>
	</form>
</body>
</html>