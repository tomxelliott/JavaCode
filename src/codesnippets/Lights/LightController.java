import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * This class handles the logic for the program.
 * Is the central hub for the program with small details handled by relevant classes.
 * This class is instantiated in the Main method.
 *
 * @author (Tom Elliott)
 * @ 1.0 (21/07/17)
 */
public class LightController {

    private LightColours colours;

    // String to store the value of colour retrieved from the ArrayList.
    private String color;
    // String to hold the time when printed to the console.
    private String timeStamp;
    // Boolean value to determine whether the light is switched on.
    private boolean switchedOn;
    // Integer value for the number of light bulbs.
    private int lightBulbs;

    /**
     * Constructor that takes arguments received from the command line.
     * @param lightBulbs Quantity received from command line argument that generates number of light bulbs.
     */
    public LightController(int lightBulbs) {
        colours = new LightColours();
        switchedOn = false;
        this.lightBulbs = lightBulbs;
    }

    /**
     * Method to commence the light process.
     * Using built in Java time delay, initiate 1 second delay between each light action.
     * This method has been constructed so it uses the size of the Map to control the flow of the loop.
     */
    public void powerUp()
            throws InterruptedException {
        int x = 0;
        int y = colours.colourSize();
        while(x <= lightBulbs) {
            if(x == y){
                x = 0;
            }
            else {
                color = colours.getColour(x);
                switchOn();
                TimeUnit.SECONDS.sleep(1);
                switchOff();
                TimeUnit.SECONDS.sleep(1);
                x++;
            }
        }
    }

    /**
     * Method to switch the light on.
     * The if statement checks the boolean value of switchedOn is false before carrying out the action.
     */
    private void switchOn() {
        if(switchedOn == false) {
            timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
            System.out.println(timeStamp + ": " + color + " Light On");
            switchedOn = true;
        }
        else{
            System.out.println("The light is already on!");
        }
    }

    /**
     * Method to switch the light off.
     * The if statement checks the boolean value of switchedOn is true before carrying out the action.
     */
    private void switchOff() {
        if (switchedOn == true) {
            timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
            System.out.println(timeStamp + ": " + color + " Light Off");
            switchedOn = false;
        }
        else{
            System.out.println("The light is already off!");
        }
    }

    /**
     * Getter method to return the value of the Colour variable.
     * @return The current colour that has been assigned to the class variable colour.
     */
    public String getColor() {
        return color;
    }

    /**
     * Getter method for the timeStamp field.
     * In order to give the accurate time, the timeStamp must be updated at the time the method is called.
     * @return The Time value at the time the method is called in String format(Hours:Mins:Secs).
     */
    public String getTimeStamp() {
        timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }

    /**
     * Getter method that returns the boolean value for switchedOn.
     * @return The boolean value for switchedOn.
     */
    public boolean getLightStatus() {
        return switchedOn;
    }
}
