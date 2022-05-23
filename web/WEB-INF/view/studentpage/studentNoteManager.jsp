<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/studBlog.css">
</head>
<body>
<%@ include file="top.jsp" %>
<div>
    <div>
        <form action="${pageContext.request.contextPath}/student/searchNote" name="get">
            <h4 style="display: inline-block">通知标题:</h4>
            <input type="text" name="noteName" placeholder="不填查询所有" />
            <input type="reset" value="重置" />
            <input type="submit" value="查询" />
        </form>
    </div>
    <hr/>
    <div>
        <table  style="text-align: center" class="studNoteTable">
            <tr>
                <td>编号</td>
                <td>通知标题</td>
                <td>创建时间</td>
            </tr>
            <c:set var="index" value="${(pageNo-1)*5 lt 0?0:(pageNo-1)*5}"/>
            <c:forEach var="note" items="${notes}">
                <c:set var="index" value="${index+1}"/>
                <tr>
                    <td>${index}</td>
                    <td>${note.title}</td>
                    <td>${note.createdate}</td>
                </tr>
            </c:forEach>

            <tr style="text-align: center">
                <td colspan="3">
                    <button><a href="${pageContext.request.contextPath}/student/selectAllNote?pageNo=${pageNo gt 1?pageNo-1:1}">-</a></button>
                    <button>${pageNo eq null?1:pageNo}</button>
                    <button><a href="${pageContext.request.contextPath}/student/selectAllNote?pageNo=${pageNo+1}">+</a></button>
                </td>
            </tr>
        </table>
    </div>
</div>

<%@ include file="right.jsp"%>
</body>
</html>
