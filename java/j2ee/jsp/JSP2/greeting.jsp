<!DOCTYPE html>
<html>
    <%
        String name = request.getParameter("first_name");
        String surname = request.getParameter("last_name");
        String fullname = name + " " + surname;
    %>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <%=fullname%></h1>
        <h1>Time at server <%=new Date()%></h1>
        <p>
            <a href="index.jsp"> Start Over </a>
        </p>
    </body>
</html>
