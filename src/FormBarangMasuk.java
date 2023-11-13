/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.*; 
import java.awt.*;
import java.sql.*; 
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author lab-4
 */
public class FormBarangMasuk extends javax.swing.JFrame {
    Connection conn;
    Statement cn;
    
    /**
     * Creates new form FormBarangMasuk
     */
    public FormBarangMasuk() {
        initComponents();
         Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize(); 
        Dimension frameSize=this.getSize(); 
        if(frameSize.height > screenSize.height){ 
            frameSize.height=screenSize.height; 
        } 
        if(frameSize.width > screenSize.width){                     
            frameSize.width=screenSize.width; 
        } 
        this.setLocation((screenSize.width - frameSize.width) / 2, 
        (screenSize.height = screenSize.height) / 10); 
        tbbarangmasuk.setModel(tableModel); 
        Tabel(tbbarangmasuk, new int[]{90,300,90,60,60,90}); 
        setDefaultTable(); 
        SetEditOff(); 
        TanggalOtomatis(); 
        TampilComboBarang(); 
        TampilComboPetugas(); 
        TampilComboDistributor();
        tampilnota();
    }
    
    private javax.swing.table.DefaultTableModel tableModel=getDefaultTabelModel(); 
     
     private void Tabel(javax.swing.JTable tb, int lebar[] ) { 
        tb.setAutoResizeMode(tbbarangmasuk.AUTO_RESIZE_OFF); 
        int kolom=tb.getColumnCount(); 
        for(int i=0;i < kolom;i++) { 
            javax.swing.table.TableColumn tbc=tb.getColumnModel().getColumn(i); 
            tbc.setPreferredWidth(lebar[i]); 
            tb.setRowHeight(17); 
        } 
    } 
     
     private javax.swing.table.DefaultTableModel getDefaultTabelModel() { 
     return new javax.swing.table.DefaultTableModel( 
     new Object[][] {}, 
     new String [] {"Kode Barang","Nama Barang","Harga Jual","Stok","Jumlah","Sub Total"} 
        ){ 
     boolean[] canEdit = new boolean[]{ 
     false, false, false, false 
     }; 
     public  boolean isCellEditable(int  rowIndex, int columnIndex){ 
     return canEdit[columnIndex]; 
        } 
     };    
} 
     String data[]=new String[6]; 
     private void setDefaultTable() { 
     String stat =""; 
     try { 
        koneksi();
     String SQL = "SELECT tbl_barang.kode_barang,tbl_barang.namabarang,tbl_barang.harga_jual," +           
                  "tbl_barang.stok,tbl_detailbarangmasuk.jumlah,tbl_detailbarangmasuk.subtotal,tbl_baranggmasuk.no_nota " + 
                  "FROM tblbarang,tbldetailbrgmasuk,tblbrgmasuk " +
                  "WHERE tbl_barang.kode_barang=tbl_detailbarangmasuk.kode_barang " +
                  "AND tblbrgmasuk.no_nota=tbldetailbrgmasuk.no_nota" +
                  "AND tbl_detailbarangmasuk.no_nota="+txtnota.getText()+"";
     
      try (ResultSet res = cn.executeQuery(SQL)) {
          while(res.next()){
              data[0] = res.getString(1);
              data[1] = res.getString(2);
              data[2] = res.getString(3);
              data[3] = res.getString(4);
              data[4] = res.getString(5);
              data[5] = res.getString(6);
              tableModel.addRow(data);
          }
      }
            cn.close(); 
            conn.close(); 
      }catch (Exception ex) { 
            System.err.println(ex.getMessage()); 
        } 
}
     
