/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package unyt.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unyt.utils.General;
import unyt.utils.Item;

/**
 *
 * @author elton
 */
public class SelectionServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SelectionServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<table border=\"2\">");
            out.println("<thead bgcolor=\"#335522\">");
                out.println("<td>Item Id</td>");
                out.println("<td>Name</td>");
                out.println("<td>Unit Price</td>");
            out.println("</thead>");

            List<Item> items = General.itemsList();
            for (Item it : items) {
                out.println("<tr>");
                String id = it.getId();
                String hyperlink = General.hyperlink(id, "detail?id="+id);
                out.println("<td>" + hyperlink + "</td>");
                out.println("<td>" + it.getName() + "</td>");
                out.println("<td>" + it.getUnitPrice() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");

            HttpSession session = request.getSession();
            HashMap<Item, Integer> cart = (HashMap<Item, Integer>) session.getAttribute("cart");
            if ( ! cart.isEmpty() ) {
                String cartLink = General.hyperlink("Cart Content", "cart");
                out.println("<p>");
                out.println(cartLink);

                String paymentLink = General.hyperlink("Payment", "payment");
                out.println("<p>");
                out.println("Proceed to " + paymentLink + " Page");
            }

            out.println("</body>");
            out.println("</html>");
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
