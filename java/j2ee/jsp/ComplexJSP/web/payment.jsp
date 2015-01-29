<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="unyt.utils.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
    HashMap<Item, Integer> cart = (HashMap<Item, Integer>) session.getAttribute("cart");
    if (cart == null) { 
%>
        <jsp:forward page="selection.jsp" />
<%
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Page</title>
    </head>
    <body>
        Currently the cart contains
        <hr>

        <table border="2">
            <thead bgcolor="#335522">
                <td>Item Id</td>
                <td>Quantity</td>
            </thead>
        <%
            Set<Item> items = cart.keySet();
            double totPrice = .0;
            for (Item it : items) {
                int quantity = cart.get(it);
                totPrice += quantity * it.getUnitPrice();
         %>
            <tr>
                <td><%= it.getId() + "/" + it.getName() %> </td>
                <td><%= quantity %> </td>
            </tr>
        <%
            }
        %>
            <tfoot>
                <td bgcolor="#335522">Total</td>
                <td><b> <%= totPrice %></b></td>
            </tfoot>
        </table>

        <form name="frmPayment" action="confirm.jsp">
        <table border="2">
            <tr>
                <td bgcolor="#335522">Cardholder</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td bgcolor="#335522">Card Number</td>
                <td><input type="text" name="ccno"></td>
            </tr>
            <tr>
                <td bgcolor="#335522">Security Code</td>
                <td><input type="text" name="cvc"></td>
            </tr>
            <tr>
                <td bgcolor="#335522">Expiration</td>
                <td><input type="text" name="expire"></td>
            </tr>
            
            <tr>
                <td colspan="2"> <input type="submit" value="Make Payment"> </td>
            </tr>
        </table>
        </form>
    </body>
</html>
