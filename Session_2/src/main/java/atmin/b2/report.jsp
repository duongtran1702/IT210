<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Báo cáo điểm</title>
</head>
<body>

<%-- Dùng EL để truy xuất thuộc tính từ model --%>
<h1><%--@elvariable id="reportTitle" type=""--%>
<c:out value="${reportTitle}" /></h1>

<table style="border: 1px solid black; border-collapse: collapse;">
    <thead>
    <tr>
        <th>STT</th>
        <th>Họ tên</th>
        <th>Điểm</th>
        <th>Xếp loại</th>
    </tr>
    </thead>
    <tbody>
    <%--@elvariable id="studentList" type="java.util.List"--%>
    <c:forEach var="sv" items="${studentList}" varStatus="loop">
        <tr>
            <td>${loop.index + 1}</td>
            <td>
                    <%-- Dùng c:out để chống XSS --%>
                <c:out value="${sv.fullName}" />
            </td>
            <td>${sv.score}</td>
            <td>
                    <%-- Xử lý logic xếp loại bằng JSTL --%>
                <c:choose>
                    <c:when test="${sv.score >= 90}">Xuất sắc</c:when>
                    <c:when test="${sv.score >= 80}">Giỏi</c:when>
                    <c:when test="${sv.score >= 70}">Khá</c:when>
                    <c:when test="${sv.score >= 60}">Trung bình khá</c:when>
                    <c:when test="${sv.score >= 50}">Trung bình</c:when>
                    <c:otherwise>Yếu</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>