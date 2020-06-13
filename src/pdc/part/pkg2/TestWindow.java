/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.part.pkg2;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;

/**
 *
 * @author Elijah N and John S
 */
public class TestWindow
{
    private JFrame testWindow;
    private String windowTitle;
    private JPanel seatGrid;
    
    
    //Constructor
    public TestWindow(String windowTitle, int jpanelNumber, int numberOfSeats)
    {
        this.testWindow = new JFrame("Seating");
        this.windowTitle = windowTitle;
        int columns = jpanelNumber;
        this.testWindow.setLayout(new BorderLayout());
        this.seatGrid = new StandardSeatGrid();
        
        testWindow.setTitle(this.windowTitle);
        testWindow.setSize(600, 450);
        
        testWindow.add(seatGrid, BorderLayout.CENTER);
        this.seatGrid.setVisible(true);
        testWindow.setVisible(true);
    }
}
