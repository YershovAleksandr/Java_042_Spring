<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>View Posts</title>
<style>

h3{
    text-align: center;
}

table, td{
    border: 1px solid black;
}

table {
    background-color: gray;
    border-collapse: collapse;
    width: 600px;
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



</body>
</html>