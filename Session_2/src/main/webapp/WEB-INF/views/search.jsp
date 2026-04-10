<%--@elvariable id="totalFound" type=""--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Tìm kiếm sự kiện</title>
    <style>
        .free {
            font-weight: bold;
            color: green;
        }

        .sold-out {
            color: red;
            font-weight: bold;
        }

        .low-stock {
            color: orange;
        }

        .normal {
            color: blue;
        }

        .disabled-link {
            pointer-events: none;
            color: gray;
            text-decoration: none;
        }

        .event-table {
            border-collapse: collapse;
            width: 100%;
        }

        .event-table th,
        .event-table td {
            border: 1px solid black; /* Thay cho border="1" */
            padding: 10px; /* Thay cho cellpadding="10" */
            text-align: left;
        }

        .event-table th {
            background-color: #f2f2f2;
        }

    </style>
</head>
<body>

<!-- A. Phần Header -->
<h3>Kết quả tìm kiếm cho: <%--@elvariable id="keyword" type=""--%>
    <c:out value="${keyword}"/></h3>
<p>Tìm thấy ${totalFound} sự kiện.</p>
<p>Số ký tự của từ khóa tìm kiếm: ${fn:length(keyword)} ký tự.</p>

<%--@elvariable id="events" type=""--%>
<c:if test="${empty events}">
    <p>Không tìm thấy sự kiện nào phù hợp.</p>
</c:if>

<!-- B. Bảng kết quả -->
<c:if test="${not empty events}">
    <table class="event-table">
        <thead>
        <tr>
            <th>STT</th>
            <th>Tên sự kiện</th>
            <th>Ngày tổ chức</th>
            <th>Giá vé</th>
            <th>Vé còn lại</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="event" items="${events}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td><c:out value="${event.name}"/></td>
                <td>${event.eventDate}</td>
                <td>
                    <c:choose>
                        <c:when test="${event.price == 0}">
                            <span class="free">MIỄN PHÍ</span>
                        </c:when>
                        <c:otherwise>
                            <fmt:formatNumber value="${event.price}" pattern="#,###"/> VNĐ
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <span class="sold-out">HẾT VÉ</span>
                        </c:when>
                        <c:when test="${event.remainingTickets < 10}">
                            <span class="low-stock">Sắp hết (còn ${event.remainingTickets} vé)</span>
                        </c:when>
                        <c:otherwise>
                            <span class="normal">${event.remainingTickets}</span>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:url var="bookUrl" value="/events/${event.id}/book"/>
                    <c:if test="${event.remainingTickets > 0}">
                        <a href="${bookUrl}">Đặt vé</a>
                    </c:if>
                    <c:if test="${event.remainingTickets == 0}">
                        <span class="disabled-link">Đặt vé</span>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<!-- C. Phần Footer -->
<hr>
<c:if test="${not empty events}">
    <p>Sự kiện đầu tiên: <strong>${fn:toUpperCase(events[0].name)}</strong></p>
</c:if>

</body>
</html>