     private void TampilGridDetail(){
        String stat =""; 
        try { 
        koneksi();
                String SQL = "SELECT tbl_barang.kode_barang,tbl_barang.nama_barang,tbl_barang.harga_jual, tbl_barang.stok,tbl_detailbarangmasuk.jumlah,tbl_detailbarangmasuk.subtotal,tbl_barangmasuk.no_nota " + 
                             "FROM tbl_barang,tbl_detailbarangmasuk,tbl_barangmasuk WHERE tbl_barang.kode_barang=tbl_detailbarangmasuk.kode_barang " + 
                             "AND tbl_barangmasuk.no_nota=tbl_detailbarangmasuk.no_nota AND tbl_detailbarangmasuk.no_nota='"+txtnota.getText()+"'"; 
      
          try (ResultSet res = cn.executeQuery(SQL)){
          while(res.next()){
              data[0] = res.getString(1);
              data[1] = res.getString(2);
              data[2] = res.getString(3);
              data[3] = res.getString(4);
              data[4] = res.getString(5);
              data[5] = res.getString(6);
              tableModel.addRow(data);
          }
     
           } 
            cn.close(); 
            conn.close(); 
        }catch (Exception ex) { 
            System.err.println(ex.getMessage()); 
        }
     
     } 
     
     public void BersihData(){ 
     tableModel.setRowCount(0); 
     txtnota.setText(""); 
     combodistributor.setSelectedIndex(0); 
     txtnamapetugas.setText(""); 
     combopetugas.setSelectedIndex(0); 
     txtnamadistributor.setText(""); 
     txtkota.setText(""); 
     combobarang.setSelectedIndex(0); 
     txtnamabarang.setText("");    
     txtharga.setText(""); 
     txtjumlah.setText(""); 
     txtstok.setText(""); 
     txtsubtotal.setText("0"); 
     txttotal.setText("0"); 
  } 
     
     public void BersihDetail(){ 
        combobarang.setSelectedIndex(0); 
        txtnamabarang.setText("");   
        txtharga.setText(""); 
        txtstok.setText(""); 
        txtjumlah.setText(""); 
        txtsubtotal.setText("0"); 
  }
     
      public void SetEditOff(){ 
        txtnota.setEnabled(false); 
        TanggalMasuk.setEnabled(false); 
        combodistributor.setEnabled(false); 
        combopetugas.setEnabled(false); 
        combobarang.setEnabled(false); 
        txtjumlah.setEnabled(false); 
        btnhitung.setEnabled(false); 
        btncari.setEnabled(false); 
        btntambahitem.setEnabled(false); 
     } 
     
       public void SetEditOn(){ 
        txtnota.setEnabled(true); 
        TanggalMasuk.setEnabled(true); 
        combodistributor.setEnabled(true); 
        combopetugas.setEnabled(true); 
        combobarang.setEnabled(true); 
        txtjumlah.setEnabled(true); 
        btnsimpan.setEnabled(true); 
        btncari.setEnabled(true); 
        btnhitung.setEnabled(true); 
        btntambahitem.setEnabled(true); 
     }  
      
       public void koneksi(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_penjualan_barang_pas_xiia","root","");
            cn = conn.createStatement();
        }catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"koneksi gagal..");
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    } 
       
       public void tampilnota() {
 //  Date tanggal = new Date(); 
 //  String kode;
 //  NoFaktur.setText(""+ (String.format("%1$tY%1$tm%1$td",tanggal)));
   Date sk = new Date();

        SimpleDateFormat format1=new SimpleDateFormat("ddMMyy");
        String time = format1.format(sk);
        koneksi();
        String sql = "select right(no_nota,1) as kd from tbl_barangmasuk order by kd desc";

        try{
         try (ResultSet rs = cn.executeQuery(sql)) {
           if (rs.next()){
               
               int kode = Integer.parseInt(rs.getString("kd"))+1;
               
               txtnota.setText(time+Integer.toString(kode));
               
           }else{
               
               int kode = 1;
               
               txtnota.setText(time+Integer.toString(kode));
               
           }
       }
        }catch (SQLException | NumberFormatException e){

            JOptionPane.showMessageDialog(null, e);

        }      
       }
       
