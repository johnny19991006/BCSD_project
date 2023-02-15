<%--
  Created by IntelliJ IDEA.
  User: polic
  Date: 12/28/2022
  Time: 12:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>게시물 작성폼</title>
</head>

<style>

    .layout {
        width : 500px;
        margin : 0 auto;
        margin-top : 40px;
    }

    .layout input {
        width : 100%;
        box-sizing : border-box
    }

    .layout textarea {
        width : 100%;
        margin-top : 10px;
        min-height : 300px;
    }

</style>

<body>
<div class="layout">
    <form action="/board/writepro" method="post" enctype="multipart/form-data">
        <input name="boardTitle" type="text">
        <textarea name="content"></textarea>
        <input type="file" name="file">
        <button type="submit">작성</button>
    </form>
</div>
</body>
</html>