
/**
 * An interface representing Football players, designed to be implemented by Football positions.
 * This interface defines a method to assign shirt numbers to any position class that implements it.
 * 
 * @author (Tom Elliott) 
 * @version (1.0)
 */
public interface Footballer
{
    /**
     * This method generates a shirt number for said Footballer.
     * The method takes a single integer as a parameter which will be the upper bound.
     * 
     * @param  max The value passed here is the exclusive upper bound. 
     * @return  The method returns the randomly generated shirt number.
     */
    int generateShirtNumber(int max);
}
