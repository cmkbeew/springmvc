<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>
</head>
<body>
<h1>BBS >>>> View</h1>
<form name="frmDelete" id="frmDelete" method="post" action="/bbs/delete">
    <input type="hidden" name="idx" id="idx" value="${bbs.idx}" />
    <div>
        <span>인덱스 : ${bbs.idx}</span>
    </div>
    <div>
        <span>아이디 : ${bbs.user_id}</span>
    </div>
    <div>
        <span>제목 : ${bbs.title} </span>
    </div>
    <div>
        <span>내용 : ${bbs.content}</span>
    </div>
    <div>
        <span>출력날짜 : ${bbs.display_date}</span>
    </div>
    <div>
        <span>관심사항 : ${bbs.interest}</span>
    </div>

    <div>
        <button type="button" onclick="location.href='/bbs/list'">목록</button>
        <button type="button" onclick="location.href='/bbs/modify?idx=${bbs.idx}'">수정</button>
        <button type="button" onclick="goDelete()">삭제</button>
    </div>
</form>
<script>
    function goDelete() {
        const frm = document.getElementById("frmDelete");
        let confirm_flag = confirm("해당 게시글을 삭제하시겠습니까?");

        if(confirm_flag) {
            frm.submit();
        }
    }
</script>
</body>
</html>
