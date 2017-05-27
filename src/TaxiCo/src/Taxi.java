/**
 * A taxi.
 * They are either free or occupied.
 * 
 * @author Tom Elliott 
 * @version 2016.12.03
 */
public class Taxi extends Vehicle
{
    // Whether it is free or not.
    private boolean free;
    
    /**
     * Constructor for objects of class Taxi.
     * @param base The name of the company's base.
     * @param id This taxi's unique id.
     */
    public Taxi(String location, String id)
    {
        super(id);
        setLocation(location);
        free = true;
    }
    
    /**
     * Book this taxi to the given destination.
     * The status of the taxi will no longer be free.
     * @param destination The taxi's destination.
     */
    public void book(String destination)
    {
        setDestination(destination);
        free = false;
    }
    
    /**
     * Check to see if the Taxi is currently booked.
     * @return True if the Taxi is not booked. False if the Taxi is booked.
     */
    public boolean isFree()
    {
        return free;
    }
    
    /**
     * Indicate that this taxi has arrived at its destination.
     * As a result, it will be free.
     */
    public void arrived()
    {
        setLocation(getDestination());
        setDestination(null);
        free = true;
    }
}
