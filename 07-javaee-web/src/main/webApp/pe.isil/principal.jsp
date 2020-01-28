<%--
  Created by IntelliJ IDEA.
  User: Alumno
  Date: 25/01/2020
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Principal</title>
</head>
<body>

<table border="1">

    <tr>
        <td colspan="3">
            <jsp:include page="/resource/jsp/header.jsp"></jsp:include>
        </td>
    </tr>
    <tr>
        <td>
            <jsp:include page="/resource/jsp/menu.jsp"></jsp:include>
        </td>
        <td>
            <jsp:include page="${requestScope.pageInclude}" ></jsp:include>
        </td>
        <td>
        </td>
    </tr>
    <tr>
        <td colspan="3">
            <jsp:include page="/resource/jsp/footer.jsp"></jsp:include>
        </td>
    </tr>

</table>

</body>
</html>
