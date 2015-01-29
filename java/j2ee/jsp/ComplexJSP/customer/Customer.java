/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unyt.customer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author elton.ballhysa
 */
public class Customer {
    
    private int id;
    private String discountCode;
    private String zip;
    private String name;
    private String addresLine1;
    private String addresLine2;
    private String city;
    private String state;
    private String phone;
    private String fax;
    private String email;
    private double creditLimit;

    public Customer(ResultSet rs) throws SQLException {
        this.id = rs.getInt("CUSTOMER_ID");
        this.discountCode = rs.getString("DISCOUNT_CODE");
        this.zip = rs.getString("ZIP");
        this.name = rs.getString("NAME");
        this.addresLine1 = rs.getString("ADDRESSLINE1");
        this.addresLine2 = rs.getString("ADDRESSLINE2");
        this.city = rs.getString("CITY");
        this.state = rs.getString("STATE");
        this.phone = rs.getString("PHONE");
        this.fax = rs.getString("FAX");
        this.email = rs.getString("EMAIL");
        this.creditLimit = rs.getDouble("CREDIT_LIMIT");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddresLine1() {
        return addresLine1;
    }

    public void setAddresLine1(String addresLine1) {
        this.addresLine1 = addresLine1;
    }

    public String getAddresLine2() {
        return addresLine2;
    }

    public void setAddresLine2(String addresLine2) {
        this.addresLine2 = addresLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
    
    
    
}
