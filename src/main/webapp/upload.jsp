<%--
  Created by IntelliJ IDEA.
  User: 朱浩聪
  Date: 2019/12/28
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/upload/test3" method="post" enctype="multipart/form-data">
        名称：<input type="text" name="filename">
        文件1：<input type="file" name="file">
        文件2：<input type="file" name="file">
        <input type="submit" value="提交">
    </form>
</body>
</html>
