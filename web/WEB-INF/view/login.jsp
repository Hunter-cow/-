
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
    <script>
        function changeCode() {
            document.getElementById("yzm").src = 'createCode?time='+new Date().getTime();
        }
    </script>
</head>
<body>
<div id="container">
    <div id="sonCont">
        <div style="background-color: cadetblue;">
            <h3 style="text-align: center;margin: 0 auto;padding: 20px;">学生管理系统</h3>
        </div>

        <form id="loginForm" action="${pageContext.request.contextPath}/login/doLogin" method="post">
            <div class="divm">
                <label class="divLeft">用户名:</label>
                <input class="divRight" type="text" name="username" id="username" placeholder="请输入用户名" />
            </div>
            <div class="divm">
                <label class="divLeft">密&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
                <input class="divRight" type="password" name="password" id="password" placeholder="请输入密码" />
            </div>
            <div class="divm">
                <label class="divLeft">身&nbsp;&nbsp;&nbsp;&nbsp;份:</label>
                <select class="divRight" name="state" id="state">
                    <option value="">--请选择身份--</option>
                    <option value="student">学生</option>
                    <option value="sysUser">管理员</option>
                </select>
            </div>
            <div class="divm">
                <label class="divLeft">验证码:</label>
                <input style="width: 100px;margin-left: 20px" type="text" name="code" id="code" placeholder="请输入验证码" />
                <div style="display: inline-block;margin-left: 10px;text-align: center;vertical-align: middle;display: inline-flex;">
                    <img id="yzm" alt="验证码" onclick="changeCode()" width="120px" height="100%" src="${pageContext.request.contextPath}/login/createCode"/>
                    <button type="button" id="btn1" onclick="changeCode()">看不清</button>
                </div>
            </div>
            <div style="text-align: right;margin-top: 10px;margin-right: 50px">
                <button class="btnW" type="reset"><a href="${pageContext.request.contextPath}/login/register">注册</a></button>
                <button class="btnW" type="reset"><a>重置</a></button>
                <button class="btnW" type="submit"><a>登录</a></button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
