<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>
</head>
<body>

<form method="post" action="/bbs/fileUpload" enctype="multipart/form-data">
    <div>
        <span>파일 업로드</span>
        <input type="file" name="file" id="file" />
    </div>
    <div>
        <input type="submit" value="전송" />
    </div>
</form>

<form method="post" action="/bbs/fileUpload2" enctype="multipart/form-data">
    <div>
        <span>파일 업로드</span>
        <input type="file" name="files" id="files" multiple />
    </div>
    <div>
        <input type="submit" value="전송" />
    </div>
</form>

</body>
</html>
