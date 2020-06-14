/*
 * Description: Main program file. Also the Controller file, referring to the MVC Pattern.
 * Includes the main method and functions that work on TrainDataModel (model class).
 */
package pdc.part.pkg2;

// 1 = Alley, 2 = Polar
// 0,1,2,3 = TrainLine
// 1 = First, 2 = Economy
// x coord
// y coord

/**
 *
 * @author Elijah and Sanggy
 */
public class TrainBookingProgram 
{
    public static void trainService(MainFrame window)
    {
        window.getTrainData().getBookedSeatList().add(window.getTrainData().getUserBookedServiceLine());
        
        if(window.getTrainData().getChosenService() == window.getTrainData().getPolarExpressService())
        {
            window.getTrainData().getUserBookedServiceLine()[0] = 2;
            
        }
        else if(window.getTrainData().getChosenService() == window.getTrainData().getAlleyExpressService())
        {
            window.getTrainData().getUserBookedServiceLine()[0] = 1;
        }
    }
    
    public static void bookedSeats(MainFrame window)
    {
        
    }
    
    public static void main(String[] args)
    {
        DBManager database = new DBManager();
        MainFrame window = new MainFrame();
    
        database.createTable();
        
        database.view("customer");
        database.view("bookings");
        window.setVisible(true);
        
        database.closeConnection();
    }    
}
