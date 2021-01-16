package jsp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MySql {
    private final static String URL = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=" + TimeZone.getDefault().getID();
    private final static String USER = "root";
    private final static String PASSWORD = "lorenzo1994";
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String DROP_TABLE = "DROP TABLE IF EXISTS requests";
    private final static String CREATE_TABLE = "CREATE TABLE requests (\n" +
	"     id MEDIUMINT NOT NULL AUTO_INCREMENT,\n" +
	"     numero CHAR(30) NOT NULL,\n" +
	"     dataRilascio CHAR(30) NOT NULL,\n" +
	"     dataScad CHAR(30) NOT NULL,\n" +
	"     ente CHAR(30) NOT NULL,\n" +
	"     PRIMARY KEY (id)\n" +
	");";
    
    
    
    
    private final static String INSERT = "INSERT INTO requests " + "(numero, dataRilascio, dataScad, ente) values (?,?,?,?)";
    private final static String SELECT = "SELECT * from requests";
    public static void main(String[] args) {
    //Qui il codice JDBC
    	
    }
    

	public void JDBC(String numero, String dataRilascio, String dataScad, String ente) {
		//final String numero="321s123";
    	//final String ente="motorizzazione", dataRilascio="01-01-2021", dataScad="01-01-2022"; 
        	try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        		       Statement stmt = conn.createStatement();
        		       PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
        		Class.forName(DRIVER);
        		  System.out.println("ho creato la tabella");
        		  pstmt.setString(1, numero);
        		  pstmt.setString(2, dataRilascio);
        		  pstmt.setString(3, dataScad);
        		  pstmt.setString(4, ente);
        		  pstmt.execute();
        		  System.out.println("ho inviato i dati");
        		  
        		  } catch (ClassNotFoundException | SQLException ex) {
        		            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        		}
		
	}
    
    
}