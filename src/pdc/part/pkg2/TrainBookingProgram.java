/*
 * Description: Main program file. Also the Controller file, referring to the MVC Pattern.
 * Includes the main method and functions that work on TrainDataModel (model class).
 */
package pdc.part.pkg2;

import java.io.*;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 1 = Alley, 2 = Polar
// 0,1,2,3 = TrainLine
// 1 = First, 2 = Economy
// x coord
// y coord

/**
 *
 * @author Elijah and Sanggy
 */
public class TrainBookingProgram 
{   
    protected static BufferedReader reader;
    protected static BufferedWriter writer;
    protected static String line = "";
    
    public static void trainService(MainFrame window)
    {
        window.getTrainData().getBookedSeatList().add(window.getTrainData().getUserBookedServiceLine());
        
        if(window.getTrainData().getChosenService() == window.getTrainData().getPolarExpressService())
        {
            window.getTrainData().getUserBookedServiceLine()[0] = 2;
            
        }
        else if(window.getTrainData().getChosenService() == window.getTrainData().getAlleyExpressService())
        {
            window.getTrainData().getUserBookedServiceLine()[0] = 1;
        }
    }
    
    //Read into .txt file and return it as an ArrayList<int[]>
    public static ArrayList<int[]> readBookedSeats()
    {
        ArrayList<int[]> output = new ArrayList<>();
        String rawString;
        int xIndex = 0;
        int yIndex = 0;
        
        try
        {
            reader = new BufferedReader(new FileReader("bookedSeats.txt"));

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
            }
        }
        catch (IOException ex)
        {
            System.err.println("ERROR: " + ex.getMessage());
        }
        
        return output;
    }
    
    //Write into .txt file
    public static void writeBookedSeats(MainFrame window)
    {
        ArrayList<int[]> bookedSeats = window.getBookedSeats();
        
        try
        {
            writer = new BufferedWriter(new FileWriter("bookedSeats.txt", false));
            
            for(int y = 0; y < bookedSeats.size(); y++)
            {
                for(int index = 0; index < 5; index++)
                {
                    writer.write(bookedSeats.get(y)[index] + " ");
                }
                
                writer.write("\n");
            }
            
            writer.close();
        }
        catch(IOException e)
        {
            System.err.println("ERROR: " + e.getMessage());
        }
        finally
        {
            System.out.println("Code has been recorded successfully!");
        }
        
    }
    
    //Set past booked seats to booked
    public static void setBookedSeats(TrainDataModel trainData)
    {
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
    }
    
    public static void main(String[] args)
    {
        TrainDataModel trainData = new TrainDataModel();

        //Setup train data
        trainData.setBookedSeatList(readBookedSeats());
        setBookedSeats(trainData);
        
        DBManager database = new DBManager();
        MainFrame window = new MainFrame(trainData);
    
        database.createTable();
        database.view("customer");
        database.view("bookings");
        window.setVisible(true);
        
        window.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
            {
                writeBookedSeats(window);
            }
        });
        
        
        
        database.closeConnection();
    }   
}
