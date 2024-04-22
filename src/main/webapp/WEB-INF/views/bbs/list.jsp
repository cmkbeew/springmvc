<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>

    <style>
        #top {
            text-align: center;
        }
        #view {
            text-decoration: none;
            color: black;
        }
        #view:hover {
            color: blue;
            font-size: 18px;
        }
    </style>
</head>
<body>
<div class="container mt-3" style="width: 70%">
    <div id="top">
        <h1 class="mb-5">게시판 목록</h1>
        <div class="mb-3">
            <button type="button" class="btn btn-primary" onclick="location.href='/bbs/regist'">글 등록</button>
            <button type="button" class="btn btn-secondary" onclick="location.href='/'">홈으로</button>
        </div>
    </div>
    <div class="mb-3">
        <ul class="list-group list-group">
            <c:forEach var="list" items="${responseDTO.dtoList}">
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <span class="fw-bold">${list.idx}</span>
                    <a class="ms-2 me-auto" id="view" href="/bbs/view?idx=${list.idx}">
                        <div class="fw-bold">${list.title}</div>
                            ${list.content}
                    </a>
                    <span class="badge bg-primary rounded-pill">${list.read_cnt}</span>
                </li>
            </c:forEach>
        </ul>
    </div>
    <nav aria-label="Page navigation example">
        <ul class="pagination" style="justify-content: center">
            <li class="page-item" <c:if test="${responseDTO.prev_page_flag ne true}">disabled</c:if>>
                <a class="page-link"
                   href="<c:choose>
                            <c:when test="${responseDTO.prev_page_flag}">
                                ${responseDTO.linkParams}&page=${responseDTO.page_block_start - 1}
                            </c:when>
                            <c:otherwise>
                                ${responseDTO.linkParams}&page=1
                            </c:otherwise>
                        </c:choose>"
                   aria-label="Previous"
                   data-num="<c:choose>
                                <c:when test="${responseDTO.prev_page_flag}">
                                    ${responseDTO.page_block_start - 1}
                                </c:when>
                                <c:otherwise>
                                    1
                                </c:otherwise>
                            </c:choose>"
                >
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
<%--            <li class="page-item"><a class="page-link" href="#">1</a></li>--%>
<%--            <li class="page-item"><a class="page-link" href="#">2</a></li>--%>
<%--            <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
<%--            <li class="page-item"><a class="page-link" href="#">4</a></li>--%>
<%--            <li class="page-item"><a class="page-link" href="#">5</a></li>--%>

            <c:forEach begin="${responseDTO.page_block_start}" end="${responseDTO.page_block_end}" var="page_num">
                <li class="page-item <c:if test="${responseDTO.page == page_num}">active</c:if>" >
                    <a class="page-link" data-num="${page_num}"
                       href="<c:choose>
                                <c:when test="${responseDTO.page == page_num}">#</c:when>
                                <c:otherwise>
                                    ${responseDTO.linkParams}&page=${page_num}
                                </c:otherwise>
                            </c:choose>">
                        ${page_num}
                    </a>
                </li>
            </c:forEach>

            <li class="page-item <c:if test="${responseDTO.next_page_flag ne true}">disabled</c:if>" >
                <a class="page-link"
                   href="<c:choose>
                            <c:when test="${responseDTO.next_page_flag}">
                                ${responseDTO.linkParams}&page=${responseDTO.page_block_end + 1}
                            </c:when>
                            <c:otherwise>
                                ${responseDTO.page_block_end}
                            </c:otherwise>
                        </c:choose>"
                   aria-label="Next"
                   data-num="<c:choose>
                                 <c:when test="${responseDTO.next_page_flag}">
                                    ${responseDTO.page_block_end + 1}
                                 </c:when>
                                 <c:otherwise>
                                    ${responseDTO.page_block_end}
                                 </c:otherwise>
                             </c:choose>">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>
