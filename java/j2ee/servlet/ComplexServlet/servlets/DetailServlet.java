import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import unyt.utils.General;
import unyt.utils.Item;

public class DetailServlet extends HttpServlet {
   
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

        String id = request.getParameter("id");
        Item item = General.findItem(id);
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Item Details</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h3>Item Details</h3>");
            out.println("<hr>");

            out.println("<form name=\"frmDetail\" action=\"add\">");
            out.println("<input type=\"hidden\" name=\"id\" value=\""+ item.getId() + "\">");
            out.println("<table border=\"2\">");
            out.println("<tr>");
                out.println("<td bgcolor=\"#335522\">Item Id</td>");
                out.println("<td>" + item.getId() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td bgcolor=\"#335522\">Name</td>");
                out.println("<td>" + item.getName() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td bgcolor=\"#335522\">Unit Price</td>");
                out.println("<td>" + item.getUnitPrice() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td bgcolor=\"#335522\">Quantity</td>");
                out.println("<td>" + "<input type=\"text\" name=\"quantity\">" + "</td>");
            out.println("</tr>");

            String btnAdd = "<input type=\"submit\" value=\"Add to my Cart\" onClick=\"functionName(parameter);\">";
            out.println("<tr>");
                out.println("<td colspan=\"2\">" + btnAdd + "</td>");
            out.println("</tr>");
            out.println("</table>");

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
