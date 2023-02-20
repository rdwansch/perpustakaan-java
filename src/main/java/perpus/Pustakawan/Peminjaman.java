/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package perpus.Pustakawan;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BukuModel;
import model.PeminjamanModel;
import perpus.Login;
import java.sql.Date;

/**
 *
 * @author lucuria
 */
public class Peminjaman extends javax.swing.JFrame {

    final BukuModel bukuModel = new BukuModel();
    final PeminjamanModel peminjamanModel = new PeminjamanModel();
    DefaultTableModel defaultTableModel;

    public void clearRow() {
        if (defaultTableModel.getRowCount() != 0) {
            defaultTableModel.setRowCount(0);
        }
    }

    private void initData() {
        searchAlert.setText("");
        // fetch data
        ResultSet data = this.peminjamanModel.findAll();
        defaultTableModel = (DefaultTableModel) tabelPeminjaman.getModel();
        // clear data first
        clearRow();
        // then inject row
        this.peminjamanModel.injectRow(defaultTableModel, data);
    }

    private void searchTableAction() {
        try {

            searchAlert.setText("");

            // check if input is empty
            if (searchPeminjam.getText().equals("")) {
                initData();
                return;
            }

            // get value from comboBox
            String selectedValue = cmbSearchBuku.getSelectedItem().toString();
            // search and fetch data
            ResultSet data = this.bukuModel.searchBy(selectedValue, searchPeminjam.getText());

            // clear data first
            clearRow();

            // if data doesn't exist
            if (!data.isBeforeFirst()) {
                searchAlert.setText("Data tidak ada!");
                return;
            }

            // then inject row with new data
            this.bukuModel.injectRow(defaultTableModel, data);

        } catch (SQLException ex) {
            Logger.getLogger(Peminjaman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addSelectedRowToinput(PeminjamanModel data) {
        idPeminjaman.setText(data.id + "");
        namaPeminjam.setText(data.nama);
        judulPeminjam.setText(data.judul);
        durasiPeminjam.setText(data.durasi + "");
        jumlahPeminjam.setText(data.jumlah_buku + "");
        kodePeminjam.setText(data.kode);
    }

    public void getSelectedRow() {
        // place data to input
        int row = tabelPeminjaman.getSelectedRow();
        this.peminjamanModel.id = Integer.parseInt(tabelPeminjaman.getModel().getValueAt(row, 0).toString());
        this.peminjamanModel.nama = tabelPeminjaman.getModel().getValueAt(row, 1).toString();
        this.peminjamanModel.judul = tabelPeminjaman.getModel().getValueAt(row, 2).toString();
        this.peminjamanModel.durasi = Integer.parseInt(tabelPeminjaman.getModel().getValueAt(row, 3).toString());
        this.peminjamanModel.tanggal_pinjam = Date.valueOf(tabelPeminjaman.getModel().getValueAt(row, 4).toString());
        this.peminjamanModel.jumlah_buku = Integer.parseInt(tabelPeminjaman.getModel().getValueAt(row, 5).toString());
        this.peminjamanModel.kode = tabelPeminjaman.getModel().getValueAt(row, 6).toString();
        this.peminjamanModel.status = tabelPeminjaman.getModel().getValueAt(row, 7).toString();

    }

    public PeminjamanModel grabInputForm() {
        DataBukuAlert.setText("");

        // check if form is null
        if (idPeminjaman.getText().equals("") || namaPeminjam.getText().equals("")
                && judulPeminjam.getText().equals("") || durasiPeminjam.getText().equals("")
                && jumlahPeminjam.getText().equals("")) {

            DataBukuAlert.setText("Data form kosong");
            return null;
        }

        // grab all input user
        this.peminjamanModel.id = Integer.parseInt(idPeminjaman.getText());
        this.peminjamanModel.status = statusPeminjam.getSelectedItem().toString();

        return this.peminjamanModel;
    }

    public void clearInputForm() {
        idPeminjaman.setText("");
        namaPeminjam.setText("");
        judulPeminjam.setText("");
        durasiPeminjam.setText("");
        jumlahPeminjam.setText("");
    }

    public void initLayout() {
        // hide button
        btnSimpan.setEnabled(false);
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);

        // adjust table size
        tabelPeminjaman.setRowHeight(25);
        tabelPeminjaman.getColumnModel().getColumn(0).setPreferredWidth(1);
        tabelPeminjaman.getColumnModel().getColumn(1).setPreferredWidth(130);
        tabelPeminjaman.getColumnModel().getColumn(2).setPreferredWidth(230);
        tabelPeminjaman.getColumnModel().getColumn(3).setPreferredWidth(1);
        tabelPeminjaman.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabelPeminjaman.getColumnModel().getColumn(5).setPreferredWidth(1);
        tabelPeminjaman.getColumnModel().getColumn(6).setPreferredWidth(40);
    }

    /**
     * Creates new form DataBuku
     */
    public Peminjaman() {
        initComponents();
        initData();
        initLayout();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dataBukuNav = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        peminjamanNav = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pengembalianNav = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        namaPeminjam = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        idPeminjaman = new javax.swing.JTextField();
        durasiPeminjam = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        judulPeminjam = new javax.swing.JTextField(8);
        jLabel5 = new javax.swing.JLabel();
        jumlahPeminjam = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbSearchBuku = new javax.swing.JComboBox<>();
        searchPeminjam = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPeminjaman = new javax.swing.JTable();
        searchAlert = new javax.swing.JLabel();
        DataBukuAlert = new javax.swing.JLabel();
        kodePeminjam = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        statusPeminjam = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(137, 2, 185));

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Perpustakaan");

        dataBukuNav.setBackground(new java.awt.Color(137, 2, 185));
        dataBukuNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dataBukuNavMouseReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Cantarell", 0, 23)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Data Buku");

        peminjamanNav.setBackground(new java.awt.Color(204, 0, 204));
        peminjamanNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                peminjamanNavMouseReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Cantarell", 0, 23)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Peminjaman");

