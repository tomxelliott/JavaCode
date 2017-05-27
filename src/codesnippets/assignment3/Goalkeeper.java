import java.util.Random;
/**
 * Write a description of class Goalkeeper here.
 * 
 * @author (Tom Elliott) 
 * @version (1.0)
 */
public class Goalkeeper implements Footballer
{
    //instance variables of Goalkeeper
    private final String firstName;
    private final String secondName;
    private final String nationality;
    private int retirementAge;
    private int shirtNumber;
    
    /**
     * Constructor for objects of class Goalkeeper.
     * Three Strings are passed as parameters.
     * The firstName, secondName and nationality assigned in the constructor are all final,
     * and immutable.
     * 
     * @param firstName The first name of the Goalkeeper.
     * @param secondName The surname of the Goalkeeper.
     * @param nationality The country where the Goalkeeper was born or has citizenship.
     */
    public Goalkeeper(String firstName, String secondName, String nationality)
    {
        this.firstName = firstName;
        this.secondName = secondName;
        this.nationality = nationality;
        generateShirtNumber(100);
    }
    
    /**
     * This method generates a shirt number for said Footballer.
     * The method takes a single integer as a parameter which will be the upper bound.
     * The method assigns a value to the field shirtNumber.
     * This method can be called again after creation of instance to generate new shirt number.
     * 
     * @param  max The value passed here is the exclusive upper bound. 
     * @return  The method returns the randomly generated shirt number.
     */
    public int generateShirtNumber(int max)
    {
        Random randomTester = new Random();
        int random = 0;
        random = randomTester.nextInt(max);
        shirtNumber = random;
        return random; 
    }
    
    /**
     * Returns the first name of Goalkeeper instance
     */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     * Returns the surname of the Goalkeeper instance.
     */
    public String getSecondName()
    {
        return secondName;
    }
     
    /**
     * Returns the value of the shirt number.
     * The field is initialised at creation of instance by a call to generateShirtNumber.
     * This method can be called as many times as required.
     */
    public int getShirtNumber()
    {
        return shirtNumber;
    }
}
