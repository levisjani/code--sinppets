<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
    String user = request.getParameter("username");
    if (user==null)
        user="";
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Please enter your login credentials</h1>
        <hr>
        <form name="frmLogin" action="authenticate" method="POST">
        <table>
            <tr>
                <td>User name</td>
                <td><input type="text" name="username" value="<%=user%>"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Login"></td>
            </tr>
        </table>
        </form>
    </body>
</html>
