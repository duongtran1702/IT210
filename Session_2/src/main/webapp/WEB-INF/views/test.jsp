<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Danh sách sinh viên</title>
    <style>
        table { width: 80%; border-collapse: collapse; margin: 20px auto; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background-color: #f2f2f2; }
        tr:hover { background-color: #f5f5f5; }
    </style>
</head>
<body>

<h2 style="text-align: center;">Danh sách sinh viên</h2>

<table>
    <thead>
    <tr>
        <th>Mã SV</th>
        <th>Họ Tên</th>
        <th>Chuyên Ngành</th>
        <th>Năm Thứ</th>
        <th>GPA</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${listStudent}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.faculty}</td>
            <td>${s.year}</td>
            <td>${s.gpa}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>