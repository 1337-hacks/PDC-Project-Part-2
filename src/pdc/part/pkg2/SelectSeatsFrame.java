/*
 * --- DESCRIPTION ---
 * 
 * Frame used for displaying and booking the user's desired seats.
 * This also saves the user's desired seats into the TrainDataModel.
 */
package pdc.part.pkg2;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;

/**
 *
 * @author Elijah 18023249 and John 18017056
 */
public class SelectSeatsFrame
{
    //Variables
    private JFrame selectSeatsFrame;
    private String windowTitle;
    private SeatGrid seatGridPanel;
    private JPanel buttonPanel;
    private JLabel header;
    private JLabel selectSeatsDescriptionLabel;
    private ArrayList<int[]> selectedSeats;
    private TrainDataModel trainDataHolder;
    
    //Constructor
    public SelectSeatsFrame(TrainDataModel trainDataHolder)
    {
        this.trainDataHolder = trainDataHolder;
        this.selectSeatsFrame = new JFrame("Seating");
        this.windowTitle = "NZT Train Booking - Select Seats";
        this.selectSeatsFrame.setLayout(new BorderLayout(10, 10));
        this.selectedSeats = new ArrayList<int[]>();
        
        
        initComponents(this.trainDataHolder.getChosenLine());
        
        this.selectSeatsFrame.setLocationRelativeTo(null);
        this.selectSeatsFrame.setTitle(this.windowTitle);
        this.selectSeatsFrame.setSize(650, 500);
        this.selectSeatsFrame.setVisible(true);
    }
    
    private void initComponents(TrainLine chosenLine)
    {
        this.seatGridPanel = chosenLine.getSeatGrid();
        
        this.header = new JLabel("Select seats");
        this.header.setFont(new Font("Dialog", Font.BOLD, 24));
        
        this.selectSeatsDescriptionLabel = new JLabel("FC = First Class, and EC = Economy Class.");
        
        this.buttonPanel = new JPanel();
        this.buttonPanel.setLayout(new BorderLayout(5, 5));
        this.buttonPanel.add(this.selectSeatsDescriptionLabel, BorderLayout.CENTER);
        
        
        this.seatGridPanel.setVisible(true);
        
        this.selectSeatsFrame.add(this.seatGridPanel, BorderLayout.CENTER);
        this.selectSeatsFrame.add(this.header, BorderLayout.NORTH);
        this.selectSeatsFrame.add(this.buttonPanel, BorderLayout.SOUTH);
    }
    
    public TrainDataModel confirmSeats(TrainDataModel trainModel)
    {
        
        this.selectedSeats = this.seatGridPanel.returnUserSelectedSeats();
        
        trainModel.setUserCurrentBookedSeatList(selectedSeats);
        
        trainModel.combineLists();
        
        return trainModel;
    }
    
    public void closeFrame()
    {
        this.selectSeatsFrame.dispose();
    }
}
