<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table>
    <tr>
        <td>Id</td>
        <td><c:out value="${param.id}"/></td>
    </tr>
    <tr>
        <td>Title</td>
        <td><c:out value="${param.title}"/></td>
    </tr>
    <tr>
        <td colspan="2"><c:out value="${param.text}"/></td>
    </tr>
</table>