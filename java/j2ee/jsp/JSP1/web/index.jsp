<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%!
    private String path;
    private String ip;
    private Timestamp now;
%>

<%
    path = request.getContextPath();
    ip = request.getRemoteHost();
    now = new Timestamp(System.currentTimeMillis());
%>

<%!
    private String formatTime(Timestamp ts) {
        SimpleDateFormat sfd = new SimpleDateFormat("dd MM yyyy, HH:mm:ss");
        return sfd.format(ts);
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>
        <table border="2">
            <thead bgcolor="#005577">
                <td>Info</td>
                <td>Value</td>
            </thead>
            <tr>
                <td>Server Time</td>
                <td> <%=formatTime(now) %> </td>
            </tr>
            <tr>
                <td>Context Path</td>
                <td> <%=path %> </td>
            </tr>
            <tr>
                <td>Remote Host</td>
                <td> <%=ip %> </td>
            </tr>
            <tr>
                <td>Remote Address</td>
                <td> <%=request.getRemoteAddr() %> </td>
            </tr>
            <tr>
                <td>Remote User</td>
                <td> <%=request.getRemoteUser() %> </td>
            </tr>
            <tr>
                <td>Remote URI</td>
                <td> <%=request.getRequestURI() %> </td>
            </tr>
        </table>


    </body>
    
</html>
