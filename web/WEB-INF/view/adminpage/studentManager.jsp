<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/studentManager.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery.js"></script>
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/element-ui/lib/theme-chalk/index.css">
    <script src="${pageContext.request.contextPath}/element-ui/lib/index.js"></script>
    <style>
        a{
            text-decoration: none;
        }
    </style>
</head>
<body style="background-color: #8c939d">
<%@ include file="top.jsp" %>
<div id="container3">
    <form name="searchStu" action="${pageContext.request.contextPath}/admin/selectStuBy" method="post">
        <table class="searchTable">
            <tr>
                <td>姓名：</td>
                <td colspan="4"><input type="text" name="stuName" placeholder="不填查询所有"></td>
            </tr>
            <tr>
                <td>性别：</td>
                <td><input type="radio" name="sex" value="0">男<input type="radio" name="sex" value="1">女</td>
                <td>&nbsp;&nbsp;&nbsp;班级：</td>
                <td>
                    <select name="gid">
                        <option value="-1">-查询全部-</option>
                        <option value="100">20级软工</option>
                        <option value="101">20级计科</option>
                        <option value="102">20级信安</option>
                        <option value="103">20级物联网</option>
                    </select>
                </td>
                <td><input type="reset" value="重置"></td>
                <td><input type="submit" value="查询"></td>
            </tr>
        </table>
    </form>
<hr/>
    <button class="btnAdd"><a href="${pageContext.request.contextPath}/admin/toAddStud">添加新学员</a></button>
    <table class="stuMsg">
        <tr>
            <th align="center">编号</th>
            <th>用户名</th>
            <th>姓名</th>
            <th>学号</th>
            <th>性别</th>
            <th>年龄</th>
            <th>班级</th>
            <th>文化课成绩</th>
            <th>出勤率</th>
            <th>操作</th>
        </tr>
        <c:set var="index" value="${(pageNo-1)*5 lt 0?0:(pageNo-1)*5}"/>
        <c:forEach var="stud" items="${studs}">
            <c:set var="index" value="${index+1}"/>
            <tr>
                <td align="center">${index}</td>
                <th>${stud.username}</th>
                <th>${stud.name}</th>
                <th>${stud.code}</th>
                <th>${stud.sex eq 0?'男':'女'}</th>
                <th>${stud.age}</th>
                <th>${stud.gid}</th>
                <th>${stud.score}</th>
                <th>${stud.chuqing}</th>
                <th><button><a target="_blank" href="${pageContext.request.contextPath}/admin/toModifyStud?id=${stud.id}">修改</a></button><button><a href="${pageContext.request.contextPath}/admin/deleteStud.do?id=${stud.id}">删除</a></button></th>
            </tr>
        </c:forEach>
        <tr style="text-align: center">
            <td colspan="10">
                <button><a href="${pageContext.request.contextPath}/admin/allStud?pageNo=${pageNo gt 1?pageNo-1:1}">-</a></button>
                <button>${pageNo eq null?1:pageNo}</button>
                <button><a href="${pageContext.request.contextPath}/admin/allStud?pageNo=${pageNo+1}">+</a></button>
            </td>
        </tr>
    </table>

</div>
<%@ include file="right.jsp" %>
</body>

<script>



</script>

</html>
