/*
 * --- DESCRIPTION ---
 *
 * Class to describe a train service. The train service includes a list (ArrayList) of
 * train lines (TrainLine class) as well as the name of the service. All necessary get and set
 * methods are available as well as displaying the details of the train service.
 */

package pdc.part.pkg2;

/**
 *
 * @author Elijah 18023249 and John 18017056
 */

public class TrainService 
{
    //Variables
    private String serviceName;
    private TrainLine[] trainLine;
    
    //Constructors
    public TrainService()
    {
        this.serviceName = "Unavailable";
        this.trainLine = null;
    }
    
    public TrainService(String serviceName, TrainLine[] trainLine)
    {
        this.serviceName = serviceName;
        this.trainLine = trainLine;
    }
    
    //Methods
    
    //Displays the train service name and their available lines
    public void displayDetails()
    {
        System.out.println("===== " + this.getServiceName() + " =====\n");
        
        for (int index = 1; index <= this.getTrainLine().length; index++)
        {
            System.out.println(index + ". " + this.getTrainLine()[index - 1]);
        }
        
    }
    
    
    //Get and Set Methods
    
    public TrainLine[] getTrainLine() 
    {
        return trainLine;
    }

    public void setTrainLine(TrainLine[] trainLine) 
    {
        this.trainLine = trainLine;
    }
    
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    
    
    //ToString Method
    
    @Override
    public String toString()
    {
        return this.getServiceName();
    }

    
}
