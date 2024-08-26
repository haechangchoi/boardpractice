<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글쓰기</title>
</head>
<body>
<h1>새 글 작성하기</h1>
<form action="${pageContext.request.contextPath}/board/write" method="post">
    <label for="title">제목:</label>
    <input type="text" id="title" name="title" required><br>

    <label for="writer">작성자:</label>  <!-- 수정된 부분 -->
    <input type="text" id="writer" name="writer" required><br>  <!-- 수정된 부분 -->

    <label for="content">내용:</label><br>
    <textarea id="content" name="content" rows="10" cols="50" required></textarea><br>

    <label for="password">비밀번호 (4자리):</label>
    <input type="password" id="password" name="password" pattern="\d{4}" required><br>

    <button type="submit">글쓰기</button>
</form>
</body>
</html>
