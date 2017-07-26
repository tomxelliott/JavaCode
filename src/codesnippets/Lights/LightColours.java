import java.util.HashMap;
import java.util.EnumSet;

/**
 * Class to store the colours for the light.
 * By storing the colours in this class, colours can easily be added and subtracted from the HashMap.
 * This class helps reduce coupling.
 *
 * @author (Tom Elliott)
 * @ 1.0 (21/07/17)
 */
public class LightColours
{

    private HashMap<Integer, String> colourMap;

    /**
     * A HashMap is created and populated for use in the program.
     * The key is the numeric index and the value is the String colour stored at said index.
     * The map is populated with the 10 colours stored in the Enum class.
     */
    public LightColours() {
        colourMap = new HashMap<>();
        generateColours();
    }

    /**
     * Using a For Each loop, the HashMap is populated with the colours from the Enum class.
     * The Map is populated with only the 10 colours in the Enum class.
     * The way the Enum class has been created, colours can easily be removed and added without the need
     * to touch any of the other code in the program.
     *
     * The code to populate the Map will only execute if the Map is empty.
     */
    private void generateColours() {
        if(colourMap.isEmpty()) {
            int x = 0;
            for (Colours colours : EnumSet.allOf(Colours.class)) {
                String colourValue = colours.toString().toLowerCase();
                String outputColour = colourValue.substring(0, 1).toUpperCase() + colourValue.substring(1);
                colourMap.put(x, outputColour);
                x++;
            }
        }
        else {
            System.out.println("This action can only be performed on an empty Collection.");
        }
    }

    /**
     * Method to access colours from the array.
     * @param n  The index value for the colour required from the String array.
     * @return The String value of the colour from the array.
     */
    public String getColour(int n)
            throws IndexOutOfBoundsException {
        return colourMap.get(n);
    }

    /**
     * Method to return the size of the colours ArrayList.
     * @return integer value for total number of colours within the ArrayList.
     */
    public int colourSize() {
        return colourMap.size();
    }
}
