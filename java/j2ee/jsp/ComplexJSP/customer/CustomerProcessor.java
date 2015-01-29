import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author levis.jani
 */
public class CustomerProcessor {
    
    private HttpServletRequest request; 
    private HttpServletResponse response;
    
    public CustomerProcessor(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }
    
    public List<Customer> retrieveAllCustomers() throws Exception {
        List<Customer> customers = new ArrayList<Customer>();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String sortColumn = request.getParameter("sortColumn");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String sql = "select * from customer";
            if (sortColumn != null && !sortColumn.isEmpty())
                sql += " order by " + sortColumn;
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app"); 
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next())  {
                Customer currCustomer = new Customer(rs);
                customers.add(currCustomer);
            }
            return customers;
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
