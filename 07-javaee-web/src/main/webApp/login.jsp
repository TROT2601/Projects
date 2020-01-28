<%--
  Created by IntelliJ IDEA.
  User: Alumno
  Date: 25/01/2020
  Time: 09:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form name="frmLogin" action="login.do" method="post">

    <div>
        <table align="center" border="1">

            <tr>
                <td colspan="2">

                    <div align="center">Acceso al Sistema</div>
                </td>
            </tr>
            <tr>
                <td>Usuario:</td>
                <td> <input type="text" name="txtLogin"> </td>
            </tr>
            <tr>
                <td>Contraseña:</td>
                <td> <input type="password" name="txtPassword"> </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div align="right">
                        <input type="submit" value="Aceptar" name="btnAceptar">
                        <input type="reset" value="Limpiar" >
                    </div>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <div align="center">
                        <%
                            String message = (String) request.getAttribute("message");
                            if(message != null){
                        %>
                        <%=message%>
                        <%
                            }
                        %>

                    </div>
                </td>
            </tr>

        </table>

    </div>

</form>


</body>
</html>
