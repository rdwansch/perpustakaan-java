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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucuria
 */
public class BukuModel extends Model {

    public String kategori;
    public String judul;
    public int tahun;
    public String penerbit;
    public int jumlah;
    public String status;
    public String kode;

    public BukuModel() {
        TABLE = "buku";

    }

    public ResultSet searchBy(String field, String value) {
        try {
            // query SQL
            String query = "SELECT * FROM " + this.TABLE + " WHERE " + field + " LIKE ?";

            // prepare statement
            PreparedStatement stmt = this.conn.prepareStatement(query);

            // replace ? with value
            stmt.setString(1, "%" + value + "%");

            return stmt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(BukuModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        }
    }

    public boolean insertRow(BukuModel data) {
        try {
            // query SQL
            String query = "INSERT INTO buku (id, judul, tahun, penerbit, jumlah, status, kode) VALUES (?,?,?,?,?,?,?)";

            // prepare statement
            PreparedStatement stmt = this.conn.prepareStatement(query);

            // replace ? with value
            stmt.setString(1, data.kategori);
            stmt.setString(2, data.judul);
            stmt.setInt(3, data.tahun);
            stmt.setString(4, data.penerbit);
            stmt.setInt(5, data.jumlah);
            stmt.setString(6, data.status);
            stmt.setString(7, data.kode);

            int rowAffected = stmt.executeUpdate();

            return rowAffected > 0;

        } catch (SQLException ex) {
            Logger.getLogger(BukuModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public int editRow(BukuModel data) {
        try {
            // query SQL
            String query = "UPDATE buku SET kategori = ?, judul = ?, tahun = ?, penerbit = ?, jumlah = ?, status = ?, kode = ? WHERE id = ?";

            // prepare statement
            PreparedStatement stmt = this.conn.prepareStatement(query);
            stmt.setString(1, data.kategori);
            stmt.setString(2, data.judul);
            stmt.setInt(3, data.tahun);
            stmt.setString(1, data.penerbit);
            stmt.setInt(1, data.jumlah);
            stmt.setString(1, data.status);
            stmt.setString(1, data.kode);

            return stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BukuModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void injectRow(DefaultTableModel defaultTableModel, ResultSet data) {
        try {
            while (data.next()) {
                defaultTableModel.addRow(new Object[]{
                    data.getString("kategori"),
                    data.getString("judul"),
                    data.getString("tahun"),
                    data.getString("penerbit"),
                    data.getString("jumlah"),
                    data.getString("status"),
                    data.getString("kode")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(BukuModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
