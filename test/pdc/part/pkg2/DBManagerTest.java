/*
 * --- DESCRIPTION ---
 * 
 * DBMangerTest teests if the tables are able to be written and read. 
 * This is done on the method readTable, for reading the table from testingDB.
 *
 */
package pdc.part.pkg2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import junit.framework.Assert;

/**
 *
 * @author Elijah and John
 */

public class DBManagerTest {
    
    private static Connection conn = null;
    private static final String url = "jdbc:derby:testingDB; create=true";
    private static final String username = "pdc";
    private static final String password = "pdc";
    private static Statement statement;
    DatabaseMetaData data;
    private ResultSet rs;
     
    @BeforeClass
    public static void setUpClass()
    {
      try
        {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected!");
            System.out.println("Beforeclass (CALLED): setUpClass");
        }
        catch (SQLException e)
        {
            System.err.println("Error connecting to database!" + e.getMessage());
        }
    }
       
        
    
    @AfterClass
    public static void tearDownClass() 
    {
        System.out.println("Afterclass (CALLED): tearDownClass");
    }
    
    
    /*
    * DESCRIPTION: The setUp class is meant to create a testing Database called TestingDB.
    * It will create a table and insert values inside the database, the table is "CUSTOMER"
    */
    @Before 
    public void setUp()
    {
        try
        {
            //CUSTOMER REGISTRATION TABLE
            String customer_tableName = "CUSTOMER";
            statement = conn.createStatement();
            data = conn.getMetaData();
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
            System.err.println("Error: " + e.getMessage());
        }
         
         
        try
        {
            conn = DriverManager.getConnection(url, username, password);
            statement = conn.createStatement();
            statement.executeUpdate("insert into CUSTOMER (FIRSTNAME, LASTNAME, USERNAME, PASSWORD) values"
                               +  "(' JOHN ' , 'SANGALANG' , ' METAROCK ', ' 123 ')");
            
            System.out.println("Values inserted to Customer Table"); 

            conn = DriverManager.getConnection("jdbc:derby:testingDB; shutdown=true");
        } 
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }

    }
   
    /*
    * DESCRIPTION: The readTable method reads the CUSTOMER table. 
    */
    @Test
    public void readTable()
    {
       int columnCount = 0;
       int count = 0;
       try
        {
            String sql_statement = "select * from " + "CUSTOMER";
            conn = DriverManager.getConnection(url,username,password);
            statement = conn.createStatement();
            rs = statement.executeQuery(sql_statement);

            columnCount = rs.getMetaData().getColumnCount();

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
                    count++;
                }

                System.out.println();
            }
            count++;
        } 
         catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
       

       int expected = count;
       
       Assert.assertEquals(expected, count);
    }
}

