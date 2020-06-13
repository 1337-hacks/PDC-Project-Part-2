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

/**
 *
 * @author Elijah 18023249 and John 18017056
 */

public class SeatGrid extends javax.swing.JPanel
{
    //Variables
    
    private int columnNumber;
    private int seatNumber;
    private int economyClassRows;
    private int firstClassRows;
    private EconomyClass [][] economyClass;
    private FirstClass [][] firstClass;
    private JPanel firstClassPanel;
    private JPanel economyClassPanel;
    
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
        
        setLayout(new BorderLayout());
        JPanel firstClassPanel = new JPanel(new GridLayout(firstClassRows, seatNumber));
        JPanel economyClassPanel = new JPanel(new GridLayout(economyClassRows, seatNumber));
        
        add(firstClassPanel, BorderLayout.NORTH);
        add(economyClassPanel, BorderLayout.CENTER);
        
        this.columnNumber = aisleNumber;
        this.seatNumber = seatNumber;
        this.economyClassRows = economyClassRows;
        this.firstClassRows = firstClassRows;
        this.economyClass = new EconomyClass[seatNumber][economyClassRows];
        this.firstClass = new FirstClass[seatNumber][firstClassRows];
        
        
        //Economy Class instantiation
        for(int y = 0; y < economyClassRows; y++)
        {
            for(int x = 0; x < seatNumber; x++)
            {
                this.economyClass[x][y] = new EconomyClass();
            }
        }
        
        //First Class instantiation
        for(int y = 0; y < firstClassRows; y++)
        {
            for(int x = 0; x < seatNumber; x++)
            {
                this.firstClass[x][y] = new FirstClass();
            }
        }
        
        //Economy Class Swing Buttons Instantiation
        for(int y = 0; y < economyClassRows; y++)
        {
            for(int x = 0; x < seatNumber; x++)
            {
                economyClassPanel.add(this.economyClass[x][y]);
            }
        }
        
        //First Class Swing Buttons Instantiation
        for(int y = 0; y < firstClassRows; y++)
        {
            for(int x = 0; x < seatNumber; x++)
            {
                firstClassPanel.add(this.firstClass[x][y]);
            }
        }
        
        this.setBackground(Color.red);
        this.setSize(100, 100);
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
    
    //Display the seating grid layout
    public void displayGrid()
    {
        System.out.println("=== Seat Grid ===\n");
        
        //Print Out First Class Rows
        for(int y = 0; y < this.firstClassRows; y++)
        {
            for(int x = 0; x < this.seatNumber; x++)
            {                
                for(int z = 0; z < this.columnNumber; z++)
                {
                    System.out.print("[");

                    if(this.firstClass[x][y].isSeatTaken() == true)
                    {
                        System.out.print("X");
                    }
                    else
                    {
                        System.out.print(" ");
                    }

                    System.out.print("]");
                    
                    x++;
                }
                 
                System.out.print("  ");
                x--;
            }
            
            System.out.println("");
        }
        
        
        System.out.println("");
        
        //Print Out Economy Class Rows
        for(int y = 0; y < this.economyClassRows; y++)
        {
            for(int x = 0; x < this.seatNumber; x++)
            {                
                for(int z = 0; z < this.columnNumber; z++)
                {
                    System.out.print("[");

                    if(this.economyClass[x][y].isSeatTaken() == true)
                    {
                        System.out.print("X");
                    }
                    else
                    {
                        System.out.print(" ");
                    }

                    System.out.print("]");
                    
                    x++;
                }
                 
                System.out.print("  ");
                x--;
            }
            System.out.println("");
        }
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