public void TanggalOtomatis(){ 
     Date tanggal = new Date();
      TanggalMasuk.setText(""+ (String.format("%1$td/%1$tb/%1$tY",tanggal))); 
  }
 
         
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TanggalMasuk = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnota = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        combopetugas = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtnamapetugas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        combodistributor = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtnamadistributor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtkota = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        combobarang = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtnamabarang = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtharga = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtstok = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtjumlah = new javax.swing.JTextField();
        btnhitung = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtsubtotal = new javax.swing.JTextField();
        btntambahitem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbbarangmasuk = new javax.swing.JTable();
        btntambahbaru = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        btnclose = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("FORM BARANG MASUK");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 14, -1, -1));

        jLabel2.setText("Tanggal Barang Masuk");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 60, -1, -1));
        getContentPane().add(TanggalMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 57, 160, -1));

        jLabel3.setText("No. Nota");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 94, -1, -1));
        getContentPane().add(txtnota, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 91, 82, -1));

        btncari.setText("Cari Data");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });
        getContentPane().add(btncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 91, -1, -1));

        jLabel4.setText("ID Petugas");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 138, -1, -1));

        combopetugas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Petugas" }));
        combopetugas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combopetugasItemStateChanged(evt);
            }
        });
        getContentPane().add(combopetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 132, 498, -1));

        jLabel5.setText("Nama Petugas");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 160, -1, -1));
        getContentPane().add(txtnamapetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 160, 498, -1));

        jLabel6.setText("ID Distributor");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 191, -1, -1));

        combodistributor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Distributor" }));
        combodistributor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combodistributorItemStateChanged(evt);
            }
        });
        getContentPane().add(combodistributor, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 188, 178, -1));

        jLabel7.setText("Nama Distributor");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 225, -1, -1));
        getContentPane().add(txtnamadistributor, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 222, 498, -1));

        jLabel8.setText("Kota Asal");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 259, -1, -1));
        getContentPane().add(txtkota, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 256, 498, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Barang Masuk"));

        jLabel9.setText("Kode Barang");

        combobarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Data Barang" }));
        combobarang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combobarangItemStateChanged(evt);
            }
        });

        jLabel10.setText("Nama Barang");

        jLabel11.setText("Harga Jual");

        jLabel12.setText("Rp");

        jLabel13.setText("Stok");

        jLabel14.setText("Jumlah");

        btnhitung.setText("Hitung");
        btnhitung.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnhitungItemStateChanged(evt);
            }
        });
        btnhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhitungActionPerformed(evt);
            }
        });

        jLabel15.setText("Sub total Rp");

        txtsubtotal.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtsubtotalCaretUpdate(evt);
            }
        });
        txtsubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubtotalActionPerformed(evt);
            }
        });

        btntambahitem.setText("Tambah Item");
        btntambahitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahitemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combobarang, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtstok, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(txtjumlah))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnhitung))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btntambahitem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(combobarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnhitung))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btntambahitem)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 296, -1, -1));

        tbbarangmasuk.setModel(new javax.swing.table.DefaultTableModel(
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
        tbbarangmasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbarangmasukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbbarangmasuk);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 496, 695, 137));

        btntambahbaru.setText("Tambah Baru");
        btntambahbaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahbaruActionPerformed(evt);
            }
        });
        getContentPane().add(btntambahbaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 651, 125, -1));

        btnsimpan.setText("SImpan Transaksi");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 651, 205, -1));

        btnclose.setText("Close");
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 651, -1, -1));

        jLabel16.setText("Total Rp");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 654, -1, -1));
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 651, 226, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntambahitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahitemActionPerformed
        String NM=txtnota.getText(); 
        String KB=combobarang.getSelectedItem().toString(); 
        String JM=txtjumlah.getText(); 
        
        if ((NM.isEmpty()) | (KB.isEmpty()) |(JM.isEmpty())) { 
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi"); 
            combobarang.requestFocus(); 
        }else { 
             try { 
                koneksi();
                try (Statement stt = conn.createStatement()) {
                    String     SQL = "insert into tbl_detailbarangmasuk values('"+txtnota.getText()+"',"+
                            "'"+combobarang.getSelectedItem()+"',"+
                            "'"+txtjumlah.getText()+"',"+
                            "'"+txttotal.getText()+"')";
                    stt.executeUpdate(SQL);
                    Statement stt1 = conn.createStatement();
                    String SQL1 = "Update tbl_barang Set stok=stok + '"+txtjumlah.getText()+"'" +
                            "Where kode_barang='"+combobarang.getSelectedItem().toString()+"'";
                    stt1.executeUpdate(SQL1);
                    data[0] = combobarang.getSelectedItem().toString();
                    data[1] = txtnamabarang.getText();
                    data[2] = txtharga.getText();
                    data[3] = txtstok.getText();
                    data[4] = txtjumlah.getText();
                    data[5] = txtsubtotal.getText();
                    tableModel.insertRow(0, data);
                }
                conn.close(); 
                combobarang.requestFocus(); 
                btntambahitem.setEnabled(false); 
                BersihDetail(); 
                //TampilGrid(); 
                combobarang.requestFocus();
                 } catch (Exception ex) { 
                System.err.println(ex.getMessage()); 
            } 
        }
    }//GEN-LAST:event_btntambahitemActionPerformed

    private void tbbarangmasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbarangmasukMouseClicked
     
    }//GEN-LAST:event_tbbarangmasukMouseClicked

    private void combopetugasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combopetugasItemStateChanged
        // TODO add your handling code here:
         try {      
            koneksi();
            String SQL = "SELECT * FROM tbl_petugas where petugas_id='"+ 
            combopetugas.getSelectedItem().toString()+"'"; 
             
            ResultSet  res = cn.executeQuery(SQL); 
            res.absolute(1); 
            txtnamapetugas.setText(res.getString("nama_petugas")); 
        } catch (SQLException ex) { 
        }
    }//GEN-LAST:event_combopetugasItemStateChanged

    private void combodistributorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combodistributorItemStateChanged
        // TODO add your handling code here:
         try {      
            koneksi(); 
            String SQL = "SELECT * FROM tbl_distributor where distributor_id='"+ 
            combodistributor.getSelectedItem().toString()+"'"; 

            ResultSet  res = cn.executeQuery(SQL); 
            res.absolute(1); 
            txtnamadistributor.setText(res.getString("nama_distributor")); 
            txtkota.setText(res.getString("kotasal")); 
         } catch (SQLException ex) { 
        } 
    }//GEN-LAST:event_combodistributorItemStateChanged

    private void combobarangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combobarangItemStateChanged
        // TODO add your handling code here:
        try {      
            koneksi();
            String SQL = "SELECT * FROM tbl_barang where kode_barang='"+ 
            combobarang.getSelectedItem().toString()+"'"; 

            ResultSet  res = cn.executeQuery(SQL); 
            res.absolute(1); 
            txtnamabarang.setText(res.getString("namabarang")); 
            txtharga.setText(res.getString("hargajual")); 
            txtstok.setText(res.getString("stok")); 
        } catch (SQLException ex) { 
        } 
         txtjumlah.requestFocus(); 
         btntambahitem.setEnabled(true); 
         
    }//GEN-LAST:event_combobarangItemStateChanged

    private void btnhitungItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnhitungItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnhitungItemStateChanged

    private void btnhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhitungActionPerformed
        // TODO add your handling code here:
        int a; 
        int b; 
        double c;     
        a = (int) Double.parseDouble(txtharga.getText());  
        b = (int) Double.parseDouble(txtjumlah.getText()); 
        c = a * b;   
        txttotal.setText(String.valueOf(c));  
    }//GEN-LAST:event_btnhitungActionPerformed

    private void txtsubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubtotalActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtsubtotalActionPerformed

    private void btntambahbaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahbaruActionPerformed
        // TODO add your handling code here:
         SetEditOn(); 
         txtnota.requestFocus(); 
         BersihData(); 
         tampilnota();
    }//GEN-LAST:event_btntambahbaruActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
         String NM=txtnota.getText(); 
         
        if ((NM.isEmpty())) { 
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi"); 
            txtnota.requestFocus(); 
        }else {
             try { 
                koneksi();
                String SQL = "insert into tbl_barangmasuk values('"+txtnota.getText()+"',"+ 
                        "'"+TanggalMasuk.getText()+"',"+ 
                        "'"+combodistributor.getSelectedItem()+"',"+ 
                        "'"+combopetugas.getSelectedItem()+"',"+ 
                        "'"+txttotal.getText()+"')"; 
                
                cn.executeUpdate(SQL); 
                cn.close(); 
                conn.close(); 
                BersihData(); 
                SetEditOff(); 
                btnsimpan.setEnabled(false); 
            } catch (Exception ex) { 
                System.err.println(ex.getMessage()); 
            } 
        } 
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // TODO add your handling code here:
          if(JOptionPane.showConfirmDialog(null,"This application will be close \n if you press button OK","Information",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION) 
           this.dispose();  
//           new FrmMenu().setVisible(true);
    }//GEN-LAST:event_btncloseActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        // TODO add your handling code here:
             try { 
                koneksi ();
                String SQL = "SELECT * FROM tbl_barangmasuk where no_nota='"+txtnota.getText()+"'"; 
                ResultSet  res = cn.executeQuery(SQL); 
                res.absolute(1); 

                TanggalMasuk.setText(res.getString("tgl_masuk")); 
                combopetugas.setSelectedItem(res.getString("petugas_id")); 
                combodistributor.setSelectedItem(res.getString("distributor_id")); 
                txttotal.setText(res.getString("total")); 
                TampilGridDetail(); 
                btnsimpan.setEnabled(false); 
                txtnota.setEnabled(false); 
                btncari.setEnabled(false); 
            } catch (SQLException ex) { 
        }   
    }//GEN-LAST:event_btncariActionPerformed

    private void txtsubtotalCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtsubtotalCaretUpdate
        // TODO add your handling code here:
         double d, e;   
        d = Double.parseDouble(txtharga.getText());  
        e = Double.parseDouble(txttotal.getText());  
        e = e+d;   
        txttotal.setText(String.valueOf(e)); 
    }//GEN-LAST:event_txtsubtotalCaretUpdate

    public void TampilComboBarang(){ 
        try {      
            koneksi ();
            String SQL = "SELECT * FROM tbl_barang"; 
            ResultSet  res = cn.executeQuery(SQL); 
            while(res.next()){ 
            combobarang.addItem(res.getString("kode_barang")); 
        } 
        } catch (SQLException ex) { 
        } 
    }
    
    public void TampilComboPetugas(){ 
        try {      
        koneksi();
        String SQL = "SELECT * FROM tbl_petugas"; 

        ResultSet  res = cn.executeQuery(SQL); 
        while(res.next()){ 
        combopetugas.addItem(res.getString("petugas_id")); 
        } 
        } catch (SQLException ex) { 
        }
    }  
    
     public void TampilComboDistributor(){ 
        try {      
        koneksi ();
        String SQL = "SELECT * FROM tbl_distributor"; 
        
        ResultSet  res = cn.executeQuery(SQL); 
        while(res.next()){ 
        combodistributor.addItem(res.getString("distributo_id")); 
       } 
        } catch (SQLException ex) { 
        } 
    }    
    
     
     
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
            java.util.logging.Logger.getLogger(FormBarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBarangMasuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField TanggalMasuk;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btnhitung;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntambahbaru;
    private javax.swing.JButton btntambahitem;
    private javax.swing.JComboBox<String> combobarang;
    private javax.swing.JComboBox<String> combodistributor;
    private javax.swing.JComboBox<String> combopetugas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JTable tbbarangmasuk;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtkota;
    private javax.swing.JTextField txtnamabarang;
    private javax.swing.JTextField txtnamadistributor;
    private javax.swing.JTextField txtnamapetugas;
    private javax.swing.JTextField txtnota;
    private javax.swing.JTextField txtstok;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
