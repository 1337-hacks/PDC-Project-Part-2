/*
 * --- DESCRIPTION ---
 *
 * A class that creates a 2-dimensional array of seats (Seat class). This class
 * is able to display a graphical layout of the 2d array of seats and check if
 * the seats are full or not.
 */

package pdc.part.pkg2;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author Elijah 18023249 and John 18017056
 */

public class SeatGrid extends javax.swing.JPanel
{

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * @return the firstClassPanel
     */
    //Variables
    
    private int columnNumber;
    private int seatNumber;
    private int economyClassRows;
    private int firstClassRows;
    private EconomyClass [][] economyClass;
    private FirstClass [][] firstClass;
    private JPanel firstClassPanel;
    private JPanel economyClassPanel;
    private JPanel emptyPanel;
    private static int[] seat;
    private double price;
    
    
    //Constructors
    
    public SeatGrid()
    {
        super();
        
        this.seatNumber = 0;
        this.economyClassRows = 0;
        this.economyClass = new EconomyClass[0][0];
        this.firstClass = new FirstClass[0][0];
        this.firstClassRows = 0;
    }
    
    public SeatGrid(int aisleNumber, int seatNumber, int economyClassRows, int firstClassRows)
    {
        super();
        
        setLayout(new BorderLayout(10, 10));
        this.firstClassPanel = new JPanel(new GridLayout(firstClassRows, seatNumber));
        this.economyClassPanel = new JPanel(new GridLayout(economyClassRows, seatNumber));
        
        this.emptyPanel = new JPanel();
        this.emptyPanel.setSize(10, 10);
        
        add(firstClassPanel, BorderLayout.NORTH);
        add(economyClassPanel, BorderLayout.CENTER);
        
        this.columnNumber = aisleNumber;
        this.seatNumber = seatNumber;
        this.economyClassRows = economyClassRows;
        this.firstClassRows = firstClassRows;
        this.economyClass = new EconomyClass[seatNumber][economyClassRows];
        this.firstClass = new FirstClass[seatNumber][firstClassRows];
        
        this.firstClassPanel.setBorder(BorderFactory.createTitledBorder("First Class"));
        this.economyClassPanel.setBorder(BorderFactory.createTitledBorder("Economy Class"));
        
        //Economy Class instantiation
        for(int y = 0; y < economyClassRows; y++)
        {
            for(int x = 0; x < seatNumber; x++)
            {
                this.economyClass[x][y] = new EconomyClass(x, y);
            }
        }
        
        //First Class instantiation
        for(int y = 0; y < firstClassRows; y++)
        {
            for(int x = 0; x < seatNumber; x++)
            {
                this.firstClass[x][y] = new FirstClass(x, y);
            }
        }
        
        //Economy Class Swing Buttons Instantiation
        for(int y = 0; y < economyClassRows; y++)
        {
            for(int x = 0; x < seatNumber; x++)
            {
                for(int z = 0; z < aisleNumber; z++)
                {
                    if(this.economyClass[x][y].isSeatTaken() == true) //If seat is booked
                    {
                        this.economyClassPanel.add(this.economyClass[x][y]);
                        this.economyClass[x][y].setEnabled(false);
                    }
                    else //If seat is free
                    {
                        this.economyClassPanel.add(this.economyClass[x][y]);
                        price += this.getEconomyClass()[x][y].getSeatPrice();
                        
                    }
                    
                    x++;
                }
                this.economyClassPanel.add(new JPanel());
                x--;
            }
        }
        
        //First Class Swing Buttons Instantiation
        for(int y = 0; y < firstClassRows; y++)
        {
            for(int x = 0; x < seatNumber; x++)
            {
                for(int z = 0; z < aisleNumber; z++)
                {
                    if(this.firstClass[x][y].isSeatTaken() == true) //If seat is booked
                    {
                        this.firstClassPanel.add(this.firstClass[x][y]);
                        this.firstClass[x][y].setEnabled(false);
                    }
                    else //If seat is free
                    {
                        this.firstClassPanel.add(this.firstClass[x][y]);
                           price += this.getFirstClass()[x][y].getSeatPrice();
                    }
                    
                    x++;
                }
                this.firstClassPanel.add(new JPanel());
                x--;
            }
        }
        
    }
    
    
    //Methods

    //Get and Set Methods
    public int getSeatNumber() 
    {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) 
    {
        this.seatNumber = seatNumber;
    }
    
    public FirstClass[][] getFirstClass() 
    {
        return firstClass;
    }

    public void setFirstClass(FirstClass[][] firstClass) 
    {
        this.firstClass = firstClass;
    }
    
    public EconomyClass[][] getEconomyClass()
    {
        return economyClass;
    }

    public void setEconomyClass(EconomyClass[][] economyClass) 
    {
        this.economyClass = economyClass;
    }

    public int getEconomyClassRows() 
    {
        return economyClassRows;
    }

    public void setEconomyClassRows(int economyClassRows) 
    {
        this.economyClassRows = economyClassRows;
    }

    public int getFirstClassRows() 
    {
        return firstClassRows;
    }

    public void setFirstClassRows(int firstClassRows) 
    {
        this.firstClassRows = firstClassRows;
    }
    
    public int getColumnNumber() 
    {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) 
    {
        this.columnNumber = columnNumber;
    }
    
    
    public ArrayList<int[]> returnUserSelectedSeats()
    {
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int y = 0; y < firstClassRows; y++) //First Class
        {
            for(int x = 0; x < seatNumber; x++)
            {   
                if(this.firstClass[x][y].isSeatTaken() == true && this.firstClass[x][y].isEnabled() == true)
                {
                    seat = new int[3];
                    seat[0] = 1;
                    seat[1] = x;
                    seat[2] = y;
                    list.add(seat);
                }
            }
            
            System.out.println("");
        }
        
        for(int y = 0; y < economyClassRows; y++) //Economy Class
        {
            for(int x = 0; x < seatNumber; x++)
            {
                if(this.economyClass[x][y].isSeatTaken() == true && this.economyClass[x][y].isEnabled() == true)
                {
                    seat = new int[3];
                    seat[0] = 2;
                    seat[1] = x;
                    seat[2] = y;
                    list.add(seat);
                }
            }
        }
        
        return list;
    }
    
    //Check if first class seating is full
    public boolean isFirstClassFull()
    {
        for(int y = 0; y < this.firstClassRows; y++)
        {
            for(int x = 0; x < this.seatNumber; x++)
            {
                if(this.firstClass[x][y].isSeatTaken() == false)
                {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
    //Check if economy class seating is full
    public boolean isEconomyClassFull()
    {
        for(int y = 0; y < this.economyClassRows; y++)
        {
            for(int x = 0; x < this.seatNumber; x++)
            {
                if(this.economyClass[x][y].isSeatTaken() == false)
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}
