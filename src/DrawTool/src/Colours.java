import java.awt.Color;
import java.util.*;

/**
 *  This class exists specifically to create and store all of the colours
 *  that we need for the DrawingTool.
 *  It is a good example of cohesion in that this class has a well defined role
 *  and it fulfils as single purpose.
 *  By storing all of the colours in this class, we can add and subtract colours
 *  from the HashMap with ease, and we can do so without needing to change any
 *  code in the DrawingTool class. I believe this helps maintain loose coupling.
 * 
 * @author (Tom Elliott) 
 * @ 1.0 (29.11.16)
 */
public class Colours
{
    // HashMap to store the 6 colours we need for the draw tool.
    private HashMap<String, Color> colorMap;

    /**
     * Constructor for objects of class Colours. 
     * A HashMap is created that will store out colours for the drawing tool.
     */
    public Colours()
    {
        colorMap = new HashMap<>();
    }

    /**
     * Add all the colours and their associated Strings to the HashMap.
     * This method is called from the DrawingTool constructor.
     * We can easily add and remove colours from this method.
     * These changes in turn can easily be implemented in DrawingTool 
     * without any change to the code in DrawingTool.
     */
    public void addColors()
    {
        colorMap.put("red", Color.RED);
        colorMap.put("blue", Color.BLUE);
        colorMap.put("yellow", Color.YELLOW);
        colorMap.put("magenta", Color.MAGENTA);
        colorMap.put("green", Color.GREEN);
        colorMap.put("black", Color.BLACK);
    }
}
