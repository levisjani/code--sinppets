<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="unyt.utils.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
    String id = request.getParameter("id");
    Item item = General.findItem(id);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Details Page</title>
    </head>
    <body>
        <h1>Item Details</h1>
        <hr>
        <form name="frmDetail" action="add.jsp">
            <input type="hidden" name="id" value="<%=item.getId()%>">
            <table border="2">
            <tr>
                <td bgcolor="#335522">Item Id</td>
                <td><%= item.getId() %> </td>
            </tr>
            <tr>
                <td bgcolor="#335522">Name</td>
                <td><%= item.getName() %></td>
            </tr>
            <tr>
                <td bgcolor="#335522">Unit Price</td>
                <td><%= item.getUnitPrice()%> </td>
            </tr>
            <tr>
                <td bgcolor="#335522">Quantity</td>
                <td><input type="text" name="quantity"></td>
            </tr>

            <tr>
                <td colspan="2"> <input type="submit" value="Add to Cart"> </td>
            </tr>
            </table>
        </form>
    </body>
</html>
