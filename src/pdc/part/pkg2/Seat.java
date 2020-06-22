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
import java.awt.event.*;

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
    private int seatX;
    private int seatY;
    
    //Constructor
    public Seat()
    {
        super();
        
        this.seatPrice = 0.0;
        this.seatFeatures = null;
        this.seatTaken = false;
    }
    
    public Seat(double seatPrice, String[] seatFeatures, String seatName, int seatX, int seatY)
    {
        super(seatName);
        
        this.seatPrice = seatPrice;
        this.seatFeatures = seatFeatures;
        this.seatName = seatName;
        this.seatTaken = false;
        
        //ItemListener
        this.addItemListener(new ItemListener() 
        {
            @Override
            public void itemStateChanged(ItemEvent ev) 
            {
                if(ev.getStateChange()==ItemEvent.SELECTED)
                {
                    System.out.println("button is selected: " + seatX + ", " + seatY);
                    seatTaken = true;
                } 
                else if(ev.getStateChange()==ItemEvent.DESELECTED)
                {
                    System.out.println("button is not selected");
                    seatTaken = false;
                }
            }
        });
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
    
    //Used to book seat and disable this seat (button) from being booked
    public void bookSeat()
    {
        this.seatTaken = true;
        this.setEnabled(false);
    }
    
    public int getSeatX() {
        return seatX;
    }

    public void setSeatX(int seatX) {
        this.seatX = seatX;
    }

    public int getSeatY() {
        return seatY;
    }

    public void setSeatY(int seatY) {
        this.seatY = seatY;
    }
    
    //ToString
    
    @Override
    public String toString()
    {
        return "Seat Class: " + this.seatName + "\nFeatures: " + Arrays.toString(seatFeatures) + "\nPrice: " + this.getSeatPrice();
    }
}
