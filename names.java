import java.util.*;

/**
 * Write a description of class NameGenerator here.
 * 
 * @author (Tom Elliott) 
 * @version (Version 1.0 - 02/11/16)
 */
public class NameGenerator
{
    /**
     * Constructor for objects of class NameGenerator
     */
    public NameGenerator()
    {
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String generateStarWarsName(String firstName, String secondName, String mothersMaidenName, String birthLocation)
    {
        String name = firstName;
        String surname = secondName;
        String maiden = mothersMaidenName;
        String location = birthLocation;
        String StarWarsName = secondName.substring(0, 3) + name.substring(0, 2) + " " + maiden.substring(0,2) + location.substring(0,3);
        System.out.println("Your Star Wars name is: ");
        System.out.println(StarWarsName.toUpperCase());
        return StarWarsName.toUpperCase();
    }
}

