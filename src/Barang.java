

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;


public class Barang extends javax.swing.JFrame {

    private static Connection conn;
    private DefaultTableModel model;
    public Barang() {
        initComponents();
        conn = Koneksi.getKoneksi();
        resetData();        
        loadData();
        KdJenis();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtkode = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtnmjenis = new javax.swing.JTextField();
        txtHargaNet = new javax.swing.JTextField();
        txtHargaJual = new javax.swing.JTextField();
        txtstok = new javax.swing.JTextField();
        cmbbarang = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblhasil = new javax.swing.JTable();
        btntambah = new javax.swing.JButton();
        txtubah = new javax.swing.JButton();
        txthapus = new javax.swing.JButton();
        txtbatal = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Barang");

        jLabel2.setText("Kode");

        jLabel3.setText("Nama");

        jLabel4.setText("Kode Jenis");

        jLabel5.setText("Nama Jenis");

        jLabel6.setText("Harga Net");

        jLabel7.setText("Harga Jual");

        jLabel8.setText("Stok");

        txtkode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodeActionPerformed(evt);
            }
        });

        txtnmjenis.setEnabled(false);
        txtnmjenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnmjenisActionPerformed(evt);
            }
        });

        cmbbarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        cmbbarang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbbarangItemStateChanged(evt);
            }
        });
        cmbbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbarangActionPerformed(evt);
            }
        });

        tblhasil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama", "Kode Jenis", "Nama Jenis", "Harga Barang", "Harga Net", "Stock"
            }
        ));
        tblhasil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhasilMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblhasil);

        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        txtubah.setText("Ubah");
        txtubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtubahActionPerformed(evt);
            }
        });

        txthapus.setText("Hapus");
        txthapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthapusActionPerformed(evt);
            }
        });

        txtbatal.setText("Batal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addGap(66, 66, 66)
                .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel3)
                .addGap(61, 61, 61)
                .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183)
                .addComponent(btntambah))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel4)
                .addGap(34, 34, 34)
                .addComponent(cmbbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190)
                .addComponent(txtubah))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel5)
                .addGap(29, 29, 29)
                .addComponent(txtnmjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187)
                .addComponent(txthapus))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHargaNet, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(180, 180, 180)
                .addComponent(txtbatal))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel8)
                .addGap(67, 67, 67)
                .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btntambah))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cmbbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtubah))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnmjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txthapus))))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtHargaNet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(txtHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(txtbatal)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtkodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkodeActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        String kode = txtkode.getText();
        String nama = txtnama.getText();
        String kj = cmbbarang.getSelectedItem().toString();
        String namaJenis = txtnmjenis.getText();
        String HargaNet = txtHargaNet.getText();
        String HargaJual = txtHargaJual.getText();
        String Stok = txtstok.getText();
        
        
        if("".equals(kode)||"".equals(nama)||"".equals(namaJenis)||"".equals(HargaNet)||"".equals(HargaJual)||"".equals(kj))
        {
            JOptionPane.showMessageDialog(this, "Harap Lengkapi Data", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                Connection c = Koneksi.getKoneksi();
                String sql = "INSERT INTO tblbarang VALUES(?,?,?,?,?,?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, kode);
                p.setString(2, nama);   
                p.setString(3, kj);
                p.setString(4, HargaNet);     
                p.setString(5, HargaJual);
                p.setString(6, Stok); 
                

                p.executeUpdate();
                p.close();
                JOptionPane.showConfirmDialog(this, "Penyimpanan Data Berhasil", "Succes", JOptionPane.DEFAULT_OPTION);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }finally{
                loadData();
//                kosong();
            }
        }
    }//GEN-LAST:event_btntambahActionPerformed

    private void cmbbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbarangActionPerformed
        
    }//GEN-LAST:event_cmbbarangActionPerformed

    private void txtnmjenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnmjenisActionPerformed
        
    }//GEN-LAST:event_txtnmjenisActionPerformed

    private void txtubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtubahActionPerformed
        int selectedRow = tblhasil.getSelectedRow();
        if(selectedRow==-1){
            JOptionPane.showMessageDialog(this, "Pilih Data yang ingin di Perbarui");
            return;
        }
        String kode = (String) model.getValueAt(selectedRow, 0);
        String nama = txtnama.getText();
        String kj = cmbbarang.getSelectedItem().toString();
        String HargaNet = txtHargaNet.getText();
        String HargaJual = txtHargaJual.getText();
        String stok = txtstok.getText();
        if("".equals(kode)||"".equals(nama)||"".equals(HargaNet)||"".equals(HargaJual)||"".equals(kj)||"".equals(stok))
        {
            JOptionPane.showMessageDialog(this, "Harap Lengkapi Data", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                Connection c = Koneksi.getKoneksi();
                String sql = "UPDATE tblbarang SET NamaBarang=?,KodeJenis=?,HargaNet=?,HargaJual=?,Stok=? WHERE KodeBarang=?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, nama);
                p.setString(2, cmbbarang.getSelectedItem().toString());
                p.setString(3, HargaNet);
                p.setString(4, HargaJual);
                p.setString(5, stok);
                p.setString(6, kode);

                p.executeUpdate();
                p.close();
                JOptionPane.showConfirmDialog(this, "Penyimpanan Data Berhasil diubah", "Succes", JOptionPane.DEFAULT_OPTION);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }finally{
                loadData();
                
            }
        }
    }//GEN-LAST:event_txtubahActionPerformed

    private void cmbbarangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbbarangItemStateChanged
        try {
            String sql = "SELECT * FROM tbljenis WHERE KodeJenis='" + cmbbarang.getSelectedItem().toString() + "'";
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);

            if (r.next()) {
                String Nama = r.getString("Jenis");
                if (Nama != null) {
                    txtnmjenis.setText(Nama);
                } else {

                    txtnmjenis.setText("Nilai kolom Jenis adalah null");
                }
            } else {

                txtnmjenis.setText("");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }//GEN-LAST:event_cmbbarangItemStateChanged

    private void tblhasilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhasilMouseClicked
        int baris = tblhasil.getSelectedRow();
