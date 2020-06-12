/*
 * --- DESCRIPTION ---
 * 
 * Class to describe a single train line. Includes the necessary
 * variables to fully describe a train line including the seating grid
 * of the train itself.
 */

package pdc.part.pkg2;

/**
 *
 * @author Elijah 18023249 and John 18017056
 */

public class TrainLine 
{
    //Variables
    private String start;
    private String finish;
    private double duration;
    private String trainOperator;
    private SeatGrid seatGrid;
    
    //Constructors
    public TrainLine()
    {
        
        this.start = "";
        this.finish = "";
        this.duration = 0.0;
        this.trainOperator = "";
        this.seatGrid = new SeatGrid();
    }
    
    public TrainLine(String start, String finish, double duration, String trainOperator, SeatGrid seatGrid)
    {
        this.start = start;
        this.finish = finish;
        this.duration = duration;
        this.trainOperator = trainOperator;
        this.seatGrid = seatGrid;
        
    }
    
    //Methods

    //Get and Set Methods
    
    public String getStart() 
    {
        return start;
    }

    public void setStart(String start) 
    {
        this.start = start;
    }

    
    public String getFinish() 
    {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) 
    {
        this.duration = duration;
    }

    public String getTrainOperator() 
    {
        return trainOperator;
    }

    public void setTrainOperator(String trainOperator) 
    {
        this.trainOperator = trainOperator;
    }
    
    public SeatGrid getSeatGrid() 
    {
        return seatGrid;
    }

    public void setSeatGrid(SeatGrid seatGrid) 
    {
        this.seatGrid = seatGrid;
    }
    
    //Display details of this particular train line
    @Override
    public String toString()
    {
        return "Line " +this.start + " to " + this.finish ;
    }  
}
