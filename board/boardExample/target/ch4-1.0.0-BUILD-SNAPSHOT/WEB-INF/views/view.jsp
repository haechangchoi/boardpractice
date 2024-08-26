<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 보기</title>
</head>
<body>
<h1>${post.title}</h1>

<p>작성자: ${post.writer}</p>
<p>작성일: ${post.created}</p>
<p>조회수: ${post.views}</p>

<hr>
<p>${post.content}</p>
<hr>

<form action="${pageContext.request.contextPath}/board/delete/${post.id}" method="post">
    <label for="password">비밀번호:</label>
    <input type="password" id="password" name="password" pattern="\d{4}" required>
    <button type="submit">삭제</button>
</form>

<a href="${pageContext.request.contextPath}/board/edit/${post.id}">수정</a>
<a href="${pageContext.request.contextPath}/board/list">목록으로</a>

<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>
</body>
</html>
