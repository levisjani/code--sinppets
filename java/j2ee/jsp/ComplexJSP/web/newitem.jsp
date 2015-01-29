<%@page import="java.sql.SQLException"%>
<%@page import="unyt.utils.Item"%>
<%@page import="unyt.utils.General"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if (request.getParameter("id") != null) {
                addItem(request);
            }
        %>
        <form name="frmItem" action="newitem.jsp">
            <table>
                <tr>
                    <td>Item ID</td>
                    <td><input type="text" name="id"></td>                    
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name"></td>                    
                </tr>
                <tr>
                    <td>Type</td>
                    <td>
                        <select name="type">
                            <option>Book</option>
                            <option>CD</option>
                            <option>DVD</option>
                            <option>Magazine</option>
                        </select> 
                    </td>                    
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price"></td>                    
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Add Item" ></td>
                </tr>
            </table>
        </form>
        
        <table>
            <thead>
                <td>Id</td>
                <td>Name</td>
                <td>Type</td>
                <td>Price</td>
            </thead>
        <%
            List<Item> items = General.itemsList();
            for (Item it : items) {
        %>
            <tr>    
                <td><%=it.getId() %></td>
                <td><%=it.getName() %></td>
                <td><%=it.getType() %></td>
                <td><%=it.getUnitPrice() %></td>
            </tr>    
        <%
            }
        %>
        </table>
        
    </body>
    
    <%! private void addItem(HttpServletRequest request ) throws SQLException {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            double price = Double.parseDouble(request.getParameter("price"));

            General.addItem(id, name, type, price);
        }   
    %> 
</html>
