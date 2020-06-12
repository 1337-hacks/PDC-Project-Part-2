/*
 * --- DESCRIPTION ---
 * 
 * The seating grid which the Polar Express train service (PolarExpressService subclass) uses
 * in their trains (AlleyTrainLine). All the variables have been initialized to create the right
 * seating grid layout.
 */

package pdc.part.pkg2;

/**
 *
 * @author Elijah 18023249 and John 18017056
 */

public class StandardSeatGrid extends SeatGrid
{
    //Variables
    private static final int aisleNumber = 3;
    private static final int seatNumber = 9;
    private static final int economyClassRows = 10;
    private static final int firstClassRows = 3;

    //Constructor
    public StandardSeatGrid()
    {
        super(aisleNumber, seatNumber, economyClassRows, firstClassRows);
    }
    
}
