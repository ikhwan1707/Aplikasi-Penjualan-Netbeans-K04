import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author lab-4
 */
public class Petugas extends javax.swing.JFrame {
     private DefaultTableModel model;

    /**
     * Creates new form Petugas
     */
    public Petugas() {
        initComponents();
        loadData();
        kosong();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
     private void loadData () {
        model = new DefaultTableModel();
        
        model.getDataVector().removeAllElements();
        
        model.fireTableDataChanged();
        
        TxtPetugas.setModel(model);
        model.addColumn("ID");
        model.addColumn("NAMA");
        model.addColumn("ALAMAT");
        model.addColumn("EMAIL");
        model.addColumn("TELEPON"); 
        
        try {
            String sql = "SELECT * FROM tbl_petugas";
            
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()){
                model.addRow(new Object[]{
                    r.getString(1),
                    r.getString(2),
                    r.getString(3),
                    r.getString(4),
                    r.getString(5)
                });
            }
            TxtPetugas.setModel(model);
        } catch (SQLException e) {
            System.out.println("Terjadi error");
        }
    }
        private void kosong(){
        TxtID.setText(null);
        TxtNama.setText(null);
        TxtAlamat.setText(null);
        TxtEmail.setText(null);
        TxtTelepon.setText(null);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtID = new javax.swing.JTextField();
        TxtNama = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtAlamat = new javax.swing.JTextArea();
        TxtEmail = new javax.swing.JTextField();
        TxtTelepon = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TxtPetugas = new javax.swing.JTable();
        BtnSave = new javax.swing.JButton();
        BtnUpdate = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        BtnCancel = new javax.swing.JButton();
        BtnClose = new javax.swing.JButton();

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
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID PETUGAS");

        jLabel2.setText("Nama Petugas");

        jLabel3.setFont(new java.awt.Font("Serif", 0, 36)); // NOI18N
        jLabel3.setText("PETUGAS");

        jLabel5.setText("Telepon");

        jLabel6.setText("EMAIL");

        TxtID.setBackground(new java.awt.Color(255, 204, 204));

        TxtNama.setBackground(new java.awt.Color(255, 204, 204));

        jLabel7.setText("Alamat Petugas");

        TxtAlamat.setBackground(new java.awt.Color(204, 204, 255));
        TxtAlamat.setColumns(20);
        TxtAlamat.setRows(5);
        jScrollPane1.setViewportView(TxtAlamat);

        TxtEmail.setBackground(new java.awt.Color(204, 255, 255));

        TxtTelepon.setBackground(new java.awt.Color(204, 255, 255));

        TxtPetugas.setBackground(new java.awt.Color(204, 255, 204));
        TxtPetugas.setModel(new javax.swing.table.DefaultTableModel(
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
        TxtPetugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtPetugasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TxtPetugas);

        BtnSave.setBackground(new java.awt.Color(255, 255, 153));
        BtnSave.setText("SAVE");
        BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveActionPerformed(evt);
            }
        });

        BtnUpdate.setBackground(new java.awt.Color(255, 255, 153));
        BtnUpdate.setText("UPDATE");
        BtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateActionPerformed(evt);
            }
        });

        BtnDelete.setBackground(new java.awt.Color(255, 255, 153));
        BtnDelete.setText("DELETE");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        BtnCancel.setBackground(new java.awt.Color(255, 255, 153));
        BtnCancel.setText("CANCEL");
        BtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelActionPerformed(evt);
            }
        });

        BtnClose.setBackground(new java.awt.Color(255, 255, 153));
        BtnClose.setText("CLOSE");
        BtnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnSave)
                                .addGap(32, 32, 32)
                                .addComponent(BtnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnDelete)
                                .addGap(18, 18, 18)
                                .addComponent(BtnCancel)
                                .addGap(30, 30, 30)
                                .addComponent(BtnClose))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel4))
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addGap(79, 79, 79)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TxtNama)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                    .addComponent(TxtEmail)
                                    .addComponent(TxtTelepon)
                                    .addComponent(TxtID, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jLabel3)))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(TxtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSave)
                    .addComponent(BtnUpdate)
                    .addComponent(BtnDelete)
                    .addComponent(BtnCancel)
                    .addComponent(BtnClose))
                .addContainerGap(205, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        // TODO add your handling code here:
        String id = TxtID.getText();
         String nama = TxtNama.getText();
         String alamat = TxtAlamat.getText();
         String email = TxtEmail.getText();
          String telepon = TxtTelepon.getText();
          
          if ("".equals(id) || "".equals(nama) ||
                "".equals(alamat) || "".equals(email) || 
                 "".equals(telepon))
         {
             JOptionPane.showMessageDialog(this, "Harap Lengkapi Data", "Error", JOptionPane.WARNING_MESSAGE);
             
         }else{
             try{
                 Connection c = Koneksi.getKoneksi();
                 String sql = "INSERT INTO tbl_petugas VALUES (?, ?, ?, ?, ? )";
                 PreparedStatement p  = c.prepareCall(sql);
                 
                 p.setString(1, id);
                 p.setString(2, nama);
                 p.setString(3, alamat);
                 p.setString(4, email);
                 p.setString(5, telepon);
                 p.executeUpdate();
                 p.close();
                 
                 JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
                 
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }finally{
                 loadData();
                 kosong();
             }
         }  
         
    }//GEN-LAST:event_BtnSaveActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        // TODO add your handling code here:
        
        int i = TxtPetugas.getSelectedRow();
        
        if(i == -1){
            JOptionPane.showMessageDialog(this, "Harap Pilih Data",
                    "error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String id = (String) model.getValueAt(i, 0);
        
         try{
            Connection c = Koneksi.getKoneksi();
            
            String sql = "DELETE FROM tbl_petugas WHERE id = ?";
            
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(i, id);
            p.executeUpdate();
            p.close();
            
             JOptionPane.showMessageDialog(null, "Hapus Data Berhasil");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Terjadi error");
        }finally{
            loadData();
            kosong();
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateActionPerformed
        // TODO add your handling code here:
        int i = TxtPetugas.getSelectedRow();
        
        if(i == -1){
            JOptionPane.showMessageDialog(this, "Harap Pilih Data",
                    "error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String id = (String) model.getValueAt(i, 0);
        String nama = TxtNama.getText();
        String alamat = TxtAlamat.getText();
        String email = TxtEmail.getText();
        String telepon = TxtTelepon.getText();
        
         try{
            Connection c = Koneksi.getKoneksi();
            
            String sql = "UPDATE tbl_petugas SET , nama_petugas = ?,  alamat_petugas = ?, email = ?  , telepon = ?  WHERE id = ?";
            
            PreparedStatement p = c.prepareStatement(sql);
            
            p.setString(1, nama);
            p.setString(2, alamat);
            p.setString(3, email);
            p.setString(4, telepon);
            p.setString(5, id);
            
            p.executeUpdate();
            p.close();
            
            JOptionPane.showMessageDialog(null, "Ubah data berhasil");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Terjadi error" + e.getMessage());
        }finally{
            loadData();
            kosong();
        }
    }//GEN-LAST:event_BtnUpdateActionPerformed

    private void BtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelActionPerformed
        // TODO add your handling code here:
       kosong();
    }//GEN-LAST:event_BtnCancelActionPerformed

    private void BtnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_BtnCloseActionPerformed

    private void TxtPetugasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtPetugasMouseClicked
        // TODO add your handling code here:
         int baris = TxtPetugas.getSelectedRow();
        
        if(baris == -1){
            return;
        }
        
        String id = TxtPetugas.getValueAt(baris, 0).toString();
        TxtID.setText(id);
        String nama = TxtPetugas.getValueAt(baris, 1).toString();
        TxtNama.setText(nama);
        String alamat = TxtPetugas.getValueAt(baris, 2).toString();
        TxtAlamat.setText(alamat);
        String email = TxtPetugas.getValueAt(baris, 3).toString();
        TxtEmail.setText(email);
        String telepon = TxtPetugas.getValueAt(baris, 4).toString();
        TxtTelepon.setText(telepon);
    }//GEN-LAST:event_TxtPetugasMouseClicked

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
            java.util.logging.Logger.getLogger(Petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Petugas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancel;
    private javax.swing.JButton BtnClose;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnSave;
    private javax.swing.JButton BtnUpdate;
    private javax.swing.JTextArea TxtAlamat;
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JTextField TxtID;
    private javax.swing.JTextField TxtNama;
    private javax.swing.JTable TxtPetugas;
    private javax.swing.JTextField TxtTelepon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}