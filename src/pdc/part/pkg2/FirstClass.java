/*
 * --- DESCRIPTION ---
 *
 * A subclass of the Seat class which is similar to EconomyClass. 
 * FirstClass contains an array of String for seatFeatures as well as 
 * fixed variable of double for seat price(seatPrice) and 
 * a fixed string for seat name (seatName). 
 */

package pdc.part.pkg2;

/**
 *
 * @author Elijah 18023249 and John 18017056
 */

public class FirstClass extends Seat 
{
    //Variables
    private static final String[] seatFeatures = 
    {
        "Entertainment System", 
        "Food and Drink", 
        "Alcoholic Beverages", 
        "Bed"
    };
    
    private static final double seatPrice = 500.0;
    private static final String seatName = "First Class";
    
    
    //Constructor
    public FirstClass()
    {
        super(seatPrice, seatFeatures, seatName);
    }

}