if (baris == -1) {
    return; 
}

        String nis = tblhasil.getValueAt(baris, 0).toString();
        txtkode.setText(nis);
        String nama = tblhasil.getValueAt(baris, 1).toString();
        txtnama.setText(nama);
       cmbbarang.setSelectedItem(tblhasil.getValueAt(baris, 2));
        String jenis = tblhasil.getValueAt(baris, 3).toString();
        txtnmjenis.setText(jenis);
        String alamat = tblhasil.getValueAt(baris, 4).toString();
        txtHargaNet.setText(alamat);
        String jual = tblhasil.getValueAt(baris, 5).toString();
        txtHargaJual.setText(jual);
        String stok = tblhasil.getValueAt(baris, 6).toString();
        txtstok.setText(stok);
    }//GEN-LAST:event_tblhasilMouseClicked

    private void txthapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthapusActionPerformed
        int a = tblhasil.getSelectedRow();
        if(a==-1){
            JOptionPane.showMessageDialog(this, "Apakah anda yakin ingin menghapus data", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            return;
        };
        int b = JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin menghapus data", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(b==JOptionPane.YES_OPTION){
            String kode = (String) model.getValueAt(b, 0);
            try {
                Connection c = Koneksi.getKoneksi();
                String sql = "DELETE FROM tblbarang WHERE KodeBarang = ?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, kode);
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(null, "DONE");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Terjadi Error");
            } finally{
                loadData();
                
            }
        }
    }//GEN-LAST:event_txthapusActionPerformed

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
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btntambah;
    private javax.swing.JComboBox<String> cmbbarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblhasil;
    private javax.swing.JTextField txtHargaJual;
    private javax.swing.JTextField txtHargaNet;
    private javax.swing.JButton txtbatal;
    private javax.swing.JButton txthapus;
    private javax.swing.JTextField txtkode;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnmjenis;
    private javax.swing.JTextField txtstok;
    private javax.swing.JButton txtubah;
    // End of variables declaration//GEN-END:variables

    private void resetData() {

    }

    private void loadData() {
         
        model = new DefaultTableModel();
        model = new DefaultTableModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        tblhasil.setModel(model);
        model.addColumn("KodeBarang");
        model.addColumn("NamaBarang");
        model.addColumn("KodeJenis");
        model.addColumn("NamaJenis");
        model.addColumn("HargaNet");
        model.addColumn("HargaJual");
        model.addColumn("Stok");

        try {
            String sql = "SELECT b.*, j.Jenis AS NamaJenis FROM tblbarang b JOIN tbljenis j ON b.KodeJenis = j.KodeJenis";
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                model.addRow(new Object[]{
                    r.getString("KodeBarang"),
                    r.getString("NamaBarang"),
                    r.getString("KodeJenis"),
                    r.getString("NamaJenis"),
                    r.getString("HargaNet"),
                    r.getString("HargaJual"),
                    r.getString("Stok")
                });
            }
            tblhasil.setModel(model);
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
        }


    }

    private void KdJenis() {
        try {
            String sql = "SELECT * FROM tbljenis";
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()){
            
            cmbbarang.addItem(r.getString("KodeJenis")); }
        } catch (SQLException e) {
            System.out.println("ERROR");
        }
    }



}
