<%--
  Created by IntelliJ IDEA.
  User: 31477
  Date: 2022/5/22
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="top.jsp"%>
<div>
    <form action="${pageContext.request.contextPath}/student/updateBlog" method="post">
        <input type="hidden" name="id" value="${blog.id}">
        标题:<input type="text" name="Title" value="${blog.title}"><br/>
        日志正文:<textarea name="Content" rows="8" cols="30">${blog.content}</textarea><br/>
        <input type="submit" value="发表"/>
    </form>
</div>
<%@include file="right.jsp"%>
</body>
</html>
