/**
 * @author (Tom Elliott)
 * @ 1.0 (21/07/17)
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        try {
            Helper helper = new Helper();
            if (args.length == 0) {
                // Base case for the program.
                // Runs program with default colours and default value of 20 for the bulb count.
                LightController lc = new LightController(20);
                // power up the program with default value of 20 lights
                lc.powerUp();
            }
            else if (helper.isAnInteger(args[0])) {
                // convert the string argument to integer value so that it can be parsed.
                int x = helper.convertToInteger(args[0]);
                LightController lightCon = new LightController(x);
                lightCon.powerUp();
            }
            else if (args.length > 1 || !(helper.isAnInteger(args[0]))) {
                System.out.println("All input values MUST be numeric...");
                System.out.println("This program takes 1 argument or less...");
            }
        }
        catch (Exception e) {
            System.err.println("Error, program aborted!");
            System.exit(1);
        }
        finally {
            System.out.println("Program Closed...");
        }
    }
}
