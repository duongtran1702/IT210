<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Thông tin sinh viên</title>
    <style>
        /* CSS cho màu sắc điểm */
        .green { color: green; font-weight: bold; }
        .blue { color: blue; font-weight: bold; }
        .orange { color: orange; font-weight: bold; }
        .red { color: red; font-weight: bold; }

        /* CSS định dạng bảng */
        table {
            width: 50%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px 15px;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
            width: 35%;
        }
    </style>
</head>
<body>

<%-- Khai báo kiểu dữ liệu cho IDE --%>
<%--@elvariable id="listStudent" type="atmin.btth.model.entity.Student"--%>

<c:choose>
    <%-- TRƯỜNG HỢP KHÔNG TÌM THẤY SINH VIÊN --%>
    <c:when test="${listStudent == null}">
        <h3 style="color: red;">Sinh viên không tồn tại</h3>
    </c:when>

    <%-- TRƯỜNG HỢP CÓ SINH VIÊN --%>
    <c:otherwise>
        <h2>Hồ sơ sinh viên</h2>
        <table>
            <tbody>
            <tr>
                <th>ID</th>
                <td><c:out value="${listStudent.id}"/></td>
            </tr>
            <tr>
                <th>Name</th>
                <td><c:out value="${listStudent.name}"/></td>
            </tr>
            <tr>
                <th>Faculty</th>
                <td><c:out value="${listStudent.faculty}"/></td>
            </tr>
            <tr>
                <th>Year Of Study</th>
                <td><c:out value="${listStudent.year}"/></td>
            </tr>
            <tr>
                <th>Average Score</th>
                <td>
                        <%-- Giữ nguyên logic tô màu điểm số bằng thẻ <span> --%>
                    <c:choose>
                        <c:when test="${listStudent.gpa >= 8}">
                            <span class="green"><c:out value="${listStudent.gpa}"/></span>
                        </c:when>
                        <c:when test="${listStudent.gpa >= 6.5}">
                            <span class="blue"><c:out value="${listStudent.gpa}"/></span>
                        </c:when>
                        <c:when test="${listStudent.gpa >= 5}">
                            <span class="orange"><c:out value="${listStudent.gpa}"/></span>
                        </c:when>
                        <c:otherwise>
                            <span class="red"><c:out value="${listStudent.gpa}"/></span>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

</body>
</html>