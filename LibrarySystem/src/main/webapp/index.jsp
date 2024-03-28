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
				
			<div  id = "right-box"> <!--책 찾는 법, 십진분류 별 설명, 도서 검색-->
				<ul id ="explain">
					<li><h3>해당 도서관의 도서를 찾기 위한 도서 배치 안내도입니다. </h3></li>
					<li>&nbsp;000  </li>
					<li>&nbsp;100</li>
					<li>&nbsp;200</li>
					<li>&nbsp;300</li>
					<li>&nbsp;400</li>
					<li>&nbsp;500</li>
					<li>&nbsp;600</li>
					<li>&nbsp;700</li>
					<li>&nbsp;800</li>
					<li>&nbsp;900</li>
				</ul>
				<div  id = "notice">
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

		<select id="college-sites"> 
			<option value="">--교내 관련 사이트--</option>
			<option></option>
		</select>
	</footer>
	
		<c:if test="${not empty sessionScope.message}">
		<script>
			//EL/JSTL 구문이 자바스크립트보다 먼저 해석되는데
			//문자열이 들어가있는 데이터의 경우
			// 따옴표가 없는 상태라서 붙여줘야 한다
			alert('${message}');
		</script>
		 
		 <c:remove var="message" scope="session"/>
		 <%--session에 message를 추가하면 브라우저 종료 또는 만료 전까지 계속 메세지가 출력된다.
			1회 출력 후 세션에서 message 삭제해줌--%>
		 
	</c:if>
	
	
</body>
</html>