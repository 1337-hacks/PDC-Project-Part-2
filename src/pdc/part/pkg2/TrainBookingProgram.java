/*
 * --- DESCRIPTION ---
 * 
 * The main program file for the project. This sets up the MainFrame class variable
 * as well as the TrainDataModel class variable.
 * This class also saves the user's selected seats in the bookedSeats.txt file
 * and reads it.
 */
package pdc.part.pkg2;

import java.io.*;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Elijah 18023249 and John 18017056
 */
public class TrainBookingProgram 
{   
    protected static BufferedReader reader;
    protected static BufferedWriter writer;
    protected static String line = "";
    
    
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
    
    //Main Program
    public static void main(String[] args)
    {
        try
        {
            //Setup Connection
            DBManager database = new DBManager();
            
            if(database.isError())
            {
                throw new ConnectionException();
            }
            
            database.createTable();
            database.view("customer");
            database.view("bookings");
            
            //Setup train data
            TrainDataModel trainData = new TrainDataModel();
            
            trainData.setBookedSeatList(readBookedSeats());
            setBookedSeats(trainData);
            
            MainFrame window = new MainFrame(trainData);
            window.setVisible(true);
            
            window.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent e)
                {
                    writeBookedSeats(window);
                    database.closeConnection();
                }
            });
        }
        catch(ConnectionException e)
        {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }   
}
