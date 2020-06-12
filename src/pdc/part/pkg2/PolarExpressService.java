/*
 * --- DESCRIPTION ---
 * 
 * A subclass of TrainService. Similar to AlleyExpressService subclass,
 * PolarExpressService initializes the necessary variables to describe
 * its available train lines and train operators.
 */

package pdc.part.pkg2;

/**
 *
 * @author Elijah 18023249 and John 18017056
 */

public class PolarExpressService extends TrainService 
{
    //Variables
    
    //Train Operator Names   
    private static final String[] trainOperator = new String[]
    {
        "Steffan",
        "Claus",
        "Samwise",
        "Renzo"
    };
        
    //Train Lines
    private static final TrainLine[] polarTrainLine = new TrainLine[]
    {
        new TrainLine("Christchurch", "Bluff", 7.34, trainOperator[0], new StandardSeatGrid()),
        new TrainLine("Bluff", "Christchurch", 8.7, trainOperator[1], new StandardSeatGrid()),
        new TrainLine("Queenstown", "Kaikoura", 10.6, trainOperator[2], new StandardSeatGrid()),
        new TrainLine("Kaikoura", "Queenstown", 11.3, trainOperator[3], new StandardSeatGrid())
    };
    
    
    
    //Constructor
    public PolarExpressService()
    {
        super("Polar Express", polarTrainLine);
    }

}
