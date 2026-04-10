<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Quản lý đơn hàng</title>
    <style>
        table { border-collapse: collapse; width: 80%; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #f4f4f4; }
    </style>
</head>
<body>
<!-- Lấy từ Session Scope -->
<h2>Xin chào, <b style="color: blue;">${sessionScope.loggedUser}</b>!
    Vai trò: <i style="color: green;">${sessionScope.role}</i>
</h2>

<table>
    <thead>
    <tr>
        <th>Mã đơn</th>
        <th>Tên sản phẩm</th>
        <th>Tổng tiền</th>
        <th>Ngày đặt</th>
    </tr>
    </thead>
    <tbody>
    <%--@elvariable id="orders" type="atmin.b3.Order"--%>
    <c:forEach var="o" items="${orders}">
        <tr>
            <td>${o.id}</td>
            <td>${o.name}</td>
            <td>
                <!-- Định dạng tiền tệ VNĐ -->
                <fmt:formatNumber value="${o.price}" type="currency" currencySymbol="₫" />
            </td>
            <td>
                <!-- Định dạng ngày dd/MM/yyyy -->
                <fmt:formatDate value="${o.date}" pattern="dd/MM/yyyy" />
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div style="margin-top: 30px; padding: 10px; background: #eee;">
    <!-- Lấy từ Application Scope -->
    <strong>Tổng lượt xem hệ thống:</strong> ${applicationScope.totalViewCount} lượt.
</div>

<p><a href="<c:url value='/logout'/>">Đăng xuất</a></p>
</body>
</html>