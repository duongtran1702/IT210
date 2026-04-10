<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<%@ include file="header.jsp" %>

<!-- DEBUG: Employee value = ${employee} -->

<c:choose>
    <c:when test="${employee == null}">
        <h2>Không tìm thấy nhân viên</h2>
        <p style="color: #e74c3c; margin: 15px 0;">Employee object là NULL!</p>
        <a href="<c:url value='/employees'/>" class="btn">Quay lại</a>
    </c:when>
    <c:otherwise>
        <h2>Chi tiết nhân viên</h2>

        <div class="detail-card">
            <h3>Thông tin cơ bản</h3>
            <div class="detail-row">
                <div class="detail-item">
                    <label>Mã NV:</label>
                    <span><c:out value="${employee.code}"/></span>
                </div>
                <div class="detail-item">
                    <label>Họ tên:</label>
                    <span><c:out value="${employee.fullName}"/></span>
                </div>
            </div>
            <div class="detail-row">
                <div class="detail-item">
                    <label>Email:</label>
                    <span><a href="mailto:${employee.email}"><c:out value="${employee.email}"/></a></span>
                </div>
                <div class="detail-item">
                    <label>Phòng ban:</label>
                    <span><c:out value="${employee.department}"/></span>
                </div>
            </div>
        </div>

        <div class="detail-card">
            <h3>Thông tin công việc</h3>
            <div class="detail-row">
                <div class="detail-item">
                    <label>Lương (VNĐ):</label>
                    <span style="color: #27ae60; font-weight: bold;">
                        <fmt:formatNumber value="${employee.salary}" type="number" groupingUsed="true"/>
                    </span>
                </div>
                <div class="detail-item">
                    <label>Ngày vào làm:</label>
                    <span><fmt:formatDate value="${employee.joinDateAsDate}" pattern="dd/MM/yyyy"/></span>
                </div>
            </div>
            <div class="detail-row">
                <div class="detail-item">
                    <label>Trạng thái:</label>
                    <c:choose>
                        <c:when test="${employee.status == 'Đang làm'}">
                            <span class="badge badge-active">Đang làm</span>
                        </c:when>
                        <c:otherwise>
                            <span class="badge badge-leave">${employee.status}</span>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>

        <div style="margin-top: 20px;">
            <a href="<c:url value='/employees'/>" class="btn">Quay lại danh sách</a>
        </div>
    </c:otherwise>
</c:choose>

<%@ include file="footer.jsp" %>

<h2>Chi tiết nhân viên</h2>

<div class="detail-card">
    <h3>Thông tin cơ bản</h3>
    <div class="detail-row">
        <div class="detail-item">
            <label>Mã NV:</label>
            <span><c:out value="${employee.code}"/></span>
        </div>
        <div class="detail-item">
            <label>Họ tên:</label>
            <span><c:out value="${employee.fullName}"/></span>
        </div>
    </div>
    <div class="detail-row">
        <div class="detail-item">
            <label>Email:</label>
            <span><a href="mailto:${employee.email}"><c:out value="${employee.email}"/></a></span>
        </div>
        <div class="detail-item">
            <label>Phòng ban:</label>
            <span><c:out value="${employee.department}"/></span>
        </div>
    </div>
</div>

<div class="detail-card">
    <h3>Thông tin công việc</h3>
    <div class="detail-row">
        <div class="detail-item">
            <label>Lương (VNĐ):</label>
            <span style="color: #27ae60; font-weight: bold;">
                        <fmt:formatNumber value="${employee.salary}" type="number" groupingUsed="true"/>
                    </span>
        </div>
        <div class="detail-item">
            <label>Ngày vào làm:</label>
            <span><fmt:formatDate value="${employee.joinDateAsDate}" pattern="dd/MM/yyyy"/></span>
        </div>
    </div>
    <div class="detail-row">
        <div class="detail-item">
            <label>Trạng thái:</label>
            <c:choose>
                <c:when test="${employee.status == 'Đang làm'}">
                    <span class="badge badge-active">Đang làm</span>
                </c:when>
                <c:otherwise>
                    <span class="badge badge-leave">${employee.status}</span>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>

<div style="margin-top: 20px;">
    <a href="<c:url value='/employees'/>" class="btn">Quay lại danh sách</a>
</div>


<%@ include file="footer.jsp" %>

