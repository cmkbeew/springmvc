<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>
</head>
<body>
<h1>BBS >>>> Modify</h1>

<form name="frmModify" id="frmModify" method="post" action="/bbs/modify">
    <input type="hidden" name="idx" id="idx" value="${bbsDTO.idx}" />
    <div>
        <span>아이디 : </span> <input type="text" name="user_id" id="user_id" value="${bbsDTO.user_id}" maxlength="20" readonly />
    </div>
    <div>
        <span>제목 : </span> <input type="text" name="title" id="title" value="${bbsDTO.title}" maxlength="100" />
    </div>
    <div>
        <span>내용 : </span> <textarea name="content" id="content" rows="10" cols="60">${bbsDTO.content}</textarea>
    </div>
    <div>
        <span>출력날짜 : </span> <input type="date" name="display_date" id="display_date" value="${bbsDTO.display_date}" />
    </div>
    <div>
        <span>관심사항 : </span>
        <span>스포츠<input type="checkbox" name="interest" id="interest_0" value="스포츠" <c:out value="${bbsDTO.interest.contains(\"스포츠\") ? 'checked' : ''}"></c:out> /></span>
        <span>여행<input type="checkbox" name="interest" id="interest_1" value="여행" <c:out value="${bbsDTO.interest.contains(\"여행\") ? 'checked' : ''}"></c:out> /></span>
        <span>영화<input type="checkbox" name="interest" id="interest_2" value="영화" <c:out value="${bbsDTO.interest.contains(\"영화\") ? 'checked' : ''}"></c:out> /></span>
        <span>음악<input type="checkbox" name="interest" id="interest_3" value="음악" <c:out value="${bbsDTO.interest.contains(\"음악\") ? 'checked' : ''}"></c:out> /></span>
        <div id="div_err_interest" style="display: none;"></div>
    </div>
    <div>
        <button type="submit">글 수정</button>
        <button type="button" onclick="location.href='/bbs/view?idx=${bbsDTO.idx}'">뒤로가기</button>
    </div>
</form>
</body>
</html>
