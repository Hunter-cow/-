
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/top.css">
</head>
<body>
    <div class="container1">
        <div><h1 align="center">学生管理系统
        </h1></div>
        <div id="topUL">
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/all">通知管理</a></li>
                <li><a>班级管理</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/allStud">学生管理</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/selectStuBlog">学习日志管理</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/selectAllLink">学习园地管理</a></li>
            </ul>

        </div>

    </div>
</body>
</html>
