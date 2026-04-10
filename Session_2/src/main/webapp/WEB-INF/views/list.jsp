<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<%@ include file="header.jsp" %>

<h2>Danh sách nhân viên</h2>

<table>
    <thead>
    <tr>
        <th style="text-align: center; width: 50px;">STT</th>
        <th>Họ tên</th>
        <th>Email</th>
        <th>Phòng ban</th>
        <th style="text-align: right;">Lương (VNĐ)</th>
        <th>Ngày vào</th>
        <th style="text-align: center;">Trạng thái</th>
        <th style="text-align: center; width: 80px;">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="emp" items="${employees}" varStatus="status">
        <tr>
            <td style="text-align: center;">${status.count}</td>
            <td><strong><c:out value="${emp.fullName}"/></strong></td>
            <td><c:out value="${emp.email}"/></td>
            <td><c:out value="${emp.department}"/></td>
            <td style="text-align: right;"><fmt:formatNumber value="${emp.salary}" type="number" groupingUsed="true"/></td>
            <td><fmt:formatDate value="${emp.joinDateAsDate}" pattern="dd/MM/yyyy"/></td>
            <td style="text-align: center;">
                <c:choose>
                    <c:when test="${emp.status == 'Đang làm'}">
                        <span class="badge badge-active">Đang làm</span>
                    </c:when>
                    <c:when test="${emp.status == 'Nghỉ phép'}">
                        <span class="badge badge-leave">Nghỉ phép</span>
                    </c:when>
                </c:choose>
            </td>
            <td style="text-align: center;">
                <a href="<c:url value='/employees/${emp.code}'/>" class="btn">Chi tiết</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr>
        <td colspan="4" style="text-align: right; padding: 12px;"><strong>Tổng lương Kỹ thuật:</strong></td>
        <td colspan="4" style="text-align: left; padding: 12px; color: #c0392b;">
            <fmt:formatNumber value="${techSalary != null ? techSalary : 0}" type="number" groupingUsed="true"/> VNĐ
        </td>
    </tr>
    </tfoot>
</table>

<%@ include file="footer.jsp" %>
