<%--
  Created by IntelliJ IDEA.
  User: 朱浩聪
  Date: 2019/12/27
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Hello 朱先生

    <form action="${pageContext.request.contextPath}/tc2/test4" method="post">
        <input type="text" name="userList[0].username"><br>
        <input type="text" name="userList[0].age"><br>
        <input type="text" name="userList[1].username"><br>
        <input type="text" name="userList[1].age"><br>
        <input type="submit" value="提交"><br>
    </form>
</body>

<script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script>
    var userList = new Array();
    userList.push({"username":"zhangsan","age":18});
    userList.push({"username":"lisi","age":16});

    $.ajax({
        type:"POST",
        url:"${pageContext.request.contextPath}/tc2/test5",
        data:JSON.stringify(userList),
        contentType:"application/json;charset=UTF-8"
    });

</script>

</html>
