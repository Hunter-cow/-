
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<div id="container">
    <div id="sonCont">
        <div style="background-color: cadetblue;">
            <h3 style="text-align: center;margin: 0 auto;padding: 20px;">学生管理系统3.0</h3>
        </div>

        <form id="registerForm" action="doRegister" method="post">
            <div class="divm">
                <label class="divLeft">身&nbsp;&nbsp;&nbsp;&nbsp;份:</label>
                <select class="divRight" name="state" id="state">
                    <option value="">--请选择身份--</option>
                    <option value="student">学生</option>
                    <option value="sysUser">管理员</option>
                </select>
            </div>
            <div class="divm">
                <label class="divLeft">用户名:</label>
                <input class="divRight" type="text" name="username" id="username" placeholder="请输入用户名" />
            </div>
            <div class="divm">
                <label class="divLeft">密&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
                <input class="divRight" type="password" name="password" id="password" placeholder="请输入密码" />
            </div>

            <div class="divm">
                <label class="divLeft">重复密码:</label>
                <input class="divRight" type="password" name="password1" id="password" placeholder="请输入密码" />
            </div>
            <div style="text-align: right;margin-top: 10px;margin-right: 50px">
                <button class="btnW" type="submit"><a>注册</a></button>
                <button class="btnW" ><a href="login.jsp">登录</a></button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
