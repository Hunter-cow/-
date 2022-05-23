
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>通知</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery.js"></script>
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/element-ui/lib/theme-chalk/index.css">
    <script src="${pageContext.request.contextPath}/element-ui/lib/index.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/noteManger.css">
</head>
<body>



<%@ include file="top.jsp" %>


<div id="container2">
    <div>
        <form method="get" action="${pageContext.request.contextPath}/admin/searchNote">
            <h4 style="display: inline-block">通知标题:</h4>
            <input type="text" name="noteName" placeholder="不填查询所有" />
            <input type="reset" value="重置" />
            <input type="submit" value="查询" />
        </form>
    </div>
    <el-row>
        <el-button @click="dialogVisible = true">添加通知</el-button>
    </el-row>
<%--通知表单--%>
    <el-dialog
            title="添加通知"
            :visible.sync="dialogVisible"
            width="50%">
    <form action="${pageContext.request.contextPath}/admin/addNote.do" method="post">
        <hr/>
        <table style="text-align: center;" class="noteTable">
            <tr>
                <td><label>通知标题:</label></td>
                <td><input type="text" name="Title"/></td>
                <td><label>*不可为空</label></td>
            </tr>
            <tr>
                <td><label>通知内容:</label></td>
                <td><textarea name="Content" rows="8" cols="30"></textarea></td>
                <td><label>*不可为空</label></td>
            </tr>
            <tr>
                <td><input type="button" value="关闭"></td>
                <td><input type="reset" value="重置"></td>
                <td><input type="submit" value="提交"></td>
            </tr>
        </table>

    </form>
    </el-dialog>
<%--修改的对话框--%>


<%--    表格--%>
    <div >
        <table class="Table">
            <tr>
                <th>编号</th>
                <th>通知标题</th>
                <th>创建时间</th>
                <th style="width: 20%;">操作</th>
            </tr>
            <c:set var="index" value="${(pageNo-1)*5 lt 0?0:(pageNo-1)*5}"/>
            <c:forEach var="note" items="${notes}" varStatus="status">
                <tr>
                    <c:set var="index" value="${index + 1}" />
                    <td><c:out value="${index}" /></td>
                    <td><c:out value="${note.title}" /></td>
                    <td><c:out value="${note.createdate}" /></td>
                    <td><el-button type="success" round><el-link href="${pageContext.request.contextPath}/admin/toModifyNote?id=${note.id}" target="_self">修改</el-link></el-button>
                        <el-button type="success" round><el-link href="${pageContext.request.contextPath}/admin/delete.do?id=${note.id}&pageNo=${pageNo}" target="_self">删除</el-link></el-button>
                    </td>
                </tr>

            </c:forEach>

        </table>

        <div style="text-align: center">
            <el-button  icon="el-icon-arrow-left"><a href="${pageContext.request.contextPath}/admin/all?pageNo=${pageNo-1}">上一页</a></el-button>
            <el-button >${empty pageNo?1:pageNo}</el-button>
            <el-button ><a href="${pageContext.request.contextPath}/admin/all?pageNo=${pageNo+1}">下一页</a><i class="el-icon-arrow-right el-icon--right"></i></el-button>
        </div>
    </div>

</div>
<%@ include file="right.jsp" %>



</body>

<script>
    new Vue({
        el:"#container2",
        data(){
            return {
                dialogVisible: false,
                dialogVisible1:false,
                searchNote: {
                    Notes: ''
                },
                form: {
                    name: '',
                    region: '',
                    date1: '',
                    date2: '',
                    delivery: false,
                    type: [],
                    resource: '',
                    desc: ''
                }
            }
        },
        methods:{
            submitNote(){

            },
            resetForm(formName) {
                this.$refs[formName].resetFields()
            },
            tableRowClassName({row, rowIndex}) {
                if (rowIndex === 1) {
                    return 'warning-row';
                } else if (rowIndex === 3) {
                    return 'success-row';
                }
                return '';
            }
        }



    });


</script>

</html>
