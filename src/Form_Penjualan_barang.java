import javax.swing.*; 
import java.awt.*; 
import java.sql.*; 
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


/**
 *
 * @author lab-4
 */
public class Form_Penjualan_barang extends javax.swing.JFrame {
Connection conn;
Statement cn;
    
    private DefaultTableModel model;
    
    /**
     * Creates new form Form_Penjualan_barang
     */
    public Form_Penjualan_barang() {
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
      
        TabelPenjualan.setModel(tableModel);
        Tabel(TabelPenjualan, new int[]{90,300,90,60,60,90});
        setDefaultTable();
        TanggalOtomatis();
        SetEditOff();
        TampilComboBarang();
        TampilComboPetugas();
        tampilfaktur();
    }
        
    public void TanggalOtomatis(){
      Date tanggal = new Date();
      txt_tanggalpenjualan.setText(""+ (String.format("%1$td/%1$tb/%1$tY",tanggal)));
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
        txt_nofaktur = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        IDPetugas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_namapetugas = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        kode_barang = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_namabarang = new javax.swing.JTextField();
        txt_hargajual = new javax.swing.JTextField();
        txt_stok = new javax.swing.JTextField();
        txt_jumlah = new javax.swing.JTextField();
        btn_hitung = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        btn_additem = new javax.swing.JButton();
        txt_tanggalpenjualan = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelPenjualan = new javax.swing.JTable();
        btn_addnew = new javax.swing.JButton();
        btn_savetransaction = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_bayar = new javax.swing.JTextField();
        txt_sisa = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("No.Faktur");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 45, -1, -1));

        txt_nofaktur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nofakturActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nofaktur, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 42, 160, -1));

        btn_cari.setText("CARI DATA");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

        jLabel2.setText("ID Petugas");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        IDPetugas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Data Petugas" }));
        IDPetugas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                IDPetugasItemStateChanged(evt);
            }
        });
        IDPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDPetugasActionPerformed(evt);
            }
        });
        getContentPane().add(IDPetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 160, -1));

        jLabel3.setText("Tanggal Penjualan");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, -1, -1));

        jLabel4.setText("Nama Petugas");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 90, -1));
        getContentPane().add(txt_namapetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 320, -1));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Kode Barang");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 31, -1, -1));

        kode_barang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Data Barang" }));
        kode_barang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                kode_barangItemStateChanged(evt);
            }
        });
        jPanel1.add(kode_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 28, 160, -1));

        jLabel6.setText("Nama Barang");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 31, -1, -1));

        jLabel7.setText("Harga Jual");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 68, -1, -1));

        jLabel8.setText("Stok");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 96, -1, -1));

        jLabel9.setText("Jumlah");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 124, -1, -1));

        txt_namabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namabarangActionPerformed(evt);
            }
        });
        jPanel1.add(txt_namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 28, 280, -1));
        jPanel1.add(txt_hargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 130, -1));

        txt_stok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stokActionPerformed(evt);
            }
        });
        jPanel1.add(txt_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 90, -1));

        txt_jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahActionPerformed(evt);
            }
        });
        jPanel1.add(txt_jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 80, -1));

        btn_hitung.setText("Hitung");
        btn_hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hitungActionPerformed(evt);
            }
        });
        jPanel1.add(btn_hitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, -1, -1));

        jLabel10.setText("Sub Total");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, -1));

        txt_subtotal.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_subtotalCaretUpdate(evt);
            }
        });
        jPanel1.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 140, -1));

        btn_additem.setText("ADD ITEM");
        btn_additem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_additemActionPerformed(evt);
            }
        });
        jPanel1.add(btn_additem, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 750, 190));

        txt_tanggalpenjualan.setEnabled(false);
        txt_tanggalpenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tanggalpenjualanActionPerformed(evt);
            }
        });
        getContentPane().add(txt_tanggalpenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 160, -1));

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TabelPenjualan.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelPenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPenjualanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelPenjualan);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 696, 144));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 750, 170));

        btn_addnew.setText("ADD NEW");
        btn_addnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addnewActionPerformed(evt);
            }
        });
        getContentPane().add(btn_addnew, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, -1, -1));

        btn_savetransaction.setText("SAVE TRANSACTION");
        btn_savetransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_savetransactionActionPerformed(evt);
            }
        });
        getContentPane().add(btn_savetransaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 530, -1, -1));

        btn_cancel.setText("CANCEL");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 530, -1, -1));

        btn_close.setText("CLOSE");
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        getContentPane().add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 530, -1, -1));

        jLabel11.setText("Bayar Rp");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 520, -1, -1));

        jLabel12.setText("Sisa Rp");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 550, -1, -1));

        jLabel13.setText("Total Rp");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 580, -1, -1));

        txt_bayar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_bayarCaretUpdate(evt);
            }
        });
        txt_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bayarActionPerformed(evt);
            }
        });
        getContentPane().add(txt_bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, 210, -1));

        txt_sisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sisaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_sisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 550, 210, -1));

        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });
        getContentPane().add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 580, 210, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
   private javax.swing.table.DefaultTableModel tableModel=getDefaultTabelModel(); 
     
     private void Tabel(javax.swing.JTable tb, int lebar[] ) { 
        tb.setAutoResizeMode(TabelPenjualan.AUTO_RESIZE_OFF); 
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
        public  boolean isCellEditable(int  rowIndex, int columnIndex){ return canEdit[columnIndex]; 
        } 
       };    
    } 
  
    String data[]=new String[6]; 
    private void setDefaultTable() { 
    String stat =""; 
    try { 
    koneksi();
    String     SQL = "SELECT tblbarang.kodebarang,tblbarang.namabarang,tblbarang.hargajual," +               
                    "tblbarang.stok,tb_detail_penjualan.jumlah,tb_detail_penjualan.subtotal,tb_penjualan.NoFaktur " + 
                     "FROM tblbarang,tb_detail_penjualan,tb_penjualan WHERE tblbarang.KodeBarang=tb_detail_penjualan.KodeBarang " + 
                    "AND tb_penjualan.NoFaktur = tb_detail_penjualan.NoFaktur" + 
                     "AND tb_detail_penjualan.NoFaktur= '"+txt_nofaktur.getText()+"'"; 
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
        } catch (Exception ex) { 
            System.err.println(ex.getMessage()); 
        } 
    } 

    
    private void TampilGridDetail(){
    String stat ="";
    try {
        koneksi();
        String     SQL = "SELECT tblbarang.KodeBarang,tblbarang.namabarang,tblbarang.hargajual,"
                         +"tblbarang.stok,tb_detail_penjualan.jumlah,tb_detail_penjualan.subtotal,tb_penjualan.NoFaktur " +
                         "FROM tblbarang, tb_detail_penjualan, tb_penjualan " +
                         "WHERE tblbarang.KodeBarang = tb_detail_penjualan.KodeBarang " +
                         "AND tb_penjualan.NoFaktur = tb_detail_penjualan.NoFaktur " +
                         "AND tb_detail_penjualan.NoFaktur='" + txt_nofaktur.getText() + "'";
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
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }   
  } 
    
    
     public void TampilComboBarang(){
         try {    
         koneksi ();
         String     SQL = "SELECT * FROM tb_barang";
        ResultSet  res = cn.executeQuery(SQL);
        while(res.next()){
        kode_barang.addItem(res.getString("KodeBarang"));
       }
        } catch (SQLException ex) {
        }
    }
    
     public void TampilComboPetugas(){ 
        try {      
        koneksi ();
        String     SQL = "SELECT * FROM tb_petugas"; 
        ResultSet  res = cn.executeQuery(SQL); 
        while(res.next()){ 
            IDPetugas.addItem(res.getString("IDPetugas")); 
     } 
        } catch (SQLException ex) { 
        } 
    }   
     
    private void txt_nofakturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nofakturActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nofakturActionPerformed

    private void IDPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDPetugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDPetugasActionPerformed

    private void btn_hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hitungActionPerformed
      // TODO add your handling code here:
        int a;
        int b;
        double c;   
           a = Integer.parseInt(txt_hargajual.getText());
           b = Integer.parseInt(txt_jumlah.getText());
           c = a * b; 
        txt_subtotal.setText(String.valueOf(c));
    
    }//GEN-LAST:event_btn_hitungActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
  // TODO add your handling code here:
        try { 
        koneksi ();
        String     SQL = "SELECT * FROM tb_penjualan where NoFaktur='"+txt_nofaktur.getText()+"'"; 
        ResultSet  res = cn.executeQuery(SQL); 
        res.absolute(1); 
        TampilGridDetail(); 
        txt_tanggalpenjualan.setText(res.getString("tglpenjualan")); 
        IDPetugas.setSelectedItem(res.getString("idpetugas")); 
        txt_bayar.setText(res.getString("bayar")); 
        txt_sisa.setText(res.getString("sisa")); 
        txt_total.setText(res.getString("total")); 
        btn_savetransaction.setEnabled(false); 
        txt_nofaktur.setEnabled(false); 
        btn_cari.setEnabled(false); 
        } catch (SQLException ex) { 
        } 
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
// TODO add your handling code here:
         if(JOptionPane.showConfirmDialog(null,"This application will be close \n if you press button OK","Information",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION) 
        this.dispose();
//           new FrmMenu().setVisible(true);
    
    }//GEN-LAST:event_btn_closeActionPerformed

    private void txt_tanggalpenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tanggalpenjualanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tanggalpenjualanActionPerformed

    private void txt_sisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sisaActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void btn_additemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_additemActionPerformed
