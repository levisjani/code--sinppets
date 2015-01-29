<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="unyt.utils.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
    String id = request.getParameter("id");
    Item item = General.findItem(id);
    int quantity = 0;
    try {
        quantity = Integer.parseInt(request.getParameter("quantity"));
    } catch (Exception e) {
        e.printStackTrace();
    }

    HashMap<Item, Integer> cart  = (HashMap<Item, Integer>) session.getAttribute("cart");
    if (cart == null) {
        cart = new HashMap<Item, Integer>();
    }

    if (cart.containsKey(item)) {
        int existingQuantity = cart.get(item);
        int newQuantity = existingQuantity + quantity;
        cart.put(item, newQuantity);
    } else {
        cart.put(item, quantity);
    }
    session.setAttribute("cart", cart);

    RequestDispatcher dispatcher = request.getRequestDispatcher("selection.jsp");
    dispatcher.forward(request, response);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Dispatching... <br>
        Item ID = <%=id%> <br>
        Item Name = <%=item.getName() %> <br>
        Quantity = <%=quantity %>
    </body>
</html>
