import java.util.*;

/**
 * Write a description of class NameGenerator here.
 * 
 * @author (Tom Elliott) 
 * @version (Version 1.0 - 02/11/16)
 */
public class NameGenerator {

    private String firstName;
    private String secondName;
    private String mothersMaidenName;
    private String birthLocation;

    /**
     * Constructor for objects of class NameGenerator
     */
    public NameGenerator()
    {
        firstName = null;
        secondName = null;
        mothersMaidenName = null;
        birthLocation = null;
        
}
    
    public NameGenerator(String firstName, String secondName, String mothersMaidenName, String birthLocation){
        this.firstName = firstName;
        this.secondName = secondName;
        this.mothersMaidenName = mothersMaidenName;
        this.birthLocation = birthLocation;
}

    public void setFirstName(String name){
        firstName = name;
}
    
    public String getFirstName(){
        return firstName;
}
    
    public void setSecondName(String name){
        secondName = name;
}
    
    public String getSecondName(){
        return secondName;
}
    
    public void setMothersMaidenName(String name){
        mothersMaidenName = name;
}
    
    public String getMothersName(){
        return mothersMaidenName;
}
    
    public void setBirthLocation(String location){
        birthLocation = location;
}
    
    public String getBirthLocation(){
        return birthLocation;
}
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String generateStarWarsName()
    {
     String name = firstName;
     String surname = secondName;
     String maiden = mothersMaidenName;
     String location = birthLocation;
     String StarWarsName = surname.substring(0, 3) + name.substring(0, 2) + " " + maiden.substring(0,2) + location.substring(0,3);
     System.out.println("Your Star Wars name is: ");
     System.out.println(StarWarsName.toLowerCase());
     return StarWarsName;
}
}
