/**
 * @author (Tom) 
 * @version (1.0)
 */
public class Main
{
    public static void main(String [] args)
    {
        TaxiCo tc = new TaxiCo("Tom's Cars");
        tc.addTaxi();
        tc.addTaxi();
        tc.addTaxi();
        tc.addTaxi();
        tc.addShuttle();
        tc.showStatus();
        tc.availableVehicle("Herne Bay");
    }
}
