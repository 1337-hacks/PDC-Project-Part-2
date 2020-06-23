/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.part.pkg2;

import java.awt.Robot;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
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
    
    @Test
    public void testListInIt()
    {
        assertTrue(list.isEmpty());
        assertTrue(list.size() == 0);
    }
    @After
    public void tearDown() 
    {
        System.out.println("After (CALLED): tearDownClass");
    }
   
    
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

