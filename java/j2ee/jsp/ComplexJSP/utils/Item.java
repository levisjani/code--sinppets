/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package unyt.utils;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author elton
 */
public class Item implements Serializable {
    private String id;
    private String name;
    private double unitPrice;
    private String type; 

    public Item(String id, String type, String name, double unitPrice) {
        setId(id);
        setName(name);
        setUnitPrice(unitPrice);
        setType(type);
    }

    public Item(ResultSet rs) throws SQLException {
        setId(rs.getString("item_id"));
        setName(rs.getString("name"));
        setType(rs.getString("type"));
        setUnitPrice(rs.getDouble("unit_price"));
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (! (obj instanceof Item))
            return false;

        Item itObj = (Item) obj;
        return this.getId().equals(itObj.getId());
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        return (int) unitPrice + name.hashCode() + id.hashCode();
    }
}
