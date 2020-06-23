/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc.part.pkg2;

import static com.sun.org.apache.xalan.internal.lib.NodeInfo.lineNumber;
import org.junit.*;

/**
 *
 * @author Admin
 */
public class TrainDataModelTest {
    
     @BeforeClass
    public static void setUpClass()
    {
        System.out.println("Beforeclass (CALLED): setUpClass");
    }
    
    @AfterClass
    public static void tearDownClass() 
    {
        System.out.println("Afterclass (CALLED): tearDownClass");
    }
    
    @Test
    public void readList()
    {
        TrainDataModel instance = new TrainDataModel();
        
        int expected = instance.getBookedSeatList().size();
        int counter = 0;
         for(int x = 0; x < instance.getBookedSeatList().size(); x++)
        {
            System.out.println(instance.getBookedSeatList().get(x)[0] + ", " + instance.getBookedSeatList().get(x)[1] + ", " + instance.getBookedSeatList().get(x)[2] + ", " + instance.getBookedSeatList().get(x)[3] + ", " + instance.getBookedSeatList().get(x)[4]);
            counter++;
        }
        Assert.assertEquals(expected, counter);
    }
    
    
    
}
