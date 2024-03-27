<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>teacher main page</title>
	<link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
    <main>
        <header>
            <section>
                <a href="/main">
                    <img class="fa-solid fa-chalkboard-user" id = "home-logo">
                </a>
            </section>
            <section>
                <h1>tutoringchat</h1>
            </section>
            <section>

			</section>
        </header>
		<c:choose>
			<!--선생님인 경우-->
			<c:when test="${sessionScop.loginMember.isTeacher_YN='Y'}">
				<div id="T-chat"></div>
				<div>
					<form>
						<label for="st-list">
						   학생 목록
						</label>
						<select id="st-list" name="fruit">
						  <option value="">-- 선택하세요 --</option>
							<c:forEach var="st" items=""${학생 목록}> <%-- 학생 목록을 어떻게 얻어와서 통신할 건지  --%>
								<option value="strawberry">딸기</option>
							</c:forEach>

						</select>
					  </form>

				</div>

			</c:when>
			<!--학생인 경우-->
			<c:otherwise>
				<div id="S-chat"></div>
				<div></div>

			</c:otherwise>
		</c:choose>
        
    </main>
</body>
</html>