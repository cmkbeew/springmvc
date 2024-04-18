<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>
</head>
<body>
<h1>BBS >>>> List</h1>
    ${user_id}
    <button type="button" onclick="location.href='/bbs/regist'">등록</button>
<ul>
    <c:forEach var="list" items="${bbsList}">
        <li><a href="/bbs/view?idx=${list.idx}"><c:out value="${list}" /></a></li>
    </c:forEach>
</ul>
</body>
</html>
