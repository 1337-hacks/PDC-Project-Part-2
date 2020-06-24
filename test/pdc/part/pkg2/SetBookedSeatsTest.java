/*
 * --- DESCRIPTION ---
 * 
 * Tests the setBookedSeats method under TrainBookingProgram (the main program file).
 * In this test it sets a certain seat booked in TrainDataModel and the test passes 
 * if this certain seat is booked or not.
 */

package pdc.part.pkg2;

import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 *
 * @author Elijah and John
 */

public class SetBookedSeatsTest 
{
    //Variables
    private ArrayList<int[]> testList = new ArrayList<int[]>();
    private int[] testSeatList = {1, 2, 2, 4, 5}; //Seat is hard coded here.
    private TrainDataModel trainData = new TrainDataModel();
    
    
    //Methods (Before, Test and After)
    //Initialising variables
    @Before
    public void setup()
    {
        System.out.println("Setup test:");
        testList.add(testSeatList);
        trainData.setBookedSeatList(testList);
        
        trainData.setChosenService(trainData.getAlleyExpressService());
        
        trainData.setChosenLine(trainData.getAlleyExpressService().getTrainLine()[2]);
        
        //Print out values of bookedSeatList ArrayList under the TrainDataModel class variable trainData
        System.out.println("");
        for(int index = 0; index < trainData.getBookedSeatList().get(0).length; index++)
        {
            System.out.print(trainData.getBookedSeatList().get(0)[index] + " ");
        }
        System.out.println("");
        System.out.println("Setup test complete.");
    }
    
    //Testing if the seat is taken
    @Test
    public void testSeats()
    {
        boolean testBool;
        
        //===TESTING METHOD BEGIN===//
        for(int index = 0; index < trainData.getBookedSeatList().size(); index++)
        {
            int trainServiceNum = BookedSeatsEnum.TRAINSERVICE.ordinal();
            int trainLine = BookedSeatsEnum.TRAINLINE.ordinal();
            int trainClass = BookedSeatsEnum.TRAINCLASS.ordinal();
            int xCoord = BookedSeatsEnum.XCOORD.ordinal();
            int yCoord = BookedSeatsEnum.YCOORD.ordinal();
            
            ArrayList<int[]> bookedSeats = trainData.getBookedSeatList();
            
            //bookedSeatsEnum identifier;
            
            if(trainData.getBookedSeatList().get(index)[trainServiceNum] == 1) //Alley Express
            {
                if(bookedSeats.get(index)[trainClass] == 1) //First Class
                {
                    trainData.getAlleyExpressService().getTrainLine()[bookedSeats.get(index)[trainLine]].getSeatGrid().getFirstClass()[bookedSeats.get(index)[xCoord]][bookedSeats.get(index)[yCoord]].bookSeat();
                }
                else if(bookedSeats.get(index)[trainClass] == 2) //Economy Class
                {
                    trainData.getAlleyExpressService().getTrainLine()[bookedSeats.get(index)[trainLine]].getSeatGrid().getEconomyClass()[bookedSeats.get(index)[xCoord]][bookedSeats.get(index)[yCoord]].bookSeat();
                }
            }
            else if(bookedSeats.get(index)[trainServiceNum] == 2) //Polar Express
            {
                if(bookedSeats.get(index)[trainClass] == 1) //First Class
                {
                    trainData.getPolarExpressService().getTrainLine()[bookedSeats.get(index)[trainLine]].getSeatGrid().getFirstClass()[bookedSeats.get(index)[xCoord]][bookedSeats.get(index)[yCoord]].bookSeat();
                }
                else if(bookedSeats.get(index)[trainClass] == 2) //Economy Class
                {
                    trainData.getPolarExpressService().getTrainLine()[bookedSeats.get(index)[trainLine]].getSeatGrid().getEconomyClass()[bookedSeats.get(index)[xCoord]][bookedSeats.get(index)[yCoord]].bookSeat();
                }
            }
        }
        //===TESTING METHOD END===//
        
        //Check if seat was booked
        if(trainData.getChosenLine().getSeatGrid().getEconomyClass()[4][5].isSeatTaken() == true)
        {
            testBool = true;
            System.out.println("Test Passed!");
            Assert.assertEquals(true, testBool);
        }
        else // if condition is not met, then test will fail 
        {
            System.out.println("Test Failed. Seat was either not booked properly or seat was not found.");
            Assert.fail();
        }
    }
    
    @After
    public void postMethod()
    {
        System.out.println("Test Complete");
    }
}
