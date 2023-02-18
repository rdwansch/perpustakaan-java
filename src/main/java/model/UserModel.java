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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucuria
 */
public class UserModel extends Model {

    public String nama;
    public String password;
    public String username;
    public String alamat;
    public String nomor_telepon;
    public String role;
    public String uid;

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
                this.role = data.getString("role");
                return true;
            }

            return false;
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    public ResultSet searchBy(String field, String value) {
        try {
            String query = "SELECT * FROM " + this.TABLE + " WHERE " + field + " LIKE ?";
            // prepare statement
            PreparedStatement stmt = this.conn.prepareStatement(query);
            // replace ? with value
            stmt.setString(1, "%" + value + "%");
            return stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean insertRow(UserModel data) {
        try {
            String query = "SELECT * FROM user WHERE uid = ?";
            PreparedStatement stmt = this.conn.prepareStatement(query);

            stmt.setString(1, data.uid);

            ResultSet user = stmt.executeQuery();

            if (user.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
                return false;
            }

            // query SQL
            query = "INSERT INTO user (nama, username, password, alamat, nomor_telepon, role) VALUES (?, ?, ?, ?, ?, ?)";

            // prepare statement
            stmt = this.conn.prepareStatement(query);

            // replace ? with value
            stmt.setString(1, data.nama);
            stmt.setString(2, data.username);
            stmt.setString(3, data.password);
            stmt.setString(4, data.alamat);
            stmt.setString(5, data.nomor_telepon);
            stmt.setString(6, data.role);

            int rowAffected = stmt.executeUpdate();

            return rowAffected > 0;

        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public int editRow(UserModel data) {
        try {
            // query SQL
            String query = "UPDATE user SET nama = ?, username = ?, password = ?, alamat = ?, nomor_telepon = ?, role = ? WHERE uid = ?";

            // prepare statement
            PreparedStatement stmt = this.conn.prepareStatement(query);
            stmt.setString(1, data.nama);
            stmt.setString(2, data.username);
            stmt.setString(3, data.password);
            stmt.setString(4, data.alamat);
            stmt.setString(5, data.nomor_telepon);
            stmt.setString(6, data.role);
            stmt.setString(7, data.uid);

            return stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public void injectRow(DefaultTableModel defaultTableModel, ResultSet data) {
        int i = 1;
        try {
            while (data.next()) {
                defaultTableModel.addRow(new Object[]{
                    i++,
                    data.getString("nama"),
                    data.getString("username"),
                    "$2a$12$287163/WVmTONhn7DyFuTuOWJpkvN16wT21l3g6yinB7phYZweF5W ",
                    data.getString("alamat"),
                    data.getString("nomor_telepon"),
                    data.getString("uid"),
                    data.getString("role")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int deleteRow(String uid) {
        try {
            String query = "DELETE FROM user WHERE uid = ?";
            PreparedStatement stmt = this.conn.prepareStatement(query);
            stmt.setString(1, uid);

            return stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

}
