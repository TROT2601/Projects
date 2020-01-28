<%@ page import="pe.isil.security.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Alumno
  Date: 25/01/2020
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table border="1">

    <%
        User user = (User) request.getSession().getAttribute("usuario");
    %>
    <tr>
        <td>Bienvenido <%=user.getName() %> </td>
        <td></td>
        <td></td>
        <td>
            <div align="right">
                <span>
                    <a href="login.do">Cerrar Sesion</a>
                </span>
            </div>
        </td>
    </tr>


</table>