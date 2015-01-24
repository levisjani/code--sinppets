/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ajax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author elton
 */
public class ComposerData {

    private HashMap<String, Composer> composers; 

    public HashMap getComposers() {
        return composers;
    }

    public ComposerData() {
        composers = new HashMap<String, Composer>();
        try {
            loadComposers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addComposer(Composer c) {
        composers.put(c.getId(), c);
    }

    private void loadComposers() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "eltonelt");
        String sql = "select * from composers";
        PreparedStatement st = conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while (rs.next()) 
            addComposer(new Composer(rs));
        rs.close();
        st.close();
        conn.close();
    }


}
