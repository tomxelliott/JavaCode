import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
/**
 * Write a description of class RandomTester here.
 * 
 * @author (Tom Elliott) 
 * @version (Version 1 - October 27th 2016)
 */
public class RandomTester
{
    // instance variables - replace the example below with your own
    private Random randomTester;
    private int x;
    private ArrayList<String> responses;
    /**
     * Constructor for objects of class RandomTester
     */
    public RandomTester()
    {
        randomTester = new Random();
        responses = new ArrayList<>();
        fillResponses();
    }


    public int printOneRandom()
    {
       Random randomTester = new Random(); 
       int value = randomTester.nextInt(10); 
       System.out.println(value);
       return value;
        }
    
        
    public int printMultiRandom(int howMany){
        Random randomTester = new Random();
         int count = 1;
        while (count <= howMany) {
            System.out.println(randomTester.nextInt(10));
            count++;
    }
    return howMany;
    }
    
    public int throwDie()
    {
       Random diceTest = new Random();
       int face = diceTest.nextInt(7);
       if (face==0){
           face = face + 1;
        }
        else{
       System.out.println(face);
              }
       return face;
    }
    
    public String getResponse()
    {
        int index = randomTester.nextInt(responses.size());
        return responses.get(index);
    }
    
    private void fillResponses()
    {
        responses.add("yes");
        responses.add("no");
        responses.add("maybe");
        responses.add("Hola:");
        responses.add("please");
        responses.add("Awesome!!");
    }
    
    public int maxNumber(int max)
    {
        Random tester = new Random();
        int test = tester.nextInt(max + 1);
        if(test==0){
            test = test + 1;
        }
        else{
            System.out.println(test);
        }
        return test;
    }
    
    public int maxNumberBetween(int min, int max)
    {
        Random testCase = new Random();
        int number = testCase.nextInt(max + 1);
        if(number < min){
            number = min + 1;
        }
        else{
            System.out.println(number);
        }
        return number;
    
    }
}
