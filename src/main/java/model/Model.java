/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lucuria
 */
public class Model {

    final String DB_URL = "jdbc:mariadb://localhost:3306/ukk";
    final String USER = "root";
    final String PASS = "";

    public String TABLE = "";

    Connection conn;

    //  Init Database
    Model() {
        try {
            this.conn = DriverManager.getConnection(this.DB_URL + "?user=" + this.USER + "&password=" + this.PASS);
        } catch (SQLException e) {
            System.out.println("Error connect DB -> " + e);
        }
    }

    public ResultSet findAll() {
        String query = "SELECT * FROM " + this.TABLE + " ORDER BY id DESC";

        try {
            return this.conn.createStatement().executeQuery(query);
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Error query: " + exception.getMessage());
            return null;
        }
    }

    public ResultSet findWhere(String field, String value) throws SQLException {
        // query SQL
        String query = String.format("SELECT * FROM %s WHERE %s = ?", this.TABLE, field);

        // statement
        PreparedStatement stmt = this.conn.prepareStatement(query);
        // replace ? with value
        stmt.setString(1, value);
        // execute query
        return stmt.executeQuery();
    }

}
