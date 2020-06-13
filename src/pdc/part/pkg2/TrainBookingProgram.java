/*
 * Description: Main program file. Also the Controller file, referring to the MVC Pattern.
 * Includes the main method and functions that work on TrainDataModel (model class).
 */
package pdc.part.pkg2;


/**
 *
 * @author Elijah and Sanggy
 */
public class TrainBookingProgram 
{
    public static void trainService(MainWindow window)
    {
        if(window.getTrainData().getChosenService() == window.getTrainData().getPolarExpressService())
        {
            System.out.println("Booked Polar Express");
        }
        else if(window.getTrainData().getChosenService() == window.getTrainData().getAlleyExpressService())
        {
            System.out.println("Booked Alley Express");
        }
    }
    
    public static void main(String[] args)
    {
        DBManager database = new DBManager();
        MainWindow window = new MainWindow();
    
       database.createTable();
        
        database.view("customer");
        database.view("bookings");
        window.setVisible(true);
        
        TestWindow test = new TestWindow("Seat Booking", 3, 30);
        
        window.getTrainData().getAlleyExpressService().getTrainLine()[0].getSeatGrid().displayGrid();
        
        window.getTrainData().getPolarExpressService().getTrainLine()[0].getSeatGrid().displayGrid();
        
        /*if(true)
        {
            //database.closeConnection();
        }*/
    }    
}
