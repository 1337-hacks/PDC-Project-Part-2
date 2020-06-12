/*
 * Description: Model Class, refers to the MVC Pattern.
 * Stores all the necessary data for the train model.
 */
package pdc.part.pkg2;

/**
 *
 * @author elija
 */
public class TrainDataModel 
{
    //Variables
    
    private TrainService alleyExpressService = new AlleyExpressService(); //Alley Express
    private TrainService polarExpressService = new PolarExpressService(); //Polar Express
    private TrainService chosenService;
    private TrainLine chosenLine;
    
    private String alleyExpressTrainLines[] = {    //Alley Express Train Lines
                                                    alleyExpressService.getTrainLine()[0].toString(),
                                                    alleyExpressService.getTrainLine()[1].toString(),
                                                    alleyExpressService.getTrainLine()[2].toString(),
                                                    alleyExpressService.getTrainLine()[3].toString(),
                                               };
    
    private String polarExpressTrainLines[] = {    //Polar Express Train Lines
                                                    polarExpressService.getTrainLine()[0].toString(),
                                                    polarExpressService.getTrainLine()[1].toString(),
                                                    polarExpressService.getTrainLine()[2].toString(),
                                                    polarExpressService.getTrainLine()[3].toString(),
                                               };
    
    //Constructor
    
    public TrainDataModel()
    {
        System.out.println("Train Data Model created");
    }
    
    //Functions

    //Getters and Setters
    public TrainService getAlleyExpressService() 
    {
        return alleyExpressService;
    }

    public void setAlleyExpressService(TrainService aTrainService1) 
    {
        alleyExpressService = aTrainService1;
    }

    public TrainService getPolarExpressService() 
    {
        return polarExpressService;
    }

    public void setPolarExpressService(TrainService aTrainService2) 
    {
        polarExpressService = aTrainService2;
    }

    public TrainService getChosenService() 
    {
        return chosenService;
    }

    public void setChosenService(TrainService chosenService) 
    {
        this.chosenService = chosenService;
    }

    public TrainLine getChosenLine() 
    {
        return chosenLine;
    }

    public void setChosenLine(TrainLine chosenLine) 
    {
        this.chosenLine = chosenLine;
    }

    public String[] getAlleyExpressTrainLines() {
        return alleyExpressTrainLines;
    }

    public void setAlleyExpressTrainLines(String[] alleyExpressTrainLines) {
        this.alleyExpressTrainLines = alleyExpressTrainLines;
    }

    public String[] getPolarExpressTrainLines() {
        return polarExpressTrainLines;
    }

    public void setPolarExpressTrainLines(String[] polarExpressTrainLines) {
        this.polarExpressTrainLines = polarExpressTrainLines;
    }
}
