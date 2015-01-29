<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="unyt.utils.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
    HashMap cart = (HashMap) session.getAttribute("cart");
    double totPrice = General.calcTotal(cart);
    String ccno = request.getParameter("ccno");

    General.makePayment(ccno, totPrice);
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation Page</title>
    </head>
    <body>
        <h1>Payment processed</h1>
        <hr>
        Amount of <%= totPrice %> was debitted to your credit card (<%=ccno%>)
    </body>
</html>
