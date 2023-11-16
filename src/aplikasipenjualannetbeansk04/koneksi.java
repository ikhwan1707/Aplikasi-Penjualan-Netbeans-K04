/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasipenjualannetbeansk04;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author labprog233
 */
public class koneksi {
    public static Connection koneksi;
//   public static void main(String[] args){
      public static Connection getKoneksi() {
        if(koneksi== null)
        {
            try {
                String url = "jdbc:mysql://localhost:3306/db_penjualan_barang_pas_xiia";
                String user = "root";
                String password ="";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksi = DriverManager.getConnection(url,user,password);
                System.out.print("berhasil membuat koneksi");
            } catch (SQLException t) {
                System.out.print("Error membuat koneksi");
            }

        }
        return koneksi;
    }
}
