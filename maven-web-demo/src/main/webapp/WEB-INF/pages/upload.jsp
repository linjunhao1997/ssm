<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>

    <title>Title</title>
</head>
<body>
<form:form action="test/upload" enctype="multipart/form-data">
    <input type="file" name="file" id="img" /><br>
    <%--<img src="#" id="ser" >--%>
    <input type="submit" value="上传图片" />
</form:form>

</body>
</html>
