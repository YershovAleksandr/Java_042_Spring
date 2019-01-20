<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>

<%

ArrayList<String> bar = new ArrayList<>();

bar.add(new String("Foo"));
bar.add(new String("Bar"));
bar.add(new String("Baz"));

pageContext.setAttribute("foo", bar);


%>

<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<head>
<body>
    <h1></h1>
    <p>The time on the server is ${serverTime}.</p>

    <h2>${usr.id}</h2>
    <%--
    <c:forEach items="${users}" var="user">
    <h2>${user.id}</h2>
    <h2>${user.name}</h2>
    </c:forEach>
    --%>

    <hr>
    <table>
    <tr>
        <th>1</th>
        <th>2</th>
        <th>3</th>
    </tr>
    <tr>
        <c:forEach var ="var" items="${foo}">
        <td>${var}</td>
        </c:forEach>
    </tr>
    </table>

</body>
</html>