/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.part.pkg2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;


/**
 *
 * @author Elijah and John
 */
public class FileTest 
{
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
    
    
    @Before //writing into testing.txt file
     public void setUp()
    {
        System.out.println("Before (CALLED): setUp");
        
        //Setting up variables
        ArrayList<int[]> bookedSeatList = new ArrayList<int[]>();
        
        int[] testSeat1 = {1, 1, 1, 1, 1};
        int[] testSeat2 = {2, 3, 2, 5, 7};
        int[] testSeat3 = {1, 2, 2, 3, 0};
        
        bookedSeatList.add(testSeat1);
        bookedSeatList.add(testSeat2);
        bookedSeatList.add(testSeat3);
        
        //Writing into testing.txt file
        try
        {
            writer = new BufferedWriter(new FileWriter("testing.txt", false));
            
            for(int y = 0; y < bookedSeatList.size(); y++)
            {
                for(int index = 0; index < 5; index++)
                {
                    writer.write(bookedSeatList.get(y)[index] + " ");
                }
                
                writer.write("\n");
            }
            
            writer.close();
        }
        catch(IOException er)
        {
            Logger.getLogger(FileTest.class.getName()).log(Level.SEVERE, null, er);
        }
        finally
        {
             System.out.println("SAVED INTO BOOKED SEAT");
        }
    }
    
     
    @Test
    public void testRead()
    {
        int lineNumber = 0;
        ArrayList<int[]> output = new ArrayList<>();
        String rawString;
        int xIndex = 0;
        int yIndex = 0;
        String line = "";
        
        try
        {
            reader = new BufferedReader(new FileReader("testing.txt"));

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
      
        Assert.assertEquals(3, lineNumber);
    }
    
    
    @Test
    public void testReadAgain()
    {
        int lineNumber = 0;
        ArrayList<int[]> output = new ArrayList<>();
        String rawString;
        int xIndex = 0;
        int yIndex = 0;
        String line = "";
        try
        {
            reader = new BufferedReader(new FileReader("testing.txt"));

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
        
        Assert.assertEquals(3, lineNumber);
    
    }

}
