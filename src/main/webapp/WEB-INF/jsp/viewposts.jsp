<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Posts</title>
<style>

h3 {
    text-align: center;
}

table, td {
    border: 0px;
}

table {
    background-color: gray;
    width: 600px;
    margin: auto;
}

.tableid {
    background-color: red;
    width: 20px;
    text-align: center;
}

.tabletitle {
    text-align: center;
    background-color: #AAAAAA;
}

form {
    margin: auto;
}

</style>
</head>
<body>



<p>
<h3>Title Foo = ${foo}</h3>

<!-- -->

<c:forEach items="${posts}" var="post">

<jsp:include page="post.jsp">
    <jsp:param name="id" value="${post.getId()}" />
    <jsp:param name="title" value="${post.getTitle()}" />
    <jsp:param name="text" value="${post.getText()}" />
</jsp:include>


<br>

</c:forEach>

<!-- -->

</p>

<jsp:include page="postform.jsp" />

</body>
</html>