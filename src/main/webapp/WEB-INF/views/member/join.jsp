<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head>
    <title>회원가입 페이지</title>
    <meta charset="UTF-8"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table">
            <div class="d-table-cell">
                <div class="text-center mb-4">
                    <h1 class="h2">Sign Up</h1>
                </div>
                <div class="card">
                    <div class="card-body">
                        <div class="m-sm-4">
                            <form name="frmJoin" id="frmJoin" method="post" action="/member/join">
                                <div class="form-group">
                                    <label for="user_id">아이디</label>
                                    <input class="form-control form-control-lg" type="text" name="user_id" id="user_id" value="${memberDTO.user_id}" placeholder="Enter your ID">
                                    <div id="div_err_user_id" style="display: none"></div>
                                </div>
                                <div class="form-group">
                                    <label for="pwd">비밀번호</label>
                                    <input class="form-control form-control-lg" type="password" name="pwd" id="pwd" placeholder="Enter your Password">
                                    <div id="div_err_pwd" style="display: none"></div>
                                </div>
                                <div class="form-group">
                                    <label for="name">이름</label>
                                    <input class="form-control form-control-lg" type="text" name="name" id="name" value="${memberDTO.name}" placeholder="Enter your Name">
                                    <div id="div_err_name" style="display: none"></div>
                                </div>
                                <div class="form-group">
                                    <label for="email">이메일</label>
                                    <input class="form-control form-control-lg" type="email" name="email" id="email" value="${memberDTO.email}" placeholder="Enter your email">
                                    <div id="div_err_email" style="display: none"></div>
                                </div>
                                <div class="form-group">
                                    <label for="birthday">생년월일</label>
                                    <input class="form-control form-control-lg" type="date" name="birthday" value="${memberDTO.birthday}" id="birthday">
                                    <div id="div_err_birthday" style="display: none"></div>
                                </div>
                                <div class="form-group">
                                    <label>관심사항</label>
                                    <label class="list-group-item" for="interest_0">
                                        <input class="form-check-input me-1" type="checkbox" name="interest" id="interest_0" value="스포츠" <c:out value="${memberDTO.interest.contains(\"스포츠\") ? 'checked' : ''}"></c:out>>
                                        스포츠
                                    </label>
                                    <label class="list-group-item" for="interest_1">
                                        <input class="form-check-input me-1" type="checkbox" name="interest" id="interest_1" value="여행" <c:out value="${memberDTO.interest.contains(\"여행\") ? 'checked' : ''}"></c:out>>
                                        여행
                                    </label>
                                    <label class="list-group-item" for="interest_2">
                                        <input class="form-check-input me-1" type="checkbox" name="interest" id="interest_2" value="영화" <c:out value="${memberDTO.interest.contains(\"영화\") ? 'checked' : ''}"></c:out>>
                                        영화
                                    </label>
                                    <label class="list-group-item" for="interest_3">
                                        <input class="form-check-input me-1" type="checkbox" name="interest" id="interest_3" value="음악" <c:out value="${memberDTO.interest.contains(\"음악\") ? 'checked' : ''}"></c:out>>
                                        음악
                                    </label>
                                    <div id="div_err_interest" style="display: none"></div>
                                </div>
                                <div class="form-group">
                                    <label for="addr1">주소1</label>
                                    <div class="input-group flex-nowrap">
                                        <span class="input-group-text">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-add" viewBox="0 0 16 16">
                                              <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h4a.5.5 0 1 0 0-1h-4a.5.5 0 0 1-.5-.5V7.207l5-5 6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293z"/>
                                              <path d="M16 12.5a3.5 3.5 0 1 1-7 0 3.5 3.5 0 0 1 7 0m-3.5-2a.5.5 0 0 0-.5.5v1h-1a.5.5 0 0 0 0 1h1v1a.5.5 0 1 0 1 0v-1h1a.5.5 0 1 0 0-1h-1v-1a.5.5 0 0 0-.5-.5"/>
                                            </svg>
                                        </span>
                                        <input type="text" class="form-control form-control-lg" name="addr1" id="addr1" value="${memberDTO.addr1}" placeholder="Enter your addr1">
                                    </div>
                                    <div id="div_err_addr1" style="display: none"></div>
                                </div>
                                <div class="form-group">
                                    <label for="addr2">주소2</label>
                                    <div class="input-group flex-nowrap">
                                        <span class="input-group-text">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-add" viewBox="0 0 16 16">
                                              <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h4a.5.5 0 1 0 0-1h-4a.5.5 0 0 1-.5-.5V7.207l5-5 6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293z"/>
                                              <path d="M16 12.5a3.5 3.5 0 1 1-7 0 3.5 3.5 0 0 1 7 0m-3.5-2a.5.5 0 0 0-.5.5v1h-1a.5.5 0 0 0 0 1h1v1a.5.5 0 1 0 1 0v-1h1a.5.5 0 1 0 0-1h-1v-1a.5.5 0 0 0-.5-.5"/>
                                            </svg>
                                        </span>
                                        <input type="text" class="form-control form-control-lg" name="addr2" id="addr2" value="${memberDTO.addr2}" placeholder="Enter your addr2">
                                    </div>
                                    <div id="div_err_addr2" style="display: none"></div>
                                </div>

                                <div class="text-center mt-3">
<%--                                    <a href="index.html" class="btn btn-lg btn-primary">Sign up</a>--%>
                                    <button type="submit" class="btn btn-lg btn-primary">Sign up</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<script>
    const serverValidResult = {};
    <c:forEach items="${errors}" var="err">
    if(document.getElementById("div_err_${err.getField()}") != null) {
        document.getElementById("div_err_${err.getField()}").innerHTML = "<span style='color:red;'>${err.defaultMessage}</span>";
        document.getElementById("div_err_${err.getField()}").style.display = "block";
    }
    serverValidResult['${err.getField()}'] = '${err.defaultMessage}';
    </c:forEach>

    console.log(serverValidResult);
</script>
</body>
</html>
