<%@page import="java.util.List"%>
<%@page import="unyt.customer.Customer"%>
<%@page import="unyt.customer.CustomerProcessor"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Customers List</h1>
        <table border="1">
            <thead>
                <td><a href="customers.jsp?sortColumn=CUSTOMER_ID">ID</a></td>
                <td><a href="customers.jsp?sortColumn=DISCOUNT_CODE">DISCOUNT</a></td>
                <td><a href="customers.jsp?sortColumn=ZIP">ZIP</a></td>
                <td><a href="customers.jsp?sortColumn=NAME">NAME</a></td>
                <td><a href="customers.jsp?sortColumn=ADDRESSLINE1">ADDRESS</a></td>
                <td><a href="customers.jsp?sortColumn=CITY">CITY</a></td>
                <td><a href="customers.jsp?sortColumn=STATE">STATE</a></td>
                <td><a href="customers.jsp?sortColumn=PHONE">PHONE</a></td>
                <td><a href="customers.jsp?sortColumn=FAX">FAX</a></td>
                <td><a href="customers.jsp?sortColumn=EMAIL">EMAIL</a></td>
                <td><a href="customers.jsp?sortColumn=CREDIT_LIMIT">LIMIT</a></td>
            </thead>
        <% 
            CustomerProcessor processor = new CustomerProcessor(request, response);
            List<Customer> customers = processor.retrieveAllCustomers();
            for (Customer c : customers) {
        %>
            <tr>
                <td><%=c.getId()%></td>
                <td><%=c.getDiscountCode()%></td>
                <td><%=c.getZip()%></td>
                <td><%=c.getName()%></td>
                <td><%=c.getAddresLine1() + c.getAddresLine2()%></td>
                <td><%=c.getCity()%></td>
                <td><%=c.getState()%></td>
                <td><%=c.getPhone()%></td>
                <td><%=c.getFax()%></td>
                <td><%=c.getEmail()%></td>
                <td><%=c.getCreditLimit()%></td>
            </tr>
        <%  } %>
    </table>
    </body>
</html>
