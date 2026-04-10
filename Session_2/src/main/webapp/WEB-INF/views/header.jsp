<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HR Portal</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #ecf0f1;
        }

        nav {
            background: linear-gradient(135deg, #2c3e50, #34495e);
            color: white;
            padding: 12px 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        nav .logo {
            font-size: 1.3em;
            font-weight: bold;
            color: #3498db;
        }

        nav a {
            color: #ecf0f1;
            text-decoration: none;
            padding: 6px 12px;
        }

        .container {
            width: 90%;
            max-width: 1200px;
            margin: 20px auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 15px 0;
        }

        table th {
            background-color: #f8f9fa;
            padding: 10px;
            border: 1px solid #ddd;
            font-weight: 600;
        }

        table td {
            padding: 10px;
            border: 1px solid #ddd;
        }

        table tbody tr:hover {
            background-color: #f8f9fa;
        }

        .badge {
            display: inline-block;
            padding: 5px 10px;
            border-radius: 12px;
            color: white;
            font-size: 12px;
        }

        .badge-active {
            background-color: #27ae60;
        }

        .badge-leave {
            background-color: #e67e22;
        }

        .btn {
            display: inline-block;
            padding: 8px 15px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            font-size: 12px;
        }

        .btn:hover {
            background-color: #2980b9;
        }

        h2 {
            color: #2c3e50;
            margin: 15px 0;
            border-left: 4px solid #2980b9;
            padding-left: 10px;
        }

        .detail-card {
            background: #f8f9fa;
            border: 1px solid #dee2e6;
            border-radius: 8px;
            padding: 15px;
            margin: 15px 0;
        }

        .detail-card h3 {
            color: #2c3e50;
            margin-bottom: 12px;
            font-size: 1.1em;
        }

        .detail-row {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 15px;
            margin-bottom: 12px;
        }

        .detail-row-full {
            margin-bottom: 12px;
        }

        .detail-item label {
            font-weight: 600;
            color: #2c3e50;
            display: block;
            margin-bottom: 4px;
            font-size: 0.9em;
        }

        a {
            color: #3498db;
            text-decoration: none;
        }

        a:hover {
            color: #2980b9;
        }
    </style>
</head>
<body>
<nav>
    <div class="logo">HR Portal</div>
    <div>
        Xin chào, <b><c:out value="${sessionScope.loggedUser != null ? sessionScope.loggedUser : 'Khách'}"/></b>
        <a href="<c:url value='/logout'/>">Đăng xuất</a>
    </div>
</nav>
<main class="container">
<%--</main>--%>
