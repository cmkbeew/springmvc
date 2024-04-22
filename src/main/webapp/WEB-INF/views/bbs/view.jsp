<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>
</head>
<body>
<h1 style="text-align: center">게시글 상세</h1>
<div class="container-md card mb-4">
    <div class="card-body">
        <form name="frmDelete" id="frmDelete" method="post" action="/bbs/delete">
            <input type="hidden" name="idx" id="idx" value="${bbsDTO.idx}" />
            <table class="table user-view-table m-0">
                <tbody>
                <tr>
                    <td>아이디 :</td>
                    <td>${bbsDTO.user_id}</td>
                </tr>
                <tr>
                    <td>제목 :</td>
                    <td>${bbsDTO.title}</td>
                </tr>
                <tr>
                    <td>내용 :</td>
                    <td>
                        <textarea style="width: 100%; height: 200px; border: none; outline: none; resize: none" readonly>${bbsDTO.content}</textarea>
                    </td>
                </tr>
                <tr>
                    <td>출력일 :</td>
                    <td>${bbsDTO.display_date}</td>
                </tr>
                <tr>
                    <td>관심사항:</td>
                    <td>${bbsDTO.interest}</td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
    <div class="d-grid gap-2 d-md-block mb-3" style="margin: 0 auto;">
        <c:if test="${bbsDTO.user_id eq sessionScope.user_id}">
            <button type="button" class="btn btn-outline-success" onclick="location.href='/bbs/modify?idx=${bbsDTO.idx}'">수정</button>
            <button type="button" class="btn btn-outline-danger" onclick="goDelete()">삭제</button>
        </c:if>
        <button type="button" class="btn btn-outline-secondary" onclick="location.href='/bbs/list'">목록</button>
    </div>
</div>

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
