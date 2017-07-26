/**
 * Helper class to handle arguments when Main class is run.
 * By keeping helper methods here, we are able to maintain separation of concerns.
 * In future iterations of the program, any helper methods can be added into this class.
 *
 * @author (Tom Elliott)
 * @ 1.0 (24/07/17)
 */
public class Helper {

    public Helper() {
        // No action carried out upon instantiation.
    }

    /**
     * Determine whether the given string is an integer or not.
     * @return true if it is an integer, false otherwise.
     */
    public boolean isAnInteger(String word) {
        boolean ok;
        try {
            Integer.parseInt(word);
            ok = true;
        }
        catch(NumberFormatException ex) {
            // Non-integer string.
            ok = false;
        }
        return ok;
    }

    /**
     * Convert the given string to an integer.
     * NB: It is assumed that the string has already been checked
     * for validity. An exception will be thrown if the string
     * is not a valid integer.
     * @param word The string to be converted.
     * @return The integer represented by the parameter.
     */
    public int convertToInteger(String word)
            throws IllegalArgumentException {
        return Integer.parseInt(word);
    }
}
