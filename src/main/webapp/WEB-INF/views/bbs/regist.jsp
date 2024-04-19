<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>

</head>
<body>
<div class="container-md mt-3">
    <h1 style="text-align: center">게시글 등록</h1>
    <form name="frmRegist" id="frmRegist" method="post" action="/bbs/regist">
        <div class="mb-3">
            <label for="user_id" class="form-label">아이디</label>
            <input type="text" class="form-control" id="user_id" name="user_id" value="${bbs.user_id}" placeholder="아이디" >
            <div id="div_err_user_id" style="display: none"></div>
        </div>

        <div class="mb-3">
            <label for="title" class="form-label">제목</label>
            <input type="text" class="form-control" id="title" name="title" value="${bbs.title}" placeholder="제목">
            <div id="div_err_title" style="display: none"></div>
        </div>

        <div class="mb-3">
            <label for="content" class="form-label">내용</label>
            <textarea class="form-control" id="content" name="content" rows="3" placeholder="내용을 입력하세요.">${bbs.content}</textarea>
            <div id="div_err_content" style="display: none;"></div>
        </div>

        <div class="mb-3">
            <span>출력날짜 : </span> <input type="date" name="display_date" id="display_date" value="${bbs.display_date}" />
            <div id="div_err_display_date" style="display: none;"></div>
        </div>

        <div for="content" class="form-label">관심사항</div>
        <div class="btn-group mb-3" role="group" aria-label="Basic checkbox toggle button group">
            <input type="checkbox" class="btn-check" id="interest_0" name="interest" value="스포츠" <c:out value="${bbs.interest.contains(\"스포츠\") ? 'checked' : ''}"></c:out>>
            <label class="btn btn-outline-dark" for="interest_0">스포츠</label>

            <input type="checkbox" class="btn-check" id="interest_1" name="interest" value="여행" <c:out value="${bbs.interest.contains(\"여행\") ? 'checked' : ''}"></c:out>>
            <label class="btn btn-outline-dark" for="interest_1">여행</label>

            <input type="checkbox" class="btn-check" id="interest_2" name="interest" value="영화" <c:out value="${bbs.interest.contains(\"영화\") ? 'checked' : ''}"></c:out>>
            <label class="btn btn-outline-dark" for="interest_2">영화</label>

            <input type="checkbox" class="btn-check" id="interest_3" name="interest" value="음악" <c:out value="${bbs.interest.contains(\"음악\") ? 'checked' : ''}"></c:out>>
            <label class="btn btn-outline-dark" for="interest_3">음악</label>
        </div>
        <div class="d-grid gap-2">
            <button class="btn btn-primary" type="submit">글 등록</button>
            <button class="btn btn-secondary" type="button" onclick="location.href='/bbs/list'">게시판 목록</button>
        </div>
    </form>
</div>

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
