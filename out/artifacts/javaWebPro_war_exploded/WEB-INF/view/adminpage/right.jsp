
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/right.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery.js"></script>
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/element-ui/lib/theme-chalk/index.css">
    <script src="${pageContext.request.contextPath}/element-ui/lib/index.js"></script>
    <style>
    </style>
</head>
<body>
    <div id="app" class="container">
        <div class="out1">
            <div class="inner1">
                <img width="40px" height="40px" src="${pageContext.request.contextPath}/images/users.png" />
                <span class="inner2">欢迎你:${user.username}管理员！</span>
            </div>
            <div id="rightUL">
                <ul>
                    <li><a id="modifyPWd" @click="dialogVisible = true">修改登录密码</a></li>
                    <li><a href="${pageContext.request.contextPath}/login/loginOut">退出学生管理系统</a></li>
                </ul>
            </div>
        </div>

        <div class="out2">
            <div class="inner1">
                <img width="40px" height="40px" src="${pageContext.request.contextPath}/images/msg.png" />
                <span class="inner2">校训</span>
            </div>
            <div>
                <ul>
                    <li><strong>求是、明德、卓越</strong></li>

                </ul>
            </div>
        </div>
            <%--对话框--%>
        <el-dialog
                title="用户修改密码"
                :visible.sync="dialogVisible"
                width="40%"
                >
            <center>
                <form action="${pageContext.request.contextPath}/login/modifyPass" method="post">
                    <table>
                        <tr>
                            <td>当前密码:</td>
                            <td><input type="password" name="currPass"/></td>
                        </tr>
                        <tr>
                            <td>新的密码:</td>
                            <td><input type="password" name="newPass"/></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit" value="确定修改"></td></td>
                        </tr>
                    </table>
                </form>

            </center>
            </el-dialog>


    </div>
</body>
<script>
    new Vue({
        el:"#app",
        data() {
            return {
                dialogVisible: false,
                modifyPwd: {
                    currPass: '',
                    Pass1: '',
                    Pass2: ''
                }
            };
        },
        methods:{

        }
    });


</script>
</html>
