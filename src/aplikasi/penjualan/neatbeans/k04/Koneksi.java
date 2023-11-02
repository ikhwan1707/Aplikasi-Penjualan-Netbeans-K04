/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;

package aplikasi.penjualan.neatbeans.k04;

/**
 *
 * @author lab-4
 */
public class Koneksi {
    public static Connection koneksi;
    
    public static Connection getKoneksi(){
        
        if(koneksi == null)
   
        {
            
    try {
    String url = "jdbc:mysql://localhost:3306/crud_sederhana_xiia";
    String user ="root";
    String password = "";
    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
    koneksi = DriverManager.getConnection(url,user,password);
    System.out.print("Berhasil Membuat KOneksi");
    }catch (SQLException t){
     System.out.print("Error Membuat Koneksi");
    }
    
    }
        return koneksi;
}
}

