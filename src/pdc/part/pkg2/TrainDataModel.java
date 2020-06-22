/*
 * Description: Model Class, refers to the MVC Pattern.
 * Stores all the necessary data for the train model.
 */
package pdc.part.pkg2;

import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author elija
 */
public class TrainDataModel 
{
    //Variables
    
    private TrainService alleyExpressService = new AlleyExpressService(); //Alley Express
    private TrainService polarExpressService = new PolarExpressService(); //Polar Express
    private TrainService chosenService;
    private TrainLine chosenLine;
    private static int[] userBookedServiceLine;
    private static int[] result;
    private ArrayList<int[]> userCurrentBookedSeatList = new ArrayList<int[]>(); // stores user's current booked seats
    private ArrayList<int[]> bookedSeatList = new ArrayList<int[]>();            // the official booked seat list. Stores all booked seat information here.
    private int totalPrice;
    private String[] seatsArray;
    
    private String alleyExpressTrainLines[] = {    //Alley Express Train Lines
                                                    alleyExpressService.getTrainLine()[0].toString(),
                                                    alleyExpressService.getTrainLine()[1].toString(),
                                                    alleyExpressService.getTrainLine()[2].toString(),
                                                    alleyExpressService.getTrainLine()[3].toString(),
                                               };
    
    private String polarExpressTrainLines[] = {    //Polar Express Train Lines
                                                    polarExpressService.getTrainLine()[0].toString(),
                                                    polarExpressService.getTrainLine()[1].toString(),
                                                    polarExpressService.getTrainLine()[2].toString(),
                                                    polarExpressService.getTrainLine()[3].toString(),
                                               };
    
    //Constructor
    
    public TrainDataModel()
    {
        userBookedServiceLine = new int[2];
        System.out.println("Train Data Model created");
        this.totalPrice = 0;
    }
    
    //Functions

    public void combineLists()
    {
        
        this.seatsArray = new String[userCurrentBookedSeatList.size()];
        for(int seatIndex = 0; seatIndex < userCurrentBookedSeatList.size(); seatIndex++)
        {
            result = new int[5];
            
            for(int index = 0; index < userBookedServiceLine.length; index++)
            {
                result[index] = userBookedServiceLine[index];
            }
            
            result[2] = userCurrentBookedSeatList.get(seatIndex)[0];
            result[3] = userCurrentBookedSeatList.get(seatIndex)[1];
            result[4] = userCurrentBookedSeatList.get(seatIndex)[2];
            
            if(result[2] == 1)
            {
                totalPrice += chosenLine.getSeatGrid().getFirstClass()[result[3]][result[4]].getSeatPrice();
                seatsArray[seatIndex] = "First Class Seats [" + String.valueOf(result[3]) + "," + String.valueOf(result[4]) + "]";
            }
            if(result[2] == 2)
            {
                totalPrice += chosenLine.getSeatGrid().getEconomyClass()[result[3]][result[4]].getSeatPrice();
                seatsArray[seatIndex] = "Economy Class Seats [" + String.valueOf(result[3]) + "," + String.valueOf(result[4]) + "]";
            }
            
            bookedSeatList.add(result);
        }
        
        for(int x = 0; x < bookedSeatList.size(); x++)
        {
            System.out.println(bookedSeatList.get(x)[0] + ", " + bookedSeatList.get(x)[1] + ", " + bookedSeatList.get(x)[2] + ", " + bookedSeatList.get(x)[3] + ", " + bookedSeatList.get(x)[4]);
        }
        
        
    }
    
    
    
    //Getters and Setters
    
    public int getTotalPrice()
    {
        return this.totalPrice;
    }
    
    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    
    public TrainService getAlleyExpressService() 
    {
        return alleyExpressService;
    }

    public void setAlleyExpressService(TrainService aTrainService1) 
    {
        alleyExpressService = aTrainService1;
    }

    public TrainService getPolarExpressService() 
    {
        return polarExpressService;
    }

    public void setPolarExpressService(TrainService aTrainService2) 
    {
        polarExpressService = aTrainService2;
    }

    public TrainService getChosenService() 
    {
        return chosenService;
    }

    public void setChosenService(TrainService chosenService) 
    {
        this.chosenService = chosenService;
    }

    public TrainLine getChosenLine() 
    {
        return chosenLine;
    }

    public void setChosenLine(TrainLine chosenLine) 
    {
        this.chosenLine = chosenLine;
    }

    public String[] getAlleyExpressTrainLines() {
        return alleyExpressTrainLines;
    }

    public void setAlleyExpressTrainLines(String[] alleyExpressTrainLines) {
        this.alleyExpressTrainLines = alleyExpressTrainLines;
    }

    public String[] getPolarExpressTrainLines() {
        return polarExpressTrainLines;
    }

    public void setPolarExpressTrainLines(String[] polarExpressTrainLines) {
        this.polarExpressTrainLines = polarExpressTrainLines;
    }
    
    public ArrayList<int[]> getBookedSeatList() {
        return bookedSeatList;
    }
    
    public void setBookedSeatList(ArrayList<int[]> bookedSeatList) {
        this.bookedSeatList = bookedSeatList;
    }
    
    public int[] getUserBookedServiceLine() {
        return userBookedServiceLine;
    }
    
    public void setUserBookedServiceLine(int[] userBookedServiceLine) {
        this.userBookedServiceLine = userBookedServiceLine;
    }
    
    public ArrayList<int[]> getUserCurrentBookedSeatList() {
        return userCurrentBookedSeatList;
    }
    
    public void setUserCurrentBookedSeatList(ArrayList<int[]> userCurrentBookedSeatList) {
        this.userCurrentBookedSeatList = userCurrentBookedSeatList;
    }

    /**
     * @return the seatsArray
     */
    public String[] getSeatsArray() {
        return seatsArray;
    }

    /**
     * @param seatsArray the seatsArray to set
     */
    public void setSeatsArray(String[] seatsArray) {
        this.seatsArray = seatsArray;
    }
}
