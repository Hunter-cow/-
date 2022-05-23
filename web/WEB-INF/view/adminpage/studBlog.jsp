<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/studBlog.css">
    <style>
        .stuBlog{
            width: 80%;
            padding-left: 0px;
            text-align: center;
        }
        .stuBlog,.stuBlog td,.stuBlog tr{
            border: 1px black solid;
            border-spacing: 0;
        }
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
<%@ include file="top.jsp" %>
    <table class="stuBlog" >
        <tr>
            <td>编号</td>
            <td>日志标题</td>
            <td>更新时间</td>
            <td>作者</td>
            <td>操作</td>
        </tr>
        <c:set var="index" value="${(pageNo-1)*5 lt 0?0:(pageNo-1)*5}"/>
        <c:forEach var="blog" items="${blogs}">
            <c:set var="index" value="${index+1}"/>
            <tr>
                <td>${index}</td>
                <td>${blog.title}</td>
                <td>${blog.createdate}</td>
                <td>${blog.sid}</td>
                <td><button><a href="${pageContext.request.contextPath}/admin/deleteStudBlog?id=${blog.id}">删除</a></button></td>
            </tr>
        </c:forEach>


        <tr style="text-align: center">
            <td colspan="5">
                <button><a href="${pageContext.request.contextPath}/admin/selectStuBlog?pageNo=${pageNo gt 1?pageNo-1:1}">-</a></button>
                <button>${pageNo}</button>
                <button><a href="${pageContext.request.contextPath}/admin/selectStuBlog?pageNo=${pageNo+1}">+</a></button>
            </td>
        </tr>
    </table>



<%@ include file="right.jsp" %>
</body>
</html>
