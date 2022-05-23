<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery.js"></script>
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/element-ui/lib/theme-chalk/index.css">
    <script src="${pageContext.request.contextPath}/element-ui/lib/index.js"></script>
    <style>
        .linkManagerTable{
            width: 80%;
            padding-left: 0px;
            text-align: center;
        }
        .linkManagerTable,.linkManagerTable td,.linkManagerTable tr{
            border: 1px black solid;
            border-spacing: 0;
        }
        a{
            text-decoration: none;
        }


    </style>
</head>
<body>
    <%@include file="top.jsp"%>
    <div>
        <hr/>
        <div>
            <table class="linkManagerTable">
                <tr>
                    <td>编号</td>
                    <td>名称</td>
                    <td>链接</td>
                </tr>
                <c:set var="index" value="1"/>
                <c:forEach var="link" items="${links}">
                    <tr>
                        <td>${index}</td>
                        <td>${link.name}</td>
                        <td>${link.link}</td>
                    </tr>
                    <c:set var="index" value="${index+1}"/>
                </c:forEach>
                <tr style="text-align: center">
                    <td colspan="3">
                        <button><a href="${pageContext.request.contextPath}/student/selectAllLink?pageNo=${pageNo gt 1?pageNo-1:1}">-</a></button>
                        <button>${pageNo eq null?1:pageNo}</button>
                        <button><a href="${pageContext.request.contextPath}/student/selectAllLink?pageNo=${pageNo+1}">+</a></button>
                    </td>
                </tr>
            </table>
        </div>
    </div>

    <%@include file="right.jsp"%>
</body>
</html>