// TODO add your handling code here:
        String NM=txt_nofaktur.getText(); 
        String KB=kode_barang.getSelectedItem().toString(); 
        String JM=txt_jumlah.getText(); 
         
        if ((NM.isEmpty()) | (KB.isEmpty()) |(JM.isEmpty())) { 
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi"); 
            kode_barang.requestFocus(); 
        }else { 
             
            try { 
                koneksi();
                try (Statement stt = conn.createStatement()) {
                    String     SQL = "insert into tb_detail_penjualan values('"+txt_nofaktur.getText()+"',"+
                            "'"+kode_barang.getSelectedItem()+"',"+
                            "'"+txt_jumlah.getText()+"',"+
                            "'"+txt_subtotal.getText()+"')";
                    stt.executeUpdate(SQL);
                    
                    koneksi();
                    Statement  stt1 = conn.createStatement();
                    String     SQL1 = "Update tb_barang Set stok=stok - '"+txt_jumlah.getText()+"'" +
                            "Where KodeBarang='"+kode_barang.getSelectedItem().toString()+"'";
                    stt1.executeUpdate(SQL1);
                    data[0] = kode_barang.getSelectedItem().toString();
                    data[1] = txt_namabarang.getText();
                    data[2] = txt_hargajual.getText();
                    data[3] = txt_stok.getText();
                    data[4] = txt_jumlah.getText();
                    data[5] = txt_subtotal.getText();
                    tableModel.insertRow(0, data);
                } 
                conn.close(); 
                kode_barang.requestFocus(); 
                btn_additem.setEnabled(false); 
                BersihDetail(); 
                kode_barang.requestFocus(); 
            } catch (Exception ex) { 
                System.err.println(ex.getMessage()); 
            } 
        }        
    }//GEN-LAST:event_btn_additemActionPerformed

    
    private void txt_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bayarActionPerformed

    private void btn_addnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addnewActionPerformed
      
        SetEditOn(); 
        BersihData();
        txt_nofaktur.requestFocus();  
        tampilfaktur();
        
    }//GEN-LAST:event_btn_addnewActionPerformed
    public void tampilfaktur() {
        Date sk = new Date();

        SimpleDateFormat format1=new SimpleDateFormat("yyMMdd");
        String time = format1.format(sk);
        koneksi();
        String sql = "select right(NoFaktur,1) as kd from tb_penjualan order by kd desc";

        try{
       try (ResultSet rs = cn.executeQuery(sql)) {
           if (rs.next()){
              
               int kode = Integer.parseInt(rs.getString("kd"))+1;
              
               txt_nofaktur.setText(time+Integer.toString(kode));
              
           }else{
              
               int kode = 1;
              
               txt_nofaktur.setText(time+Integer.toString(kode));
              
           }
       }

        }catch (SQLException | NumberFormatException e){

            JOptionPane.showMessageDialog(null, e);

        }     
       }

    private void txt_namabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabarangActionPerformed

    private void txt_stokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stokActionPerformed

    private void txt_jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlahActionPerformed

    private void TabelPenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPenjualanMouseClicked
        
                       
    }//GEN-LAST:event_TabelPenjualanMouseClicked
  
    public void BersihData(){ 
     tableModel.setRowCount(0); 
   //  NoFaktur.setText(""); 
     txt_namapetugas.setText(""); 
     IDPetugas.setSelectedIndex(0); 
     kode_barang.setSelectedIndex(0); 
     txt_namabarang.setText("");    
     txt_hargajual.setText(""); 
     txt_jumlah.setText(""); 
     txt_stok.setText(""); 
     txt_bayar.setText("0"); 
     txt_sisa.setText("0"); 
     txt_total.setText("0"); 
     txt_subtotal.setText("0"); 
  } 
     public void BersihDetail(){ 
     kode_barang.setSelectedIndex(0); 
     txt_namabarang.setText("");   
     txt_hargajual.setText(""); 
     txt_stok.setText(""); 
     txt_jumlah.setText(""); 
     txt_subtotal.setText("0"); 
     } 
      
     public void SetEditOff(){ 
     txt_nofaktur.setEnabled(false); 
     txt_tanggalpenjualan.setEnabled(false); 
     IDPetugas.setEnabled(false); 
     kode_barang.setEnabled(false); 
     txt_jumlah.setEnabled(false); 
     btn_hitung.setEnabled(false); 
     btn_cari.setEnabled(false); 
     btn_additem.setEnabled(false); 
     } 
      
     public void SetEditOn(){ 
     txt_nofaktur.setEnabled(true); 
     txt_tanggalpenjualan.setEnabled(true); 
     IDPetugas.setEnabled(true); 
     kode_barang.setEnabled(true); 
     txt_jumlah.setEnabled(true); 
     btn_savetransaction.setEnabled(true); 
     btn_cari.setEnabled(true); 
     btn_hitung.setEnabled(true); 
     btn_additem.setEnabled(true); 
     }  
     
    private void IDPetugasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_IDPetugasItemStateChanged
    try {      
    koneksi();
    String     SQL = "SELECT * FROM tb_petugas where IDPetugas='"+ 
    IDPetugas.getSelectedItem().toString()+"'"; 
    ResultSet  res = cn.executeQuery(SQL); 
    res.absolute(1); 
    txt_namapetugas.setText(res.getString("namapetugas")); 
        } catch (SQLException ex) { 
        }                
    }//GEN-LAST:event_IDPetugasItemStateChanged

    
    private void kode_barangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_kode_barangItemStateChanged
         // TODO add your handling code here:
          try {      
        koneksi();
        String     SQL = "SELECT * FROM tb_barang where KodeBarang='"+ 
        kode_barang.getSelectedItem().toString()+"'"; 
        ResultSet  res = cn.executeQuery(SQL); 
        res.absolute(1); 
        txt_namabarang.setText(res.getString("namabarang")); 
        txt_hargajual.setText(res.getString("hargajual")); 
        txt_stok.setText(res.getString("stok")); 
        } catch (SQLException ex) { 
        } 
         txt_jumlah.requestFocus(); 
         btn_additem.setEnabled(true); 
         
    }//GEN-LAST:event_kode_barangItemStateChanged

    private void txt_subtotalCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_subtotalCaretUpdate
 // TODO add your handling code here:
              double d, e;   
            d = Double.parseDouble(txt_subtotal.getText());  
            e = Double.parseDouble(txt_total.getText());  
            e = e+d;   
            txt_total.setText(String.valueOf(e)); 
    }//GEN-LAST:event_txt_subtotalCaretUpdate

    private void txt_bayarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_bayarCaretUpdate
       double a; 
       double b; 
       double c;  
            a = Double.parseDouble(txt_bayar.getText());  
            b = Double.parseDouble(txt_total.getText()); 
            c = a - b;   
            txt_sisa.setText(String.valueOf(c)); 
    }//GEN-LAST:event_txt_bayarCaretUpdate

    private void btn_savetransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_savetransactionActionPerformed
   // TODO add your handling code here:
          String NM=txt_nofaktur.getText(); 
         
        if ((NM.isEmpty())) { 
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi"); 
            txt_nofaktur.requestFocus(); 
        }else { 
             
            try { 
               koneksi (); 
                String     SQL = "insert into tb_penjualan values('"+txt_nofaktur.getText()+"',"+ 
                        "'"+txt_tanggalpenjualan.getText()+"',"+ 
                        "'"+IDPetugas.getSelectedItem()+"',"+ 
                        "'"+txt_bayar.getText()+"',"+ 
                        "'"+txt_sisa.getText()+"',"+ 
                        "'"+txt_total.getText()+"')";  
                cn.executeUpdate(SQL); 
                cn.close(); 
                conn.close(); 
                BersihData(); 
                SetEditOff(); 
                btn_savetransaction.setEnabled(false); 
            } catch (Exception ex) { 
                System.err.println(ex.getMessage()); 
            } 
        }

    }//GEN-LAST:event_btn_savetransactionActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
       BersihData(); 
        SetEditOff(); 
    }//GEN-LAST:event_btn_cancelActionPerformed

     public void koneksi(){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_penjualan_barang_pas_xiia","root","");
        cn = conn.createStatement();
    }catch (ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null,"koneksi gagal..");
         JOptionPane.showMessageDialog(null,e.getMessage());
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
            java.util.logging.Logger.getLogger(Form_Penjualan_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Penjualan_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Penjualan_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Penjualan_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Penjualan_barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> IDPetugas;
    private javax.swing.JTable TabelPenjualan;
    private javax.swing.JButton btn_additem;
    private javax.swing.JButton btn_addnew;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_hitung;
    private javax.swing.JButton btn_savetransaction;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kode_barang;
    private javax.swing.JTextField txt_bayar;
    private javax.swing.JTextField txt_hargajual;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_namabarang;
    private javax.swing.JTextField txt_namapetugas;
    private javax.swing.JTextField txt_nofaktur;
    private javax.swing.JTextField txt_sisa;
    private javax.swing.JTextField txt_stok;
    private javax.swing.JTextField txt_subtotal;
    private javax.swing.JFormattedTextField txt_tanggalpenjualan;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
