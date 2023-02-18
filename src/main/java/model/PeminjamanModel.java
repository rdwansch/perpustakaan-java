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
public class PeminjamanModel extends Model {

    public int id;
    public int id_user;
    public int durasi;
    public String nama;
    public String judul;
    public Date tanggal_pinjam;
    public String status;
    public String kode;
    public int jumlah_buku;

    public ResultSet findAll() {
        try {
            String query = "SELECT p.id, u.nama, b.judul, p.durasi, p.tanggal_pinjam, p.status, p.jumlah_buku, b.kode FROM peminjaman AS p"
                    + " INNER JOIN buku AS b ON p.id_buku = b.id "
                    + " INNER JOIN user AS u ON p.id_user = u.id";
            return conn.createStatement().executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int editRow(PeminjamanModel data) {
        try {
            // query SQL
            String query = "UPDATE peminjaman SET status = ? WHERE id = ?";

            // prepare statement
            PreparedStatement stmt = this.conn.prepareStatement(query);
            stmt.setString(1, data.status);
            stmt.setInt(2, data.id);

            return stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int deleteRow(int id) {
        try {
            // query SQL
            String query = "DELETE FROM peminjaman WHERE id = ?";

            // prepare statement
            PreparedStatement stmt = this.conn.prepareStatement(query);
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanModel.class.getName()).log(Level.SEVERE, null, ex);
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
                    data.getString("durasi"),
                    data.getString("tanggal_pinjam"),
                    data.getString("jumlah_buku"),
                    data.getString("kode"),
                    data.getString("status")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(BukuModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
