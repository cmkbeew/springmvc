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
    <div class="d-grid gap-2 d-md-block mb-3" style="margin: 0 auto;">
        <c:if test="${bbsDTO.user_id eq sessionScope.user_id}">
            <button type="button" class="btn btn-outline-success" onclick="location.href='/bbs/modify?idx=${bbsDTO.idx}'">수정</button>
            <button type="button" class="btn btn-outline-danger" onclick="goDelete()">삭제</button>
        </c:if>
        <button type="button" class="btn btn-outline-secondary" onclick="location.href='/bbs/list'">목록</button>
    </div>
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
</div>
<div class="container-md card mb-4">
    <form action="/bbsReply/regist" method="post">
        <input type="hidden" name="bbs_idx" id="bbs_idx" value="${bbsDTO.idx}" />
        <input type="hidden" name="user_id" id="user_id" value="${sessionScope.user_id}" />
        <div class="card-body">
            <div>댓글 작성 : </div>
            <textarea cols="100" rows="4" name="title" id="title" style="overflow: hidden; resize: none;"></textarea>
            <div class="mt-3">
                <button type="submit" class="btn btn-outline-success">댓글 등록</button>
            </div>
        </div>
    </form>
</div>
<div class="container-md card mb-4">
    <div class="card-body">
        <div class="mb-3">
            <div>
                댓글 목록 <span class="badge bg-primary rounded-pill">${bbsDTO.reply_cnt}</span>
            </div>
            <table class="list-group list-group">
                <c:choose>
                    <c:when test="${not empty bbsReplyList}">
                        <tr class="list-group-item d-flex justify-content-between align-items-start">
                            <td class="col"><span>작성자</span></td>
                            <td class="col"><span>내용</span></td>
                            <td class="col"><span>작성일</span></td>
                        </tr>
                        <c:forEach var="replyList" items="${bbsReplyList}">
                            <tr class="list-group-item d-flex justify-content-between align-items-start">
                                <td class="col">
                                    <span>${replyList.user_id}</span>
                                </td>
                                <td class="col">
                                        ${replyList.title}
                                </td>
                                <td class="col">
                                    <span>${replyList.reg_date}</span>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr class="list-group-item d-flex justify-content-between align-items-start">
                            <td colspan="">댓글이 없습니다.</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </table>
        </div>
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
