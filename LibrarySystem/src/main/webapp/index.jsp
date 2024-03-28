<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/resources/css/main.css">
	 <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
  	/>
	<title>가나대학교 도서관 시스템</title>
</head>
<body>
	
	<header>
		<a href="/"><img id = "home-logo" src = "resources/images/huf_uni_logo.png"></a> <%--학교 로고 --%>
		<h3>가나대학교 온라인 도서관</h3>
		<input type="checkbox" id = "icon">
		<label for ="icon">
			<span></span>
			<span></span>
			<span></span>
		</label>
		<ul id = "hamburger-list">
			<li><a href="#">도서관 안내</a></li>
			<li><a href="#">자료 검색</a></li>
		</ul>

	</header>
				
	<main>
<!-- 로그인 페이지
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
-->

		<div>
			<table>
				<tr>
					<td title = "총류"><a href="#">000</a></td> <!--서고 누르면 해당 분류의 도서 목록으로 이동-->
					<td title = "철학"><a href="#">100</a></td>
					<td title = "종교"><a href="#">200</a></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td title = "사회과학"><a href="#">300</a></td>
				</tr>
				<tr>
					<td title = "자연과학"><a href="#">400</a></td>
					<td title = "기술과학"><a href="#">500</a></td>
					<td title = "예술"><a href="#">600</a></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td title="언어"><a href="#">700</a></td>
				</tr>
				<tr>
					<td></td>
					<td title="문학"><a href="#">800</a></td>
					<td title="역사"><a href="#">900</a></td>
				</tr>
			</table>
		</div>


		<div><!--책 찾는 법, 십진분류 별 설명, 도서 검색-->
			<span>
				<ul id ="explain">
					<li>해당 도서관의 도서를 찾기 위한 도서 배치 안내도입니다. </li>
				</ul>
			</span>
			<span>
				
			</span>
			<div>
				<input type="search" placeholder="도서를 검색하세요">
				<button class = "btnClear"></button> <!--내용 삭제 버튼-->
			</div>
			
		</div>
								
		

	
	</main>
	<footer>
		<a><img></a> <%--학교 로고 --%>
		<a></a> <%-- 인스타 --%>
		<a></a> <%-- 페이스북 --%>
		<select> 
			<option value="">--교내 관련 사이트--</option>
			<option></option>
		</select>
	</footer>
	
	
	
	
</body>
</html>