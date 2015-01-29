import java.sql.*;
import java.util.*;

public class General {
        
    private static List<Item> items;
    
    static {
        initItems();
    }
    
    public static List<Item> itemsList() throws SQLException {
        return items;
        /*
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/books", "test", "test");
            String sql = "select i.* from app.item i";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Item it = new Item(rs);
                items.add(it);
            }        
            return items;
        } finally {            
            if (rs != null) rs.close();
            if (st != null) st.close();
            try {
                if (conn != null) conn.close(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
                */
    }
    
    public static void addItem(String id, String name, String type, double price) throws SQLException {
        items.add(new Item(id, type, name, price));
        /*
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/books", "test", "test");
            String sql = "insert into app.item (item_id, name, type, unit_price) values (?,?,?,?)";
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, name);
            st.setString(3, type);
            st.setDouble(4, price);
            st.executeUpdate();
        } finally {            
            if (st != null) st.close();
            try {
                if (conn != null) conn.close(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        */
    }

    public static String hyperlink(String text, String link) {
        return String.format("<a href=\"%s\">%s</a>", link, text);
    }

    public static Item findItem(String id) throws SQLException {
        for (Item item : items) {
            if (item.getId().equals(id))
                return item;
        }
        return null;
        /*
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/books", "test", "test");
            String sql = "select i.* from app.item i where i.item_id = ?";
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Item it = new Item(rs);
                return it;
            }        
            return null;
        } finally {            
            if (rs != null) rs.close();
            if (st != null) st.close();
            try {
                if (conn != null) conn.close(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        */
    }

    public static double calcTotal(HashMap<Item, Integer> cart) {
        double totPrice = .0;
        Set<Item> items = cart.keySet();
        for (Item it : items) {
            int quantity = cart.get(it);
            totPrice += quantity * it.getUnitPrice();
        }
        return totPrice;
    }

    public static void makePayment(String ccno, double totPrice) {
        // the business code for payment processing will go here
    }

    private static void initItems() {
        items = new ArrayList<Item>();
        items.add(new Item("111-22222", "Book", "The unbearable lightness of being", 9.99));
        items.add(new Item("222-12435", "DVD", "The Godfather 1", 6.99));
        items.add(new Item("222-12436", "DVD", "The Godfather 2", 6.99));
        items.add(new Item("333-64212", "Book", "Core JavaServer Faces", 12.00));
        items.add(new Item("444-20123", "CD", "Images & Words", 7.99));
    }

}
