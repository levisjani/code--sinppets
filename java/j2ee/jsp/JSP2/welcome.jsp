<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
    String user = request.getParameter("username");
    String pass = request.getParameter("password");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% if (isValid(user, pass)) { %>
            <h1>Welcome <%=user%></h1>
            <hr>
            Your password (<%=pass%>) was validated!

            <form name="form1" action="greeting.jsp" method="GET">
            <table>
                <tr>
                    <td>Your name</td>
                    <td><input type="text" name="first_name"></td>
                </tr>
                <tr>
                    <td>Your surname</td>                
                    <td><input type="text" name="last_name"></td>
                </tr>
                <tr colspan="2">
                    <td><input type="submit" value="Submit"> </td>
                </tr>
            </table>
            </form>
        <% } else { %>
            <h1>Error: Your login was not validated!</h1>
            <a href="login.jsp">Go Back</a>
        <% }  %>
    </body>
</html>

<%!
    public boolean isValid(String user, String pass) {
        return (pass != null && pass.length() >= 3);
    }
%>
