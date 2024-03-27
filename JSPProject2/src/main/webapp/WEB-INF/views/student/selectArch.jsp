<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>건축공학과인 학생만 찾기</title>
</head>
<body>

	<h1>건축공학과 학생 리스트</h1>
	
	<table border="1">
		<tr>
			<td>번호</td>
			<td>학번</td>
			<td>이름</td>
			<td>주소</td>
		</tr>
		
		<c:forEach var="std" items="${archstList}" varStatus="vs">
			<tr>
				<td>${vs.count}</td>
				<td>${std.studentNo}</td>
				<td>${std.studentName}</td>
				<td>${std.studentAddress}</td>
			</tr>
		
		</c:forEach>
	</table>
</body>
</html>