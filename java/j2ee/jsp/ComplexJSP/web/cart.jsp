<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="unyt.utils.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Content</title>
    </head>
    <body>
        <%
            HashMap<Item, Integer> cart = (HashMap<Item, Integer>) session.getAttribute("cart"); 
            if (cart == null || cart.isEmpty()) {
        %>
            <h1>Your cart is empty</h1>
        <%
            } else {
        %>
            <table>
                <thead> 
                    <td>Id</td>
                    <td>Name</td>
                    <td>Quantity</td>
                    <td>Unit Price</td>
                </thead>
        <%
                Set<Item> items = cart.keySet();
                for (Item it : items) {
                    int quantity = cart.get(it);
        %>
                <tr>
                    <td><%= it.getId() %></td>
                    <td><%= it.getName() %></td>
                    <td><%= quantity %></td>
                    <td><%= it.getUnitPrice()%></td>
                </tr>    
        <%            
                } 
        %>
            </table>
        <%
            }            
        %>
        <% if (cart != null && !cart.isEmpty()) { %>
            <a href="resetCart">Reset</a>
            <a href="payment.jsp">Payment</a>
        <% } %>
            <a href="selection.jsp">Back</a>
        
    </body>
</html>
