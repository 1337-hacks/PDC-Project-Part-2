/*
 * --- DESCRIPTION ---
 *
 * A subclass of the Seat class. EconomyClass contains 
 * an array of String for seatFeatures as well as 
 * fixed variable of double for seat price(seatPrice) and 
 * a fixed string for seat name (seatName). 
 */
package pdc.part.pkg2;

/**
 *
 * @author Elijah 18023249 and John 18017056
 */
public class EconomyClass extends Seat
{
    //Variables
    private static final String[] seatFeatures = 
    {
        "Entertainment System", 
        "Food and Drink", 
    };
    
    private static final double seatPrice = 230.0;
    private static final String seatName = "Economy Class";

    
    //Constructor
    public EconomyClass(int seatX, int seatY)
    {
        super(seatPrice, seatFeatures, "EC", seatX, seatY);
    }

    
}
