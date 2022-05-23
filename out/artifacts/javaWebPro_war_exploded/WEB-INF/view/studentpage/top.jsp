
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
            <li><a href="${pageContext.request.contextPath}/student/selectAllNote">通知</a></li>
            <li><a href="${pageContext.request.contextPath}/student/selectBlogBy">我的学习日志</a></li>
            <li><a href="${pageContext.request.contextPath}/student/toAddBlog">发表学习日志</a></li>
            <li><a href="${pageContext.request.contextPath}/student/selectAllLink">学习园地</a></li>
        </ul>

    </div>

</div>
</body>
</html>
