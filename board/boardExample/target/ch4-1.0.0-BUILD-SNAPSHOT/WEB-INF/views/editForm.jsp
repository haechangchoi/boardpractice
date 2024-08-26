<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>글 수정</title>
</head>
<body>
<h1>글 수정하기</h1>
<form action="${pageContext.request.contextPath}/board/edit/${post.id}" method="post">
  <label for="title">제목:</label>
  <input type="text" id="title" name="title" value="${post.title}" required><br>

  <label for="writer">작성자:</label>  <!-- 수정된 부분 -->
  <input type="text" id="writer" name="writer" value="${post.writer}" required><br>  <!-- 수정된 부분 -->

  <label for="content">내용:</label><br>
  <textarea id="content" name="content" rows="10" cols="50" required>${post.content}</textarea><br>

  <label for="password">비밀번호 (4자리):</label>
  <input type="password" id="password" name="password" pattern="\d{4}" required><br>

  <button type="submit">수정하기</button>
</form>

<c:if test="${not empty error}">
  <p style="color: red;">${error}</p>
</c:if>

<a href="${pageContext.request.contextPath}/board/view/${post.id}">취소</a>
</body>
</html>
