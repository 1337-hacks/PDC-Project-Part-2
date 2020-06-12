/*
 * --- DESCRIPTION ---
 * 
 * A subclass of TrainService. AlleyExpressService includes 
 * an array of Strings (operator name). Additionally, it includes 
 * an array of TrainLine (alleyTrainLine) which contains 4 destination. 
 * Each operator is assigned to their respective trainline.
 */

package pdc.part.pkg2;

/**
 *
 * @author Elijah 18023249 and John 18017056
 */

public class AlleyExpressService extends TrainService
{
    //Variables
    
    //Train Operator Names   
    private static final String[] trainOperator = new String[]
    {
        "Ramos",
        "Isaiah",
        "Rosette",
        "Abraham"
    };
            
    //Train Lines
    private static final TrainLine[] alleyTrainLine = new TrainLine[]
    {
        new TrainLine("Auckland", "Wellington", 7.23, trainOperator[0], new MiniSeatGrid()),
        new TrainLine("Wellington", "Auckland", 9.14, trainOperator[1], new MiniSeatGrid()),
        new TrainLine("Hamilton", "Cape Reinga", 10.0, trainOperator[2], new MiniSeatGrid()),
        new TrainLine("Cape Reinga", "Hamilton", 12.1, trainOperator[3], new MiniSeatGrid())
    };
    
    
    //Constructor
    public AlleyExpressService()
    {
        super("Alley Express", alleyTrainLine);
    }
}
