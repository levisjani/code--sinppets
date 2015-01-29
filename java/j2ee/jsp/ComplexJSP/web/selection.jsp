<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="unyt.utils.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
    String user = (String) session.getAttribute("user");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to our store, <%=user%></h1>
        <p>
        <table border="2">
            <thead bgcolor="#335522">
                <td>Item Id</td>
                <td>Name</td>
                <td>Unit Price</td>
                <td>Type</td>
            </thead>
<%
            List<Item> items = General.itemsList();
            for (Item it : items) {
                String id = it.getId();
                String hyperlink = General.hyperlink(id, "details.jsp?id="+id);
%>
                <tr>
                    <td><%=hyperlink%></td>
                    <td><%=it.getName() %></td>
                    <td><%=it.getUnitPrice() %></td>
                    <td><%=it.getType() %></td>
                </tr>
<%
            }
%>
            </table>

            <p>
            <a href="cart.jsp">Check cart content</a>  
            <p>
            Proceed to <a href="payment.jsp">Payment</a>  Page

    </body>
</html>
