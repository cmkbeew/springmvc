<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head>
    <title>로그인 페이지</title>
    <meta charset="UTF-8"/>
</head>
<body>
<h1>Login</h1>

<form name="frmLogin" id="frmLogin" action="/login/login" method="post">
    <div>
        <div><span>아이디 : <input type="text" name="user_id" id="user_id" value="${user_id}" /></span></div>
        <div id="div_err_user_id" style="display: none"></div>
        <div><span>비밀번호 : <input type="text" name="pwd" id="pwd" value="" /></span></div>
        <div id="div_err_pwd" style="display: none"></div>

        <span>아이디 저장  <input type="checkbox" name="save_id" id="save_id" value="" /></span>
        <span>자동 로그인  <input type="checkbox" name="auto_login" id="auto_login" value="" /></span>

        <div><button type="submit">로그인</button></div>
    </div>
</form>
<script>
    const serverValidResult = {};
    <c:forEach items="${errors}" var="err">
    if(document.getElementById("div_err_${err.getField()}") != null) {
        document.getElementById("div_err_${err.getField()}").innerHTML = "<span style='color:red;'>${err.getField()}필드는 ${err.defaultMessage}</span>";
        document.getElementById("div_err_${err.getField()}").style.display = "block";
    }
    serverValidResult['${err.getField()}'] = '${err.defaultMessage}';
    </c:forEach>

    console.log(serverValidResult);
</script>
</body>
</html>
