/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
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
public class PengembalianModel extends Model {

    public int id;
    public int id_user;
    public String nama;
    public String judul;
    public Date tanggal_pinjam;
    public Date tanggal_kembali;
    public int denda;
    public String status;

    public ResultSet findAll() {
        try {
            String query = "SELECT p.id, u.nama, b.judul, p.tanggal_pinjam, p.tanggal_kembali, p.denda, p.status FROM pengembalian AS p"
                    + " INNER JOIN buku AS b ON p.id_buku = b.id "
                    + " INNER JOIN user AS u ON p.id_user = u.id";
            return conn.createStatement().executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(PengembalianModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int editRow(PengembalianModel data) {
        try {
            // query SQL
            String query = "UPDATE pengembalian SET status = ?, denda = ? WHERE id = ?";

            // prepare statement
            PreparedStatement stmt = this.conn.prepareStatement(query);
            stmt.setString(1, data.status);
            stmt.setInt(2, data.denda);
            stmt.setInt(3, data.id);

            return stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PengembalianModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int deleteRow(int id) {
        try {
            // query SQL
            String query = "DELETE FROM pengembalian WHERE id = ?";

            // prepare statement
            PreparedStatement stmt = this.conn.prepareStatement(query);
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PengembalianModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public void injectRow(DefaultTableModel defaultTableModel, ResultSet data) {
        int i = 1;
        try {
            while (data.next()) {
                defaultTableModel.addRow(new Object[]{
                    data.getString("id"),
                    data.getString("nama"),
                    data.getString("judul"),
                    data.getString("tanggal_pinjam"),
                    data.getString("tanggal_kembali"),
                    data.getString("denda"),
                    data.getString("status")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(BukuModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
