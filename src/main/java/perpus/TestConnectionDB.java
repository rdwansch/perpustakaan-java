/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpus;

import java.sql.*;

/**
 *
 * @author lucuria
 */
public class TestConnectionDB {

    static final String DB_URL = "jdbc:mariadb://localhost:3306/ukk";
    static final String USER = "root";
    static final String PASS = "";
    static final String QUERY = "SELECT * FROM user";

    public static void main(String[] args) {
        System.out.println("Run File: perpus.TestConnectionDB.main()");
        try ( Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                System.out.print(", Nama: " + rs.getString("nama"));
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
    }
}
