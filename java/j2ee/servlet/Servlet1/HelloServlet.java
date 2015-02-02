import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author levis
 */
public class HelloServlet extends HttpServlet {
   
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
            out.println("<title>Servlet HelloServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hello World</h1>");
            out.println("<p>");
            out.println("<table border=\"2\">");
            out.println("<thead bgcolor=\"#005577\">");
            out.println("<td>Info</td>");
            out.println("<td>Value</td>");
            out.println("</thead>");
            out.println("<tr>");
            out.println("<td>Context Path</td>");
            out.println("<td>" + request.getContextPath() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Remote Host</td>");
            out.println("<td>" + request.getRemoteHost() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Remote Address</td>");
            out.println("<td>" + request.getRemoteAddr() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Remote User</td>");
            out.println("<td>" + request.getRemoteUser() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Request URI</td>");
            out.println("<td>" + request.getRequestURI() + "</td>");
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
