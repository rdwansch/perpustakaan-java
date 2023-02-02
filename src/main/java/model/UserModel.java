/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucuria
 */
public class UserModel extends Model {

    public String nama;
    public String password;
    public String username;

    public UserModel() {
        TABLE = "user";
    }

    public boolean findWithUsernameAndPassword(String username, String password) {
        try {
            // query SQL
            String query = String.format("SELECT * FROM %s WHERE username = ? AND password = ?", this.TABLE);

            // statement
            PreparedStatement stmt = this.conn.prepareStatement(query);

            // replace ? with value
            stmt.setString(1, username);
            stmt.setString(2, password);

            // execute query
            ResultSet data = stmt.executeQuery();

            while (data.next()) {
                this.username = data.getString("username");
                this.password = data.getString("password");
                return true;
            }

            return false;
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

}
