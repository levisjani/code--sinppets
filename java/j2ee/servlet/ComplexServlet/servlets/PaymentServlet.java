import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unyt.utils.Item;


public class PaymentServlet extends HttpServlet {
   
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
        HttpSession session = request.getSession();
        try {
            HashMap<Item, Integer> cart = (HashMap<Item, Integer>) session.getAttribute("cart");

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PaymentServlet</title>");  
            out.println("</head>");
            out.println("<body>");

            out.println("Currently the cart contains");
            out.println("<hr>");

            out.println("<table border=\"2\">");
            out.println("<thead bgcolor=\"#335522\">");
                out.println("<td>Item Id</td>");
                out.println("<td>Quantity</td>");
            out.println("</thead>");

            Set<Item> items = cart.keySet();
            double totPrice = .0;
            for (Item it : items) {
                int quantity = cart.get(it);
                totPrice += quantity * it.getUnitPrice();
                out.println("<tr>");
                out.println("<td>" + it.getId() + "/" + it.getName() + "</td>");
                out.println("<td>" + quantity + "</td>");
                out.println("</tr>");
            }
            out.println("<tfoot>");
                out.println("<td bgcolor=\"#335522\">Total</td>");
                out.println("<td><b>" + totPrice + "</></td>");
            out.println("</tfoot>");
            out.println("</table>");

            out.println("<form name=\"frmPayment\" action=\"confirm\">");
            out.println("<table border=\"2\">");
            out.println("<tr>");
                out.println("<td bgcolor=\"#335522\">Cardholder</td>");
                out.println("<td>" + "<input type=\"text\" name=\"name\">" + "</td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td bgcolor=\"#335522\">Card Number</td>");
                out.println("<td>" + "<input type=\"text\" name=\"ccno\">" + "</td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td bgcolor=\"#335522\">Security Code</td>");
                out.println("<td>" + "<input type=\"text\" name=\"cvc\">" + "</td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td bgcolor=\"#335522\">Expiration</td>");
                out.println("<td>" + "<input type=\"text\" name=\"expire\">" + "</td>");
            out.println("</tr>");
            String btnPay = "<input type=\"submit\" value=\"Make Payment\">";
            out.println("<tr>");
                out.println("<td colspan=\"2\">" + btnPay + "</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");


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
