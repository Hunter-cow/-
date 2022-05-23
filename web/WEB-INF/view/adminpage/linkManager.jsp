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


    <div id="container4">
        <div>
            <form action="${pageContext.request.contextPath}/admin/selectLinkBy" method="get">
                <h4 style="display: inline-block">名称:</h4>
                <input type="text" name="linkName" placeholder="不填查询所有" />
                <input type="reset" value="重置" />
                <input type="submit" value="查询" />
            </form>
        </div>
        <div>
            <el-button type="text" @click="dialogVisible = true">新增</el-button>
        </div>
        <hr/>
        <div>
            <table class="linkManagerTable">
                <tr>
                    <td>编号</td>
                    <td>名称</td>
                    <td>链接</td>
                    <td>操作</td>
                </tr>
                <c:set var="index" value="1"/>
                <c:forEach var="link" items="${links}">
                    <tr>
                        <td>${index}</td>
                        <td>${link.name}</td>
                        <td>${link.link}</td>
                        <td><a href="${pageContext.request.contextPath}/admin/deleteLink?id=${link.id}">删除</a></td>
                    </tr>
                    <c:set var="index" value="${index+1}"/>
                </c:forEach>
                <tr style="text-align: center">
                    <td colspan="4">
                        <button><a href="${pageContext.request.contextPath}/admin/selectAllLink?pageNo=${pageNo gt 1?pageNo-1:1}">-</a></button>
                        <button>${pageNo eq null?1:pageNo}</button>
                        <button><a href="${pageContext.request.contextPath}/admin/selectAllLink?pageNo=${pageNo+1}">+</a></button>
                    </td>
                </tr>
            </table>
        </div>
        <el-dialog
                title="新增"
                :visible.sync="dialogVisible"
                width="30%">
            <form style="text-align: center" action="${pageContext.request.contextPath}/admin/addLink">
                名称:<input name="linkName" type="text"/><br/>
                链接:<input name="link" type="text"/><br/>
                <input type="reset" value="重置">
                <input type="submit" value="新增">
            </form>


        </el-dialog>
    </div>

    <%@include file="right.jsp"%>
    <script>
        new Vue({
            el:"#container4",
            data() {
                return {
                    dialogVisible: false
                };
            }
        });


    </script>
</body>
</html>
