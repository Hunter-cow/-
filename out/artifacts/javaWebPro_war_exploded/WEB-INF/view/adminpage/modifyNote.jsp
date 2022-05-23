
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="top.jsp"/>
    <form action="${pageContext.request.contextPath}/admin/modifyNote.do" method="post">
    <center>
        <table>
            <input type="hidden" name="id" value="${note.id}"/>
            <tr>
                <td>标题:</td>
                <td><input type="text" name="Title" value="${note.title}"/></td>
            </tr>
            <tr>
                <td>内容:</td>
                <td><input type="text" name="Content" value="${note.content}"/></td>
            </tr>
            <tr>
                <td><input type="reset" value="重置"/></td>
                <td><input type="submit" value="修改"/></td>
            </tr>
        </table>
    </center>
    </form>
    <jsp:include page="right.jsp"/>
</body>
</html>
