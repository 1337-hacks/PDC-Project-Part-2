/*
 * --- DESCRIPTION ---
 *
 * Custom exception, this is to detect if a seat is taken. 
 * It has integers in parameters to be able to display 
 * the position of the seat taken. 
 */

package pdc.part.pkg2;

/**
 *
 * @author Elijah 18023249 and John 18017056
 */

public class SeatTakenException extends Exception
{
    public SeatTakenException(int x, int y)
    {
        super("Seat [" + x + "][" + y + "] is already taken");
    }
}