        javax.swing.GroupLayout peminjamanNavLayout = new javax.swing.GroupLayout(peminjamanNav);
        peminjamanNav.setLayout(peminjamanNavLayout);
        peminjamanNavLayout.setHorizontalGroup(
            peminjamanNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(peminjamanNavLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        peminjamanNavLayout.setVerticalGroup(
            peminjamanNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(peminjamanNavLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel12)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pengembalianNav.setBackground(new java.awt.Color(137, 2, 185));
        pengembalianNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pengembalianNavMouseReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Cantarell", 0, 23)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Pengembalian");

        javax.swing.GroupLayout pengembalianNavLayout = new javax.swing.GroupLayout(pengembalianNav);
        pengembalianNav.setLayout(pengembalianNavLayout);
        pengembalianNavLayout.setHorizontalGroup(
            pengembalianNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengembalianNavLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pengembalianNavLayout.setVerticalGroup(
            pengembalianNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengembalianNavLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel13)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dataBukuNavLayout = new javax.swing.GroupLayout(dataBukuNav);
        dataBukuNav.setLayout(dataBukuNavLayout);
        dataBukuNavLayout.setHorizontalGroup(
            dataBukuNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataBukuNavLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addContainerGap(136, Short.MAX_VALUE))
            .addComponent(peminjamanNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(dataBukuNavLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pengembalianNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        dataBukuNavLayout.setVerticalGroup(
            dataBukuNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataBukuNavLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(peminjamanNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pengembalianNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataBukuNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dataBukuNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel2.setText("ID");

        namaPeminjam.setEditable(false);
        namaPeminjam.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        namaPeminjam.setMargin(new java.awt.Insets(2, 15, 2, 15));
        namaPeminjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaPeminjamActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel3.setText("Nama");

        idPeminjaman.setEditable(false);
        idPeminjaman.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        idPeminjaman.setMargin(new java.awt.Insets(2, 15, 2, 15));
        idPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPeminjamanActionPerformed(evt);
            }
        });

        durasiPeminjam.setEditable(false);
        durasiPeminjam.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        durasiPeminjam.setMargin(new java.awt.Insets(2, 15, 2, 15));

        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel4.setText("Durasi");

        judulPeminjam.setEditable(false);
        judulPeminjam.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        judulPeminjam.setMargin(new java.awt.Insets(2, 15, 2, 15));
        judulPeminjam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                judulPeminjamKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel5.setText("Judul");

        jumlahPeminjam.setEditable(false);
        jumlahPeminjam.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jumlahPeminjam.setMargin(new java.awt.Insets(2, 15, 2, 15));
        jumlahPeminjam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jumlahPeminjamKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel7.setText("Status");

        jLabel9.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel9.setText("Jumlah");

        btnSimpan.setBackground(new java.awt.Color(244, 218, 254));
        btnSimpan.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setBackground(new java.awt.Color(244, 218, 254));
        btnUbah.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(244, 218, 254));
        btnHapus.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnKeluar.setBackground(new java.awt.Color(244, 218, 254));
        btnKeluar.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Cantarell", 1, 23)); // NOI18N
        jLabel10.setText("Pencarian");

        jLabel11.setFont(new java.awt.Font("Cantarell", 1, 30)); // NOI18N
        jLabel11.setText("Data Buku");

        cmbSearchBuku.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        cmbSearchBuku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "judul", "nama", " " }));
        cmbSearchBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSearchBukuActionPerformed(evt);
            }
        });

        searchPeminjam.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        searchPeminjam.setMargin(new java.awt.Insets(2, 15, 2, 15));
        searchPeminjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPeminjamActionPerformed(evt);
            }
        });
        searchPeminjam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchPeminjamKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchPeminjamKeyTyped(evt);
            }
        });

        tabelPeminjaman.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        tabelPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Judul", "Durasi", "Tanggal Pinjam", "Jumlah", "Kode", "Status"
            }
        ));
        tabelPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelPeminjamanMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelPeminjaman);

        searchAlert.setFont(new java.awt.Font("Cantarell", 0, 25)); // NOI18N
        searchAlert.setForeground(new java.awt.Color(255, 0, 0));

        DataBukuAlert.setFont(new java.awt.Font("Cantarell", 0, 23)); // NOI18N
        DataBukuAlert.setForeground(new java.awt.Color(255, 0, 0));

        kodePeminjam.setEditable(false);
        kodePeminjam.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        kodePeminjam.setMargin(new java.awt.Insets(2, 15, 2, 15));
        kodePeminjam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kodePeminjamKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel8.setText("Kode");

        statusPeminjam.setFont(new java.awt.Font("Cantarell", 0, 23)); // NOI18N
        statusPeminjam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Menunggu Konfirmasi", "Terkonfirmasi", "Ditolak" }));
        statusPeminjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusPeminjamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchAlert))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbSearchBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchPeminjam))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(DataBukuAlert)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(108, 108, 108)
                                        .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idPeminjaman)
                                    .addComponent(namaPeminjam)
                                    .addComponent(judulPeminjam)
                                    .addComponent(durasiPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(136, 136, 136)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(kodePeminjam, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                                    .addComponent(jumlahPeminjam, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                                    .addComponent(statusPeminjam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 19, Short.MAX_VALUE)))
                        .addGap(62, 62, 62))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel11)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DataBukuAlert)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jumlahPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(statusPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kodePeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(idPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namaPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(judulPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(durasiPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(searchAlert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSearchBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        PeminjamanModel data = grabInputForm();

        if (data == null) {
            DataBukuAlert.setText("Data Kosong");
            return;
        }

        // edit row via model
        int rowAffected = this.peminjamanModel.editRow(data);

        // is success
        if (rowAffected > 0) {
            JOptionPane.showMessageDialog(null, "Sukses mengubah data");
            btnSimpan.setEnabled(false);
            clearRow();
            clearInputForm();
            initData();
            return;
        }
        JOptionPane.showMessageDialog(null, "Gagal mengubah data");

    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // disable button
        btnUbah.setEnabled(false);

        getSelectedRow();
        // enable simpan
        btnSimpan.setEnabled(true);

        addSelectedRowToinput(this.peminjamanModel);
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Data Buku Akan di Hapus?");

        if (confirm == 0) {
            getSelectedRow();
            int rowAffected = this.peminjamanModel.deleteRow(this.peminjamanModel.id);

            if (rowAffected > 0) {
                JOptionPane.showMessageDialog(null, "Sukses dihapus");
                clearInputForm();
                initData();
                return;
            }

            JOptionPane.showMessageDialog(null, "Gagal dihapus");
        }

    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        int isLogout = JOptionPane.showConfirmDialog(null, "Anda akan keluar?");

        if (isLogout == 0) {
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void searchPeminjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPeminjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchPeminjamActionPerformed

    private void cmbSearchBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSearchBukuActionPerformed
        this.searchTableAction();
    }//GEN-LAST:event_cmbSearchBukuActionPerformed

    private void searchPeminjamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchPeminjamKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchPeminjamKeyTyped
    private void searchPeminjamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchPeminjamKeyReleased
        this.searchTableAction();
    }//GEN-LAST:event_searchPeminjamKeyReleased

    private void judulPeminjamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_judulPeminjamKeyTyped
        // Limit input user

        boolean max = judulPeminjam.getText().length() > 3;
        if (max) {
            evt.consume();
        }
    }//GEN-LAST:event_judulPeminjamKeyTyped

    private void jumlahPeminjamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumlahPeminjamKeyTyped
        // Limit input user

        boolean max = jumlahPeminjam.getText().length() > 3;
        if (max) {
            evt.consume();
        }
    }//GEN-LAST:event_jumlahPeminjamKeyTyped

    private void tabelPeminjamanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPeminjamanMouseReleased
        btnUbah.setEnabled(true);
        btnSimpan.setEnabled(false);
        btnHapus.setEnabled(true);
    }//GEN-LAST:event_tabelPeminjamanMouseReleased

    private void idPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPeminjamanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPeminjamanActionPerformed

    private void peminjamanNavMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_peminjamanNavMouseReleased

    }//GEN-LAST:event_peminjamanNavMouseReleased

    private void dataBukuNavMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataBukuNavMouseReleased
        new DataBuku().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_dataBukuNavMouseReleased

    private void kodePeminjamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodePeminjamKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_kodePeminjamKeyTyped

    private void statusPeminjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusPeminjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusPeminjamActionPerformed

    private void namaPeminjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaPeminjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaPeminjamActionPerformed

    private void pengembalianNavMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pengembalianNavMouseReleased
        new Pengembalian().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pengembalianNavMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Peminjaman().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DataBukuAlert;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cmbSearchBuku;
    private javax.swing.JPanel dataBukuNav;
    private javax.swing.JTextField durasiPeminjam;
    private javax.swing.JTextField idPeminjaman;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField judulPeminjam;
    private javax.swing.JTextField jumlahPeminjam;
    private javax.swing.JTextField kodePeminjam;
    private javax.swing.JTextField namaPeminjam;
    private javax.swing.JPanel peminjamanNav;
    private javax.swing.JPanel pengembalianNav;
    private javax.swing.JLabel searchAlert;
    private javax.swing.JTextField searchPeminjam;
    private javax.swing.JComboBox<String> statusPeminjam;
    private javax.swing.JTable tabelPeminjaman;
    // End of variables declaration//GEN-END:variables
}
