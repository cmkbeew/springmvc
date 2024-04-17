<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>
</head>
<body>
<h1>BBS >>>> View</h1>

<div>
    <span>아이디 : ${user_id}</span>
</div>
<div>
    <span>제목 : ${title} </span>
</div>
<div>
    <span>내용 : ${content}</span>
</div>
<div>
    <span>출력날짜 :${display_date}</span>
</div>

<div>
    <button type="button" onclick="location.href='/bbs/list'">목록</button>
    <button type="button" onclick="location.href='/bbs/modify'">수정</button>
    <button type="button" onclick="location.href='/bbs/delete'">삭제</button>
</div>
</body>
</html>
