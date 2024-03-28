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
		<p id = "title">가나대학교 
			온라인 도서관</p>
		<div>
			<a href="/signup">회원가입</a>
			<a href="/login">로그인</a>
		</div>

	</header>
				
	<main>
		<div id = "input-box" >
			<img srt = "이미지 주소">
			<input id = "search-input" type = "text" placeholder="자료 검색" >
		</div>
		
		<div>
			<table id = "book-shelf">
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
				
			<div id = "right-box"> <!--책 찾는 법, 십진분류 별 설명, 도서 검색-->
				<ul id ="explain">
					<li>해당 도서관의 도서를 찾기 위한 도서 배치 안내도입니다. </li>
					<li>000 : </li>
				</ul>
				<div id = "notice">
					<h3>공지사항</h3>
					<ul>
						<li>그룹 스터디룸 운영시간 확대 안내</li>
						<li>3월 취업 준비 강사 초빙 안내</li>
						<li>2월 학술DB 활용 교육 신청 안내</li>
					</ul>
				</div>
			</div>
			
		</div>

	</main>


	<footer>
		<div>
			<a><img></a> <%--학교 로고 --%>
			<a></a> <%-- 인스타 --%>
			<a></a> <%-- 페이스북 --%>
		</div>

		<select> 
			<option value="">--교내 관련 사이트--</option>
			<option></option>
		</select>
	</footer>
	
	
	
	
</body>
</html>