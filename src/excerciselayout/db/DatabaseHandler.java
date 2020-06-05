package excerciselayout.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Book;

/**
 *
 * @author CzirkO
 */
public class DatabaseHandler {

    private static final String URL = "jdbc:derby:db;create=true";
    final String USERNAME = "";
    final String PASSWORD = "";

    Connection conn = null;
    Statement stmt = null;
    
    DatabaseMetaData dbmd = null;

    public DatabaseHandler() {

        createConn();
        setupBookTable();

    }

    void createConn() {

        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Híd kész");
        } catch (SQLException ex) {
            System.out.println("gáz van a connectionnel " + ex);
        }

    }

    void setupBookTable() {
        String TABLE_NAME = "BOOK";

        try {
            dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            stmt=conn.createStatement();
            if (!rs.next()) {

                stmt.execute("create table BOOK(id varchar(200) primary key,"
                        + "  title varchar(200), author varchar(200), "
                        + "publisher varchar(100),"
                        + "intcode varchar(100),"
                        + "isAvailable boolean default true)");
            } else {
                System.out.println("Tables already exist. Go toward!");
            }

        } catch (SQLException ex) {
            System.out.println("Adattábla create problem " + ex);
        }

    }

    

    public boolean addBook(String bookId, String title, String author,String publisher,boolean isAvailable){
        String sql = "insert into BOOK (id,title, author,publisher,isAvailable)values(?,?,?,?,?)";
        
        try {
            PreparedStatement stat=conn.prepareStatement(sql);
            stat.setString(1, bookId);
               stat.setString(2, title);
               stat.setString(3, author);
               stat.setString(4, publisher);
               stat.setBoolean(5, true);
               return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            
              System.out.println("baj van a hozzáadáskor" + ex);
              return false;
        }
    }
        
        public List<Book> getAllBook(){
            String sql ="SELECT * FROM BOOK";
            List<Book> books = new ArrayList<>();
            try{
                 stmt=conn.createStatement();
                ResultSet rs  = stmt.executeQuery(sql);
                while(rs.next()){
                    Book b = new Book(rs.getString("id"), rs.getString("title"), rs.getString("author"), rs.getString("publisher"), Boolean.TRUE);
                    books.add(b);
                }
                System.out.println("A getAllBook sikeres mérete:"+ books.size());
                
            }catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            
              System.out.println("baj van a lekérdezéskor" + ex);
            
            }
            
            return books;
        }
       
        
                
             
    

}
