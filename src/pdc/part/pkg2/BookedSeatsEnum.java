/*
 * --- DESCRIPTION ---
 *
 * An Enum class. This is used in the 
 * main file (TrainBookingProgram) in the setBookedSeats method. The
 * enums are used to identify the seats which have been previously
 * booked before.
 */

package pdc.part.pkg2;

/**
 *
 * @author Elijah 18023249 and John 18017056
 */

public enum BookedSeatsEnum 
{
    TRAINSERVICE(0), TRAINLINE(1), TRAINCLASS(2), XCOORD(3), YCOORD(4);
    
    private int value;
    
    private BookedSeatsEnum(int value)
    {
        this.value = value;
    }
}
