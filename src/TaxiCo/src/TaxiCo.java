import java.util.*;

/**
 * A Taxi Company manages a fleet of taxis and shuttles.
 * Taxis move between single destinations.
 * Shuttles move around circular routes.
 * 
 * @author Tom Elliott 
 * @version 2016.12.03
 */
public class TaxiCo
{
    // The name of this company.
    private String companyName;
    // The name of the company's base.
    private final String base;    
    // The fleet of vehicles (includes all Taxis & Shuttles).
    private ArrayList<Vehicle> fleet;
    // A value for allocating taxi ids.
    private int nextID;
    // A list of available destinations for shuttles.
    private ArrayList<String> destinations;

    /**
     * Constructor for objects of class TaxiCo.
     * @param name The name of this company.
     */
    public TaxiCo(String name)
    {
        companyName = name;
        base = "base";
        fleet = new ArrayList<Vehicle>();
        nextID = 1;
        destinations = new ArrayList<String>();
        fillDestinations();
    }
    
    /**
     * Record that we have a new taxi.
     * A unique ID will be allocated.
     */
    public void addTaxi()
    {
        Taxi taxi = new Taxi(base, "Car #" + nextID);
        fleet.add(taxi);
        // Increment the ID for the next one.
        nextID++;
    }
    
    /**
     * Record that we have a new shuttle.
     * An arbitrary route is assigned to it.
     */
    public void addShuttle()
    {
        // Sanity warning:
        // The following is a thoroughly contrived way to create a route!
        
        // Create a random list of destinations for its route.
        Collections.shuffle(destinations);
        ArrayList<String> route = new ArrayList<String>();
        // The starting point is always the base.
        route.add(base);
        // Decide on an (arbitrary) length for all routes.
        final int ROUTE_LENGTH = 3;
        for(int i = 0; i < ROUTE_LENGTH; i++) {
            route.add(destinations.get(i));
        }
        
        Shuttle shuttle = new Shuttle("Shuttle #" + nextID, route);
        fleet.add(shuttle);
        // Increment the ID for the next one.
        nextID++;
    }
    
    /**
     * Return the vehicle with the given id.
     * @param id The id of the vehicle to be returned.
     * @return The matching vehicle, or null if no match is found.
     */
    public Vehicle lookup(String id)
    {
        boolean found = false;
        Vehicle vehicle = null;
        Iterator<Vehicle> it = fleet.iterator();
        while(!found && it.hasNext()) {
            vehicle = it.next();
            if(id.equals(vehicle.getID())) {
                found = true;
            }
        }
        if(found) {
            return vehicle;
        }
        else {
            return null;
        }
    }
    
    /**
     * Return the Shuttle that is en route to the customers desired destination.
     * Or any Taxi that is idle or currently has its destination set to "null".
     * @param destination The destination that the customer wants to go to
     * @return The vehicle that can fulfill the customers requirements.
     */
    public Vehicle availableVehicle(String destination)
    {
        Vehicle availableVehicle = null;
        for(Vehicle freeShuttle : fleet) {
            /* 
             * Loop through all of the Vehicle instances to see if there is a shuttle 
             * that is going to the destination requested and meets our customers needs. 
             * If there is one, this is assigned to the local variable "availableVehicle" and is returned.
             */
            if(freeShuttle instanceof Shuttle && destination.equals(freeShuttle.getDestination())){
                Shuttle shuttle = (Shuttle) freeShuttle;
                availableVehicle = shuttle;
                return availableVehicle;
            }
        }
        for(Vehicle freeTaxi : fleet) {
            /*
             * Same as with the shuttle search. 
             * We repeat the same process, except this time we are looking for any Taxi's that are free and can be booked by our customer.
             * We only get to this search if there are no shuttles that meet our customers needs.
             */
            if(freeTaxi instanceof Taxi && ((Taxi)freeTaxi).isFree()){
                Taxi taxi = (Taxi) freeTaxi;
                availableVehicle = taxi;
                return availableVehicle;
            }
        }
        if(availableVehicle == null) {
            /*
             * If there are no shuttles going to the customers destination and no free taxis, 
             * we return availableVehicle which is null by default.
             */
            return availableVehicle;
        }
        return availableVehicle;
    }
    
    /**
     * Show the status of the fleet of taxis and shuttles. 
     */
    public void showStatus()
    {
        System.out.println("Current status of the " + companyName + " fleet");
        for(Vehicle vehicle : fleet) {
            System.out.println(vehicle.getStatus());
        }
    }
    
    /**
     * Put all the possible shuttle destinations in a list.
     */
    private void fillDestinations()
    {
        destinations.add("Canterbury West");
        destinations.add("Canterbury East");
        destinations.add("The University");
        destinations.add("Whitstable");
        destinations.add("Herne Bay");
        destinations.add("Sainsbury's");
        destinations.add("Darwin");
    }
}
