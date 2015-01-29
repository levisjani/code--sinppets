import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author levis.jani
 */
public class AuthenticateServlet extends HttpServlet {
   


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
        doPost(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //Connection conn = null;
        try {
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            /*
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/books", "test", "test");
            */
            RequestDispatcher dispatcher;
            if (isValid(user, pass)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);
                dispatcher = request.getRequestDispatcher("selection.jsp");
            } else {
                dispatcher = request.getRequestDispatcher("error.jsp");
            }
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally { 
            out.close();
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean isValid(String user, String pass) {
        return !user.isEmpty() && !pass.isEmpty();
    }

    private boolean isValid(Connection conn, String user, String pass) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String sql = "select * from app.userfile t where t.user_name = ? and t.password = ?";
            st = conn.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            rs = st.executeQuery();
            return rs.next();
        } finally {
            if (rs != null) rs.close();
            if (st != null) st.close();
        }
    }

}
