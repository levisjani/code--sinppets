import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author levis
 */
public class DBAccess {
    
    public static final String SERVER = "jdbc:mysql://localhost:3306/";
    public static final String SCHEMA = "world";
    public static final String USER = "root";
    public static final String PASS = "eltonelt";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    Connection conn = null;

    public DBAccess() {
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBAccess t = new DBAccess();
        t.test();
    }

    public void test() {
        try {
            conn = DriverManager.getConnection(SERVER + SCHEMA, USER, PASS);
            conn.setAutoCommit(false);
            
            //testUpdate();
            testSelect();
            //testInsertRight();
            //testDelete();
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void testSelect() throws SQLException {
        PreparedStatement st = conn.prepareStatement("select * from country");
        ResultSet rs = st.executeQuery();
        System.out.println("Countries in Country table");
        while (rs.next()) {
            String code     = rs.getString  ("Code"         );
            String name     = rs.getString  ("Name"         );
            String surname  = rs.getString  ("Continent"    );
            int population  = rs.getInt     ("Population"   );
            System.out.printf("%10s %50s %20s %10d\n", code, name, surname, population);
        }
    }

    private void testInsertWrong() throws SQLException {
        String sql = "insert into city(Name,       CountryCode, District, Population) "+
                               "values('Elbasan', 'ALB',       'Elbasan', 180000)";
        PreparedStatement st = conn.prepareStatement(sql);
        int rows = st.executeUpdate();
        System.out.println(rows + " records were successfully inserted into the table");
    }

    private void testInsertRight() throws SQLException {
        String sql = "insert into city(Name, CountryCode, District, Population) values(?, ?, ?, ?)";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, "Durres");
        st.setString(2, "ALB");
        st.setString(3, "Durres");
        st.setInt   (4, 200000);
        int rows = st.executeUpdate();
        System.out.println(rows + " records were successfully inserted into the table");
        conn.commit();
     }

    private void testUpdate() throws SQLException {
        //what if there are more than one city with the same name (e.g. Cambridge)
        PreparedStatement st = conn.prepareStatement("update city set population = ? where Name = ?");
        st.setDouble(1, 500000);
        st.setString(2, "Tirana");
        int rows = st.executeUpdate();
        System.out.println(rows + " records were successfully updated");
    }

    private void testDelete() throws SQLException {
        PreparedStatement st = conn.prepareStatement("delete from city where id = ?");
        st.setLong(1, 4081);
        int rows = st.executeUpdate();
        System.out.println(rows + " records were successfully deleted from the table");
    }
}
