<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 목록</title>
</head>
<body>
<h1>게시글 목록</h1>

<c:if test="${not empty message}">
    <p style="color: green;">${message}</p>
</c:if>

<table border="1">
    <tr>
        <th>ID</th>
        <th>제목</th>
        <th>작성자</th>
        <th>조회수</th>
        <th>작성일</th>
    </tr>
    <c:choose>
        <c:when test="${not empty posts}">
            <c:forEach var="post" items="${posts}">
                <tr>
                    <td>${post.id}</td>
                    <td><a href="${pageContext.request.contextPath}/board/view/${post.id}">${post.title}</a></td>
                    <td>${post.writer}</td>
                    <td>${post.views}</td>
                    <td>${post.created}</td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="5">게시글이 없습니다.</td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>

<div>
    <!-- 페이지네이션 링크 -->
    <c:if test="${pageHandler.prev}">
        <a href="${pageContext.request.contextPath}/board/list?page=${pageHandler.startPage - 1}">이전</a>
    </c:if>
    <c:forEach begin="${pageHandler.startPage}" end="${pageHandler.endPage}" var="i">
        <a href="${pageContext.request.contextPath}/board/list?page=${i}">${i}</a>
    </c:forEach>
    <c:if test="${pageHandler.next}">
        <a href="${pageContext.request.contextPath}/board/list?page=${pageHandler.endPage + 1}">다음</a>
    </c:if>
</div>

<a href="${pageContext.request.contextPath}/board/write">글쓰기</a>
</body>
</html>
