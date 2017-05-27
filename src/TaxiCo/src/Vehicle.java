/**
 * A vehicle Super Class.
 * 
 * Each Vehicle has a unique ID, a location and sometimes a destination.
 * 
 * @author (Tom Elliott) 
 * @version (1.0)
 */
public class Vehicle
{
    // A unique ID for this vehicle.
    private String id;
    // The destination of a taxi or a shuttle on its circular route.
    private String destination;
    // The location of this vehicle.
    private String location;

    /**
     * Constructor for objects of class Vehicle
     * An ID is passed as a Parameter and assigned for each Vehicle that is created.
     * In the Super Class, the destination is set to null.
     */
    public Vehicle(String id)
    {
        this.id = id;
        destination = null;
    }
    
    /**
     * Return the status of this vehicle.
     * @return The status.
     */
    public String getStatus()
    {
        if(destination == null) {
            return id + " is currently at " + location +  " and is available for bookings.";
        }
        else{
            return id + " at " + location + " headed for " +
               destination;
        }
    }
    
    /**
     * Return the ID of the vehicle.
     * @return The ID of the vehicle.
     */
    public String getID()
    {
        return id;
    }
    
    /**
     * Set the location of the vehicle.
     * @param the location The vehicle location.
     */
    public void setLocation(String location) 
    {
        this.location = location;
    }
    
    /**
     * Return the location of the vehicle.
     * @return The location of the vehicle.
     */
    public String getLocation()
    {
        return location;
    }
    
    /**
     * Return the destination of the vehicle.
     * @return The destination of the vehicle.
     */
    public String getDestination()
    {
        return destination;
    }
    
    /**
     * Set the intented destination of the vehicle.
     * @param destination The intended destination.
     */
    public void setDestination(String destination)
    {
        this.destination = destination;
    }
}
