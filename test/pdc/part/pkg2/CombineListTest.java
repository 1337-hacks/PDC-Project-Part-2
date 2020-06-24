/*
 * --- DESCRIPTION ---
 * 
 * CombineListTest is to test the combineList method from TrainDataModel. 
 * In this test it sets a certain booked seats list in a local Arraylist 
 * bookedSeatList and tests if it saved into the arraylist by reading. 
 */
package pdc.part.pkg2;

import java.util.ArrayList;
import org.junit.*;

/**
 *
 * @author Elijah and John
 */
public class CombineListTest 
{
    private ArrayList<int[]> bookedSeatList;
    
    
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
    
    
    @Before
     public void setUpCombineList()
    {
        System.out.println("Before (CALLED): setUp");
        
        //Setting up variables
        ArrayList<int[]> userCurrentBookedSeatList = new ArrayList<int[]>();
        bookedSeatList = new ArrayList<int[]>();
        
        int[] userBookedServiceLine = {1,1};
        int[] testSeat1 = {1, 1, 1};
        int[] testSeat2 = {2, 5, 7};
        int[] testSeat3 = {2, 3, 0};
        
        userCurrentBookedSeatList.add(testSeat1);
        userCurrentBookedSeatList.add(testSeat2);
        userCurrentBookedSeatList.add(testSeat3);
        
        //Writing into testing.txt file
        for(int seatIndex = 0; seatIndex < userCurrentBookedSeatList.size(); seatIndex++)
        {
            int[] result = new int[5];
            
            for(int index = 0; index < userBookedServiceLine.length; index++)
            {
                result[index] = userBookedServiceLine[index];
            }
            
            result[2] = userCurrentBookedSeatList.get(seatIndex)[0];
            result[3] = userCurrentBookedSeatList.get(seatIndex)[1];
            result[4] = userCurrentBookedSeatList.get(seatIndex)[2];
            
            
            bookedSeatList.add(result);
        }
    }
     
    
    @Test
    public void readCombineList()
    {
        int expected = bookedSeatList.size();
        int counter = 0;
        for(int x = 0; x < bookedSeatList.size(); x++)
        {
            System.out.println(bookedSeatList.get(x)[0] + ", " + bookedSeatList.get(x)[1] + ", " + bookedSeatList.get(x)[2] + ", " + bookedSeatList.get(x)[3] + ", " + bookedSeatList.get(x)[4]);
            counter++;
        }
        Assert.assertEquals(expected, counter);
    }
}
