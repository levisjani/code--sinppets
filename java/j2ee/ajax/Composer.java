/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ajax;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Composer {

    private String id;
    private String firstName;
    private String lastName;
    private String category;

    public Composer (String id, String firstName, String lastName, String category) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.category = category;
    }

    Composer(ResultSet rs) throws SQLException {
        this(rs.getString("id") 
            ,rs.getString("first_name") 
            ,rs.getString("last_name") 
            ,rs.getString("era"));
    }

    public String getCategory() {
        return category;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
