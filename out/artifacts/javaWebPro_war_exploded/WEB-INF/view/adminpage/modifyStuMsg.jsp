
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/modifyStuMsg.css">
</head>
<body>
<%@ include file="top.jsp" %>
<form action="${pageContext.request.contextPath}/admin/modifyStud" method="post">
    <table class="addStu">
        <tr>
            <td>登录账号<input type="hidden" name="id" value="${stud.id}"></td>
            <td><input type="text" name="username" value="${stud.username}"/></td>
            <td>*不能为空</td>
        </tr>
        <tr>
            <td>学号</td>
            <td><input type="text" name="Code" value="${stud.code}"/></td>
            <td>*不能为空</td>
        </tr>
        <tr>
            <td>学生姓名</td>
            <td><input type="text" name="Name" value="${stud.name}"/></td>
            <td>*不能为空</td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="Age" value="${stud.age}"/></td>
            <td>*不能为空</td>
        </tr>
        <tr>
            <td>性别</td>${stud.sex eq 0}
            <td><input type="radio" name="Sex" value="0" ${stud.sex eq 0?'checked':''}/>男
                <input type="radio" name="Sex" value="1" ${stud.sex eq 1?'checked':''}/>女
            </td>
            <td>*不能为空</td>
        </tr>
        <tr>
            <td>班级</td>
            <td><input type="text" name="gid" value="${stud.gid}" /></td>
            <td>*不能为空</td>
        </tr>
        <tr>
            <td>文化课成绩</td>
            <td><input type="text" name="Score" value="${stud.score}" /></td>
            <td>*不能为空</td>
        </tr>
        <tr>
            <td>出勤率</td>
            <td><input type="text" name="chuqing" value="${stud.chuqing}" /></td>
            <td>*不能为空</td>
        </tr>
        <tr>
            <td>技能大赛</td>
            <td><input type="text" name="Jineng" value="${stud.jineng}" /></td>
            <td>*不能为空</td>
        </tr>
        <tr>
            <td>志愿活动</td>
            <td><input type="text" name="zhiyuan" value="${stud.zhiyuan}" /></td>
            <td>*不能为空</td>
        </tr>
        <tr>
            <td colspan="3"><input type="reset" value="重置"/>&nbsp; <input type="submit" value="修改"/></td>
        </tr>
    </table>
</form>
<%@ include file="right.jsp" %>
</body>
</html>
