/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.part.pkg2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static pdc.part.pkg2.TrainBookingProgram.writer;

/**
 *
 * @author Admin
 */
public class FileTest {
    
    private TrainDataModel instance;
    public FileTest() {
    }
    
    private File file;
    private BufferedWriter writer;
    private BufferedReader reader;
    @BeforeClass
    public static void setUpClass()
    {
        System.out.println("Beforeclass (CALLED): setUpClass");
    }
    
    @AfterClass
    public static void tearDownClass() 
    {
        System.out.println("Afterclass (CALLED): tearDownClass");
    }
    
    @Before //writing
    
     public void setUp()
    {
        System.out.println("Before (CALLED): setUp");
        
        instance = new TrainDataModel();
        ArrayList<int[]> testing = instance.getBookedSeatList();
        file = new File("testing.txt");
        try
        {
            writer = new BufferedWriter(new FileWriter(file, false));
            for(int y = 0; y < instance.getBookedSeatList().size(); y++)
            {
                for(int index = 0; index < 5; index++)
                {
                    writer.write(instance.getBookedSeatList().get(y)[index] + " ");
                }
                
                writer.write("\n");
            }
            
            
        }catch(IOException er)
        {
            Logger.getLogger(FileTest.class.getName()).log(Level.SEVERE, null, er);
        }
        finally
        {
             System.out.println("SAVED INTO BOOKED SEAT");
        }
        
        
        
    }
    
    @After
    public void tearDown()
    {
        System.out.println("After (CALLED): tearDown()");
        if (file.delete()) {
            System.out.println(file.getName() + " is deleted!");
        } else {
            System.out.println("Failed to delete " + file.getName());
        }
        
    }
    
    @Test
    public void testRead()
    {
        int[] results = new int[5];
        results[0] = 1;
        results[1] = 2;
        results[2] = 1;
        results[3] = 0;
        results[4] = 0;
        
        instance.getBookedSeatList().add(results);
        int lineNumber = 0;
        file = new File("testing.txt");
        ArrayList<int[]> output = new ArrayList<>();
        String rawString;
        int xIndex = 0;
        int yIndex = 0;
        String line = "";
        try
        {
            reader = new BufferedReader(new FileReader(file));

            while((line = reader.readLine()) != null)
            {
                xIndex = 0;
                output.add(new int[5]);
                rawString = line;
                
                for(String s : rawString.split(" "))
                {
                    output.get(yIndex)[xIndex] = Integer.parseInt(s);
                    xIndex++;
                }
                
                yIndex++;
                lineNumber++;
            }
        }
        catch (IOException ex)
        {
            System.err.println("ERROR: " + ex.getMessage());
        }
        
        int expected = lineNumber;
        Assert.assertEquals(expected,lineNumber);
    }
    
    @Test
    public void testReadAgain()
    {
  
        int[] results = new int[5];
        results[0] = 1;
        results[1] = 2;
        results[2] = 1;
        results[3] = 0;
        results[4] = 0;
        
        instance.getBookedSeatList().add(results);
        int lineNumber = 0;
        file = new File("testing.txt");
        ArrayList<int[]> output = new ArrayList<>();
        String rawString;
        int xIndex = 0;
        int yIndex = 0;
        String line = "";
        try
        {
            reader = new BufferedReader(new FileReader(file));

            while((line = reader.readLine()) != null)
            {
                xIndex = 0;
                output.add(new int[5]);
                rawString = line;
                
                for(String s : rawString.split(" "))
                {
                    output.get(yIndex)[xIndex] = Integer.parseInt(s);
                    xIndex++;
                }
                
                yIndex++;
                lineNumber++;
            }
        }
        catch (IOException ex)
        {
            System.err.println("ERROR: " + ex.getMessage());
        }
        
        int expected = lineNumber;
        Assert.assertEquals(expected,lineNumber);
    
    }

}
