/*
 * --- DESCRIPTION ---
 *
 * This class describes Seat. The Seat contains default constructor 
 * and it has a parameterized constructor. It has variables that describes 
 * a seat such as price (seatPrice), features(seatFeatures), seat (seatName) 
 * and if a seat is booked (seatTaken). All necessary, get and set methods
 * as well as toString to display details of the seat.
 */

package pdc.part.pkg2;

import java.util.Arrays;
import javax.swing.*;

/**
 *
 * @author Elijah 18023249 and John 18017056
 */

public class Seat extends JToggleButton
{
    //Variables
    private double seatPrice;
    private String[] seatFeatures;
    private String seatName;
    private boolean seatTaken;
    
    //Constructor
    public Seat()
    {
        super();
        
        this.seatPrice = 0.0;
        this.seatFeatures = null;
        this.seatTaken = false;
    }
    
    public Seat(double seatPrice, String[] seatFeatures, String seatName)
    {
        super(seatName);
        
        this.seatPrice = seatPrice;
        this.seatFeatures = seatFeatures;
        this.seatName = seatName;
        this.seatTaken = false;
    }
    
    //Methods

    /**
     * @return the seatPrice
     */
    public double getSeatPrice() 
    {
        return this.seatPrice;
    }

    /**
     * @param seatPrice the seatPrice to set
     */
    public void setSeatPrice(double seatPrice) 
    {
        this.seatPrice = seatPrice;
    }

    public String[] getSeatFeatures() 
    {
        return seatFeatures;
    }

    public void setSeatFeatures(String[] seatFeatures) 
    {
        this.seatFeatures = seatFeatures;
    }
    
    public String getSeatName() 
    {
        return seatName;
    }

    public void setSeatName(String seatName) 
    {
        this.seatName = seatName;
    }
    
    public boolean isSeatTaken() 
    {
        return seatTaken;
    }

    public void setSeatTaken(boolean seatTaken) 
    {
        this.seatTaken = seatTaken;
    }
    
    //ToString
    
    @Override
    public String toString()
    {
        return "Seat Class: " + this.seatName + "\nFeatures: " + Arrays.toString(seatFeatures) + "\nPrice: " + this.getSeatPrice();
    }
}
