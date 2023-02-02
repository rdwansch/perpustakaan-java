/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;

/**
 *
 * @author lucuria
 */
public class BukuModel extends Model {

    String judul;
    String penerbit;

    public BukuModel() {
        TABLE = "buku";
    }
}
