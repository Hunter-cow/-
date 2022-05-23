
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/addStudent.css"/>
</head>
<body>
<%@ include file="top.jsp" %>
<form action="${pageContext.request.contextPath}/admin/addStud" method="post">
    <table class="addStu">
        <tr>
            <td>登录账号</td>
            <td><input type="text" name="username" /></td>
            <td>*不能为空</td>
        </tr>
        <tr>
            <td>学号</td>
            <td><input type="text" name="Code" /></td>
            <td>*不能为空</td>
        </tr>
        <tr>
            <td>学生姓名</td>
            <td><input type="text" name="Name" /></td>
            <td>*不能为空</td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="Age" /></td>
            <td>*不能为空</td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="radio" name="Sex" value="0"/>男<input type="radio" name="Sex" value="1"/>女</td>
            <td>*不能为空</td>
        </tr>
        <tr>
            <td>班级</td>
            <td><select name="gid">
                <option value="-1">-查询全部-</option>
                <option value="100">20级软工</option>
                <option value="101">20级计科</option>
                <option value="102">20级信安</option>
                <option value="103">20级物联网</option>
            </select></td>
            <td>*不能为空</td>
        </tr>
        <tr>
            <td>文化课成绩</td>
            <td><input type="text" name="Score" /></td>
            <td>*不能为空</td>
        </tr>
        <tr>
            <td>出勤率</td>
            <td><input type="text" name="chuqing" /></td>
            <td>*不能为空</td>
        </tr>
        <tr>
            <td>技能大赛</td>
            <td><input type="text" name="Jineng" /></td>
            <td>*不能为空</td>
        </tr>
        <tr>
            <td>志愿活动</td>
            <td><input type="text" name="zhiyuan" /></td>
            <td>*不能为空</td>
        </tr>
        <tr>
            <td colspan="3"><input type="reset" value="重置"/>&nbsp; <input type="submit" value="添加"/></td>

        </tr>
    </table>
</form>
<%@ include file="right.jsp" %>
</body>
</html>
