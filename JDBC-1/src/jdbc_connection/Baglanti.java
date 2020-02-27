package jdbc_connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.crypto.provider.RSACipher;

 
public class Baglanti {
    
    private String kullanici_adi = "root";
    private String parola = "123456";
    
    private String db_ismi = "jpa1.schema";
    
    private String host =  "localhost";
    
    private int port = 3306;
    
    private Connection con = null;
    
    private Statement statement=null;
      
    public Baglanti() {
        
       //String url = "jdbc:mysql://" + host + ":" + port + "/" + db_ismi+ "?useUnicode=true&characterEncoding=utf8";
    	String url = "jdbc:mysql://" + host + ":" + port + "/" + db_ismi+ "?serverTimezone=UTC";
    
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadi....");
        }
        
        
        try {
          con = DriverManager.getConnection(url, kullanici_adi, parola);
        	
            System.out.println("Baglanti Basarili...");
     
            
        } catch (SQLException ex) {
            System.out.println("Baglanti Basarisiz...");
           // ex.printStackTrace();
        }
        
    }
    
    public void sorgulari_getir()
    {
    	try {
			statement = con.createStatement();
			String sorgu = "Select * From employer";
			ResultSet rs = statement.executeQuery(sorgu);
			
		
			while(rs.next())
			{
				String name= rs.getString("name");
				String surname= rs.getString("surname");
				System.out.println("name = " +name + " " + "surname = " +surname);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void main(String[] args) {
        Baglanti baglanti = new Baglanti();
        baglanti.sorgulari_getir();
        
        
        
        
    }
    
    
}
