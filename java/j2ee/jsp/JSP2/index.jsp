<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:forward page="login.jsp">
            <jsp:param name="username" value="abc" />
        </jsp:forward>

        <h1>Forwarding to login.jsp</h1>
    </body>
</html>
