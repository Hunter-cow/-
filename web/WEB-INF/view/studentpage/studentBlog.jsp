<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/studBlog.css">
</head>
<body>
<%@ include file="top.jsp" %>
<div id="cont5">
    <div>
        <form action="${pageContext.request.contextPath}/student/selectBlogByName">
            <h4 style="display: inline-block">通知标题:</h4>
            <input type="text" name="noteName" placeholder="不填查询所有" />
            <input type="reset" value="重置" />
            <input type="submit" value="查询" />
        </form>
    </div>
    <hr/>
    <div>
        <table class="studBlog1" style="text-align: center">
            <tr>
                <td>编号</td>
                <td>日志标题</td>
                <td>更新时间</td>
                <td>操作</td>
            </tr>
            <c:set var="index" value="${(pageNo-1)*5 lt 0?0:(pageNo-1)*5}"/>
            <c:forEach items="${blogs}" var="blog">
                <c:set var="index" value="${index+1}"/>
                <tr>
                    <td>${index}</td>
                    <td>${blog.title}</td>
                    <td>${blog.createdate}</td>
                    <td><button><a href="${pageContext.request.contextPath}/student/selectBlogById?id=${blog.id}">更新</a></button>
                        <button><a href="${pageContext.request.contextPath}/student/deleteStudBlog?id=${blog.id}">删除</a></button>
                    </td>
                </tr>
            </c:forEach>

            <tr style="text-align: center">
                <td colspan="4">
                    <button><a href="${pageContext.request.contextPath}/student/selectBlogBy?pageNo=${pageNo gt 1?pageNo-1:1}">-</a></button>
                    <button>${pageNo eq null?1:pageNo}</button>
                    <button><a href="${pageContext.request.contextPath}/student/selectBlogBy?pageNo=${pageNo+1}">+</a></button>
                </td>
            </tr>
        </table>
    </div>
</div>

<%@ include file="right.jsp"%>
<script>
    new Vue({
        el:"#cont5",
        data() {
            return {
                dialogVisible: false
            };
        },
    });

</script>
</body>
</html>
