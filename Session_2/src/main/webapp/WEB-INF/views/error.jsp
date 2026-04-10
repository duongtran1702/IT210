<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ include file="header.jsp" %>

<div style="padding: 40px; text-align: center;">
    <h2 style="color: #e74c3c;">Lỗi hệ thống</h2>

    <div style="background-color: #fadbd8; border-left: 5px solid #e74c3c; padding: 20px; margin: 30px 0; text-align: left; border-radius: 4px;">
        <p style="margin: 10px 0; color: #333;">
            <strong>Thông báo lỗi:</strong><br/>
            <%--@elvariable id="errorMessage" type=""--%>
            <c:out value="${errorMessage}"/>
        </p>
    </div>

    <p style="font-size: 16px; margin: 20px 0; color: #555;">
        Vui lòng kiểm tra lại thông tin và thử lại.
    </p>

    <div style="margin-top: 30px;">
        <a href="<c:url value='/employees'/>" class="btn">Quay lại danh sách</a>
        <a href="<c:url value='javascript:history.back()'/>" class="btn">Quay lại trang trước</a>
    </div>
</div>

<%@ include file="footer.jsp" %>

