<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>tutoringchat</title>
    <link rel="stylesheet" href="/resources/css/main.css">
    <script src="https://kit.fontawesome.com/4b505ed7b7.js" crossorigin="anonymous"></script>

</head>
<body>
    <main>
        <header>
            <section>
                <a href="/">
                    <img class="fa-solid fa-chalkboard-user" id = "home-logo">
                </a>
            </section>
            <section>
                <h1>tutoringchat</h1>
            </section>
            <section></section>
        </header>
        <form action="/login" method = "post" class="login-form">
            <fieldset>
                <legend>tutoringchat 로그인하기</legend>
                <div>
                    <p>아이디</p>
                    <input type = "text" name="inputId">
                </div>
                <div>
                    <p>비밀번호</p>
                    <input type="password" name="inputPw">
                </div>
                    <button>로그인</button>
                    <button>회원가입</button>
            </fieldset>
        </form>
        
    </main>
</body>
</html>