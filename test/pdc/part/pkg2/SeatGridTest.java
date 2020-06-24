/*
 * --- DESCRIPTION ---
 * 
 * Tests the method returnUserSelected from SeatGrid. The
 * methods are made to check if the ArrayList, list, will be empty.
 * If it is empty, then the test fails, the same goes for the latter. 
 */
package pdc.part.pkg2;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Elijah and John
 */
public class SeatGridTest {
    
    private ArrayList<int[]> list;
    private SeatGrid instance;
    
    @Before
    public void setUp()
    {
        list = new ArrayList<int[]>();
        instance = new SeatGrid();
        //Economy Class Swing Buttons Instantiation
        System.out.println("Before (CALLED): setUpClass");
    }
    
    
    @After
    public void tearDown() 
    {
        System.out.println("After (CALLED): tearDownClass");
    }
   
    
    /*
    * DESCRIPTION: For this method returnUserSelectedSeats 
    * It is testing if the arraylist, list, is empty. 
    */
    @Test
    public void returnUserSelectedSeats()
    {
        int[] seat;
        for(int y = 0; y < 3; y++) //First Class
        {
            for(int x = 0; x < 9; x++)
            {   
                seat = new int[3];
                seat[0] = 1;
                seat[1] = x;
                seat[2] = y;
                list.add(seat);
            }
            
            System.out.println("");
        }
        
        for(int y = 0; y < 10; y++) //Economy Class
        {
            for(int x = 0; x < 9; x++)
            {
                seat = new int[3];
                seat[0] = 2;
                seat[1] = x;
                seat[2] = y;
                list.add(seat);
               
            }
        }
        assertFalse(list.isEmpty());
    }
}

