/*
 * --- DESCRIPTION ---
 * 
 * This class is used for managing the database, where it creates 
 * the necessary tables and adds values to the database tables.
 */

package pdc.part.pkg2;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Elijah 18023249 and John 18017056
 */
public class DBManager 
{
    //Variables
    
    private Connection conn = null;
    private String url = "jdbc:derby:TrainBookingDB; create=true";
    private String username = "pdc";
    private String password = "pdc";
    private Statement statement;
    DatabaseMetaData data;
    private ResultSet rs;
    private boolean error;
    
    //Constructor
    
    public DBManager()
    {
        establishConnection();
    }
    
    //Functions
    
    public void establishConnection()
    {
        try
        {
            conn = DriverManager.getConnection(getUrl(), getUsername(), getPassword());
            
            System.out.println("Connected!");
        }
        catch (SQLException e)
        {
            infoMessage("Error connecting to the database!", "Error");
            System.err.println("Error connecting to database!" + e.getMessage());
            this.error = true;
        }
    }
    
    public void closeConnection()
    {
        try
        {
            conn.close();
            rs.close();
            statement.close();
            System.out.println("Database closed successfully!");
        }
        catch (SQLException e)
        {
            infoMessage("Error closing the database!", "Error");
            System.err.println("Error closing the database!" + e.getMessage());
        }
    }
    
    //CREATE CUSTOMER AND BOOKING TABLES
    public void createTable()
    {
        try
        {
            statement = conn.createStatement();
            String bookings_tableName = "BOOKINGS";
            String tableCreateString =  "CREATE TABLE " + bookings_tableName + 
                                        "(" +
                                        "BOOKING_ID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1) , " +
                                        "USERNAME VARCHAR(100)," + 
                                        "CHOSEN_SERVICE VARCHAR(100)," +
                                        "CHOSEN_LINE VARCHAR(100)," +
                                        "SEAT VARCHAR(100), " +
                                        "TOTAL_PRICE VARCHAR(100)" +
                                        ")";

            data = conn.getMetaData();
            rs = data.getTables(null, null, bookings_tableName, null);
            
            if(rs.next())
            {
                System.out.println("Bookings Table already exists!");
            }
            else
            {
                statement.executeUpdate(tableCreateString);
                System.out.println("Booking Table created!");
            }
            
            //CUSTOMER REGISTRATION TABLE
            String customer_tableName = "CUSTOMER";
            
            rs = data.getTables(null, null, customer_tableName, null);
            
            if(rs.next())
            {
                System.out.println("Customer Table already exists!");
            }
            else
            {
                  statement.execute("CREATE TABLE " + customer_tableName + "(CUSTOMERID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1) , "
                                    + "FIRSTNAME VARCHAR(100), LASTNAME VARCHAR(100), "
                                    + "USERNAME VARCHAR(100), PASSWORD VARCHAR(100))");
                  
                  System.out.println("Customer Table created");
            }
        }
        catch (SQLException e)
        {
            infoMessage("Error with the database.", "Error");
            System.err.println("Error: " + e.getMessage());
            this.error = true;
        }
        catch (NullPointerException f)
        {
            infoMessage("Error with the database.", "Error");
            System.err.println("Error: " + f.getMessage());
            this.error = true;
        }
    }
    
    //VIEW CUSTOMER / BOOKING TABLE
     public void view(String tablename)
     {
        
        try
        {
            String sql_statement = "select * from " + tablename;
            conn = DriverManager.getConnection(url,username,password);
            statement = conn.createStatement();
            rs = statement.executeQuery(sql_statement);

            int columnCount = rs.getMetaData().getColumnCount();

            for(int x = 1; x <= columnCount; x++)
            {
                System.out.format("%20s", rs.getMetaData().getColumnName(x) + " | ");
            }
            
            System.out.println();

            while(rs.next())
            {
                for(int x = 1; x <= columnCount; x++)
                {
                    System.out.format("%20s", rs.getString(x) + " | ");
                }

                System.out.println();
            }
        } 
         catch (SQLException ex)
        {
            infoMessage("Error with the database!", "Error");
            System.err.println(ex.getMessage());
            this.error = true;
        }
        
    }
    
    //INSERT VALUES INTO CUSTOMER TABLE
    public void insertCustomerTable( String firstName, String lastName, String userName, String userPassword)
    {
        try
        {
            conn = DriverManager.getConnection(url, username, password);
            statement = conn.createStatement();
            statement.executeUpdate("insert into CUSTOMER (FIRSTNAME, LASTNAME, USERNAME, PASSWORD) values"
                               +  "('" + firstName + "' , '" + lastName + "' , '" + userName + "', '" + userPassword + "')");
            
            System.out.println("Values inserted to Customer Table"); 
            
            conn = DriverManager.getConnection("jdbc:derby:TrainBookingDB; shutdown=true");
        } 
        catch (SQLException ex)
        {
            infoMessage("Error with the database!", "Error");
            System.err.println(ex.getMessage());
            this.error = true;
        }
      
    }
    
    //Insert details into booking table
    public void insertBookingTable( String userName,String chosenService, String chosenLine, int seats, double totalPrice)
    {
        try
        {
            conn = DriverManager.getConnection(url, username, password);
            statement = conn.createStatement();
            String price = Double.toString(totalPrice);
            String numberSeats = Integer.toString(seats);
            statement.executeUpdate("insert into BOOKINGS (USERNAME, CHOSEN_SERVICE, CHOSEN_LINE, SEAT, TOTAL_PRICE) values"
                               +  "('" + userName + "' , '"+ chosenService +"' , '"
                               + chosenLine +"', '" + seats + "' , '" + price + "')");
            
            System.out.println("Values inserted to Bookings Table"); 

            conn = DriverManager.getConnection("jdbc:derby:TrainBookingDB; shutdown=true");
        } 
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
            this.error = true;
        }
      
    }
    
    public void infoMessage(String message, String title)
    {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    //Getters and Setters
    
    public Connection getConn() {
        return conn;
    }
    
    public void setConn(Connection conn) {
        this.conn = conn;
    }
  
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
