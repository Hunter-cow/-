
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="top.jsp"%>
<div>

    <form style="text-align: center" action="${pageContext.request.contextPath}/student/addBlog" method="post">
        <input type="hidden" name="sid" value="${student.code}">
        日志标题:<input type="text" name="blogName" /><br/>
        日志内容:<textarea name="blogCover" cols="20" rows="5"></textarea><br/>
        <input type="reset" value="重置"><input type="submit" value="提交"/>
    </form>
</div>

<%@include file="right.jsp"%>


</body>
</html>
