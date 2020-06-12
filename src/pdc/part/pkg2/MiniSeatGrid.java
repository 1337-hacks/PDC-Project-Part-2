/*
 * --- DESCRIPTION ---
 * 
 * A subclass of the SeatGrid class. This seating grid layout is used by the
 * Alley Express train service (AlleyExpressService class) in their trains
 * (TrainLine class). 
 */
package pdc.part.pkg2;

/**
 *
 * @author Elijah 18023249 and John 18017056
 */
public class MiniSeatGrid extends SeatGrid 
{
    //Variables
    private static final int aisleNumber = 2;
    private static final int seatNumber = 8;
    private static final int economyClassRows = 10;
    private static final int firstClassRows = 3;
    
    //Constructor
    public MiniSeatGrid()
    {
        super(aisleNumber, seatNumber, economyClassRows, firstClassRows);
    }
    
}
